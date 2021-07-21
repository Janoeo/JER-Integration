package fr.alasdiablo.jerintegration.compat.tconstruct;

import fr.alasdiablo.jerintegration.api.WorldGenIntegration;
import jeresources.api.IWorldGenRegistry;
import jeresources.api.distributions.*;
import jeresources.api.drop.LootDrop;
import jeresources.api.restrictions.BiomeRestriction;
import jeresources.api.restrictions.Restriction;
import net.minecraft.item.ItemStack;
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
                    ((Config.COMMON.veinCountCobalt.get() / 2f) / 8f) / 100f
            );

            final DistributionBase distribution = DistributionHelpers.addDistribution(distributionSmallOre, distributionLargeOre);

            final Restriction restriction = new Restriction(BiomeRestriction.NETHER);

            final ItemStack cobaltStack = new ItemStack(TinkerWorld.cobaltOre.get());

            final LootDrop cobaltDrop = new LootDrop(cobaltStack);

            registry.register(cobaltStack, distribution, restriction, cobaltDrop);
        }

        if (Config.COMMON.generateCopper.get()) { // COPPER_ORE_FEATURE
            final DistributionBase distribution = new DistributionSquare(
                    Config.COMMON.veinCountCopper.get() / 2,
                    9,
                    40,
                    60
            );

            final ItemStack copperStack = new ItemStack(TinkerWorld.copperOre.get());

            final LootDrop copperDrop = new LootDrop(copperStack);

            registry.register(copperStack, distribution, copperDrop);
        }
    }
}
