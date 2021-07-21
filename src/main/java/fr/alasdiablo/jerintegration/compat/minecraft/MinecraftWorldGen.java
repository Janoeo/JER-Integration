package fr.alasdiablo.jerintegration.compat.minecraft;

import fr.alasdiablo.jerintegration.api.WorldGenIntegration;
import fr.alasdiablo.jerintegration.api.restrictions.RestrictionBasaltDeltas;
import jeresources.api.IWorldGenRegistry;
import jeresources.api.distributions.DistributionBase;
import jeresources.api.distributions.DistributionHelpers;
import jeresources.api.distributions.DistributionSquare;
import jeresources.api.distributions.DistributionTriangular;
import jeresources.api.drop.LootDrop;
import jeresources.api.restrictions.Restriction;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class MinecraftWorldGen extends WorldGenIntegration {
    @Override
    public void registerWorldGen(IWorldGenRegistry registry) {
        this.registerOreDebris(registry);
        final DistributionBase distributionGoldDeltas = new DistributionSquare(
                20, 10, 10, 108
        );
        final DistributionBase distributionGoldNether = new DistributionSquare(
                10, 10, 10, 108
        );
        final DistributionBase distributionQuartzDeltas = new DistributionSquare(
                32, 14, 10, 108
        );
        final Restriction restrictionNether = Restriction.NETHER;

        final Restriction restrictionDeltas = new RestrictionBasaltDeltas();

        final ItemStack quartzStack = new ItemStack(Items.QUARTZ, 4);

        final ItemStack goldNuggetStack = new ItemStack(Items.GOLD_NUGGET, 6);

        registry.register(new ItemStack(Blocks.NETHER_GOLD_ORE), distributionGoldDeltas, restrictionDeltas, new LootDrop(goldNuggetStack));
        registry.register(new ItemStack(Blocks.NETHER_GOLD_ORE), distributionGoldNether, restrictionNether, new LootDrop(goldNuggetStack));
        registry.register(new ItemStack(Blocks.NETHER_QUARTZ_ORE), distributionQuartzDeltas, restrictionDeltas, new LootDrop(quartzStack));
    }

    private void registerOreDebris(IWorldGenRegistry registry) {
        DistributionBase distributionDebrisLarge = new DistributionTriangular(
                16,
                8,
                DistributionHelpers.calculateChance(1, 3, 8, 24)
        );
        DistributionBase distributionDebrisSmall = new DistributionSquare(
                1, 2, 8, 112
        );

        final DistributionBase distribution = DistributionHelpers.addDistribution(distributionDebrisLarge, distributionDebrisSmall);

        final Restriction restriction = Restriction.NETHER;

        final ItemStack debrisStack = new ItemStack(Blocks.ANCIENT_DEBRIS);

        final LootDrop debrisDrop = new LootDrop(debrisStack);

        registry.register(debrisStack, distribution, restriction, debrisDrop);
    }
}
