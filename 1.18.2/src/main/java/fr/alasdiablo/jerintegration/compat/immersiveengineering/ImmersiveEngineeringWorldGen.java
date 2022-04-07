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

                try {
                    if (oreConfig.distribution.get() == IEServerConfig.Ores.OreDistribution.UNIFORM) {
                        distribution = new DistributionSquare(
                                oreConfig.veinsPerChunk.get(), oreConfig.veinSize.get(), oreConfig.minY.get(), oreConfig.maxY.get());
                    } else {
                        int range = (oreConfig.maxY.get() - oreConfig.minY.get()) / 2;
                        int midY  = range + oreConfig.minY.get();
                        distribution = new DistributionTriangular(oreConfig.veinsPerChunk.get(), oreConfig.veinSize.get(), midY, range);
                    }
                } catch (NullPointerException ignored) {
                    distribution = new DistributionSquare(oreConfig.veinsPerChunk.get(), oreConfig.veinSize.get(), oreConfig.minY.get(), oreConfig.maxY.get());
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
