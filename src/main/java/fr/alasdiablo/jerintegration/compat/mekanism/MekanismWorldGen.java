package fr.alasdiablo.jerintegration.compat.mekanism;

import fr.alasdiablo.jerintegration.api.WorldGenIntegration;
import jeresources.api.IWorldGenRegistry;
import jeresources.api.conditionals.Conditional;
import jeresources.api.distributions.DistributionBase;
import jeresources.api.distributions.DistributionSquare;
import jeresources.api.distributions.DistributionTriangular;
import jeresources.api.drop.LootDrop;
import mekanism.common.config.MekanismConfig;
import mekanism.common.registries.MekanismBlocks;
import mekanism.common.registries.MekanismFeatures;
import mekanism.common.registries.MekanismItems;
import mekanism.common.resource.ResourceType;
import mekanism.common.resource.ore.OreBlockType;
import mekanism.common.resource.ore.OreType;
import mekanism.common.util.EnumUtils;
import mekanism.common.world.height.HeightShape;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.Objects;

@SuppressWarnings("SuspiciousMethodCalls")
public class MekanismWorldGen extends WorldGenIntegration {
    @Override
    public void registerWorldGen(IWorldGenRegistry registry) {
        OreType[] oreTypes = EnumUtils.ORE_TYPES;

        for (OreType type: oreTypes) {
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
                                oreVeinConfig.range().minInclusive().value().getAsInt(),
                                oreVeinConfig.range().maxInclusive().value().getAsInt()
                        );
                    } else {
                        int range = (oreVeinConfig.range().maxInclusive().value().getAsInt() - oreVeinConfig.range().minInclusive().value().getAsInt()) / 2;
                        int midY  = range + oreVeinConfig.range().minInclusive().value().getAsInt();
                        distribution = new DistributionTriangular(
                                oreVeinConfig.perChunk().getAsInt(),
                                oreVeinConfig.maxVeinSize().getAsInt(),
                                midY, range
                        );
                    }

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
