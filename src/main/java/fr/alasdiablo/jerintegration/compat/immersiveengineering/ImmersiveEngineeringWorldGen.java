package fr.alasdiablo.jerintegration.compat.immersiveengineering;

import blusunrize.immersiveengineering.common.config.IEServerConfig;
import blusunrize.immersiveengineering.common.register.IEBlocks;
import blusunrize.immersiveengineering.common.register.IEItems;
import fr.alasdiablo.jerintegration.api.WorldGenIntegration;
import fr.alasdiablo.jerintegration.util.JERIntegrationUtils;
import jeresources.api.IWorldGenRegistry;
import jeresources.api.distributions.DistributionBase;
import jeresources.api.distributions.DistributionSquare;
import jeresources.api.distributions.DistributionTriangular;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public class ImmersiveEngineeringWorldGen extends WorldGenIntegration {
    @Override
    public void registerWorldGen(IWorldGenRegistry registry) {
        IEServerConfig.ORES.ores.forEach((veinType, oreConfig) -> {
            IEBlocks.BlockEntry<Block> ore_normal = IEBlocks.Metals.ORES.get(veinType.metal);
            IEBlocks.BlockEntry<Block> ore_deepslate = IEBlocks.Metals.DEEPSLATE_ORES.get(veinType.metal);
            IEItems.ItemRegObject<Item> rawOre = IEItems.Metals.RAW_ORES.get(veinType.metal);
            if (ore_normal != null && ore_normal.get() != null) {
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
                    int midY = range + IEServerConfig.getOrDefault(oreConfig.minY);
                    distribution = new DistributionTriangular(
                            IEServerConfig.getOrDefault(oreConfig.veinsPerChunk),
                            IEServerConfig.getOrDefault(oreConfig.veinSize),
                            midY, range
                    );
                }
                JERIntegrationUtils.register(registry,
                        new ItemStack(ore_normal),
                        new ItemStack(ore_deepslate),
                        new ItemStack(rawOre.get()),
                        distribution);
            }
        });
    }
}
