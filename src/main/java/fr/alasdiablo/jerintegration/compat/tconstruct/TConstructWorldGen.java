package fr.alasdiablo.jerintegration.compat.tconstruct;

import fr.alasdiablo.jerintegration.api.WorldGenIntegration;
import jeresources.api.IWorldGenRegistry;
import jeresources.api.distributions.DistributionBase;
import jeresources.api.distributions.DistributionHelpers;
import jeresources.api.distributions.DistributionSquare;
import jeresources.api.distributions.DistributionTriangular;
import jeresources.api.drop.LootDrop;
import jeresources.api.restrictions.Restriction;
import net.minecraft.world.item.ItemStack;
import slimeknights.tconstruct.common.config.Config;
import slimeknights.tconstruct.world.TinkerWorld;

public class TConstructWorldGen extends WorldGenIntegration {
    @Override
    public void registerWorldGen(IWorldGenRegistry registry) {
        if (Config.COMMON.generateCobalt.get()) {
            final DistributionBase distributionSmallOre = new DistributionSquare( // COBALT_ORE_FEATURE_SMALL
                Config.COMMON.veinCountCobalt.get() / 2,
                4,
                10,
                108
            );
            final DistributionBase distributionLargeOre = new DistributionTriangular( // COBALT_ORE_FEATURE_LARGE
                32,
                16,
                DistributionHelpers.calculateChance(
                        Config.COMMON.veinCountCobalt.get() / 2,
                        8, 16, 48
                )
            );

            final DistributionBase distribution = DistributionHelpers.addDistribution(distributionSmallOre, distributionLargeOre);

            final Restriction restriction = Restriction.NETHER;

            final ItemStack cobaltStack = new ItemStack(TinkerWorld.cobaltOre.get());

            final LootDrop cobaltDrop = new LootDrop(cobaltStack);

            registry.register(cobaltStack, distribution, restriction, cobaltDrop);
        }
    }
}