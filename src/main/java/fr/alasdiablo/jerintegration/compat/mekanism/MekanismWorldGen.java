package fr.alasdiablo.jerintegration.compat.mekanism;

import fr.alasdiablo.jerintegration.api.WorldGenIntegration;
import fr.alasdiablo.jerintegration.util.WorldContext;
import jeresources.api.IWorldGenRegistry;
import jeresources.api.conditionals.Conditional;
import jeresources.api.distributions.DistributionBase;
import jeresources.api.distributions.DistributionSquare;
import jeresources.api.distributions.DistributionTriangular;
import jeresources.api.drop.LootDrop;
import mekanism.common.config.MekanismConfig;
import mekanism.common.config.WorldConfig;
import mekanism.common.registries.MekanismBlocks;
import mekanism.common.registries.MekanismItems;
import mekanism.common.resource.ResourceType;
import mekanism.common.resource.ore.OreBlockType;
import mekanism.common.resource.ore.OreType;
import mekanism.common.util.EnumUtils;
import mekanism.common.world.height.ConfigurableHeightRange;
import mekanism.common.world.height.HeightShape;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.WorldGenerationContext;

import java.util.Objects;

@SuppressWarnings("SuspiciousMethodCalls")
public class MekanismWorldGen extends WorldGenIntegration {
    @Override
    public void registerWorldGen(IWorldGenRegistry registry) {
//        for (OreType type : EnumUtils.ORE_TYPES) {
//            int features = type.getBaseConfigs().size();
//            for (int vein = 0; vein < features; vein++) {
//                OreType.OreVeinType oreVeinType  = new OreType.OreVeinType(type, vein);
//                WorldConfig.OreVeinConfig oreVeinConfig = MekanismConfig.world.getVeinConfig(oreVeinType);
//                OreType oreType = oreVeinType.type();
//                OreBlockType        oreBlockType = MekanismBlocks.ORES.get(oreType);
//                IntSupplier         maxVienSize  = oreVeinConfig.maxVeinSize();
//                IntSupplier             perChuck = oreVeinConfig.perChunk();
//                ConfigurableHeightRange range     = oreVeinConfig.range();
//            }
//        }

        WorldContext fakeContext = new WorldContext();
        for (OreType type: EnumUtils.ORE_TYPES) {
            int features = type.getBaseConfigs().size();

            for (int vein = 0; vein < features; ++vein) {
                var oreVeinType = new OreType.OreVeinType(type, vein);
                var oreVeinConfig = MekanismConfig.world.getVeinConfig(oreVeinType);

                if (oreVeinConfig.shouldGenerate().getAsBoolean()) {
                    OreBlockType oreBlockType = MekanismBlocks.ORES.get(oreVeinType.type());

                    DistributionBase distribution;

                    if (oreVeinConfig.range().shape().get() == HeightShape.UNIFORM) {
                        distribution = new DistributionSquare(
                                oreVeinConfig.perChunk().getAsInt(),
                                oreVeinConfig.maxVeinSize().getAsInt(),
                                oreVeinConfig.range().minInclusive().resolveY(fakeContext),
                                oreVeinConfig.range().maxInclusive().resolveY(fakeContext)
                        );
                    } else {
                        int range = (oreVeinConfig.range().maxInclusive().resolveY(fakeContext) - oreVeinConfig.range().minInclusive().resolveY(fakeContext)) / 2;
                        int midY  = range + oreVeinConfig.range().minInclusive().resolveY(fakeContext);
                        distribution = new DistributionTriangular(
                                oreVeinConfig.perChunk().getAsInt(),
                                oreVeinConfig.maxVeinSize().getAsInt(),
                                midY, range
                        );
                    }

                    if (type.getResource().getRegistrySuffix().equals("fluorite")) {
                        Item rawOre = MekanismItems.FLUORITE_GEM.asItem();

                        registry.register(
                                new ItemStack(oreBlockType.stoneBlock()),
                                distribution,
                                true,
                                new LootDrop(
                                        new ItemStack(rawOre),
                                        1, 1,
                                        Conditional.affectedByFortune
                                )
                        );
                    } else {
                        Item rawOre = Objects.requireNonNull(MekanismItems.PROCESSED_RESOURCES.get(
                                ResourceType.RAW,
                                type.getResource()
                        )).asItem();

                        registry.register(
                                new ItemStack(oreBlockType.stoneBlock()),
                                distribution,
                                true,
                                new LootDrop(
                                        new ItemStack(rawOre),
                                        1, 1,
                                        Conditional.affectedByFortune
                                )
                        );
                    }
                }
            }
        }
    }
}
