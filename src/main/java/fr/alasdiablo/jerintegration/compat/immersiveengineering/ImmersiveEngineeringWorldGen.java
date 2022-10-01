package fr.alasdiablo.jerintegration.compat.immersiveengineering;

import blusunrize.immersiveengineering.common.config.IEServerConfig;
import blusunrize.immersiveengineering.common.register.IEBlocks;
import blusunrize.immersiveengineering.common.register.IEItems;
import fr.alasdiablo.jerintegration.api.WorldGenIntegration;
import jeresources.api.IWorldGenRegistry;
import jeresources.api.conditionals.Conditional;
import jeresources.api.distributions.DistributionBase;
import jeresources.api.distributions.DistributionSquare;
import jeresources.api.distributions.DistributionTriangular;
import jeresources.api.drop.LootDrop;
import jeresources.compatibility.CompatBase;
import jeresources.entry.WorldGenEntry;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public class ImmersiveEngineeringWorldGen extends WorldGenIntegration {
    @Override
    public void registerWorldGen(IWorldGenRegistry registry) {
        IEServerConfig.ORES.ores.forEach((veinType, oreConfig) -> {
            IEBlocks.BlockEntry<Block>  ore    = IEBlocks.Metals.ORES.get(veinType.metal);
            IEItems.ItemRegObject<Item> rawOre = IEItems.Metals.RAW_ORES.get(veinType.metal);
            if (ore != null && ore.get() != null) {
                DistributionBase distribution;

                if ((IEServerConfig.CONFIG_SPEC.isLoaded() ? oreConfig.distribution.get() : oreConfig.distribution.getDefault())
                        == IEServerConfig.Ores.OreDistribution.UNIFORM) {
                    distribution = new DistributionSquare(
                            IEServerConfig.getOrDefault(oreConfig.veinsPerChunk),
                            IEServerConfig.getOrDefault(oreConfig.veinSize),
                            IEServerConfig.getOrDefault(oreConfig.minY),
                            IEServerConfig.getOrDefault(oreConfig.maxY)
                    );
                } else {
                    int range = (IEServerConfig.getOrDefault(oreConfig.maxY) - IEServerConfig.getOrDefault(oreConfig.minY)) / 2;
                    int midY  = range + IEServerConfig.getOrDefault(oreConfig.minY);
                    distribution = new DistributionTriangular(
                            IEServerConfig.getOrDefault(oreConfig.veinsPerChunk),
                            IEServerConfig.getOrDefault(oreConfig.veinSize),
                            midY, range
                    );
                }
                registry.register(
                        new ItemStack(ore),
                        distribution,
                        true,
                        new LootDrop(
                                new ItemStack(rawOre.get()),
                                1, 1,
                                Conditional.affectedByFortune
                        )
                );
            }
        });
    }
}
