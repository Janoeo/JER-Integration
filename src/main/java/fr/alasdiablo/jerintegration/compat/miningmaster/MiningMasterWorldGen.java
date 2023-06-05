package fr.alasdiablo.jerintegration.compat.miningmaster;

import fr.alasdiablo.jerintegration.api.WorldGenIntegration;
import jeresources.api.IWorldGenRegistry;
import jeresources.api.conditionals.Conditional;
import jeresources.api.distributions.DistributionTriangular;
import jeresources.api.drop.LootDrop;
import jeresources.api.restrictions.DimensionRestriction;
import jeresources.api.restrictions.Restriction;
import net.minecraft.world.item.ItemStack;
import org.infernalstudios.miningmaster.init.MMBlocks;
import org.infernalstudios.miningmaster.init.MMItems;
import org.jetbrains.annotations.NotNull;

public class MiningMasterWorldGen extends WorldGenIntegration {
    @Override
    public void registerWorldGen(@NotNull final IWorldGenRegistry registry) {
        registerStoneType(registry);
        registerDeepslateType(registry);

        registry.register(
                new ItemStack(MMBlocks.HEART_RHODONITE_ORE.get()),
                new DistributionTriangular(1, 1, 64, 64),
                new Restriction(DimensionRestriction.NETHER),
                true,
                new LootDrop(new ItemStack(MMItems.HEART_RHODONITE.get()), 1, 1, Conditional.affectedByFortune)
        );

        registry.register(
                new ItemStack(MMBlocks.KINETIC_OPAL_ORE.get()),
                new DistributionTriangular(1, 1, 64, 64),
                new Restriction(DimensionRestriction.NETHER),
                true,
                new LootDrop(new ItemStack(MMItems.KINETIC_OPAL.get()), 1, 1, Conditional.affectedByFortune)
        );

        registry.register(
                new ItemStack(MMBlocks.POWER_PYRITE_ORE.get()),
                new DistributionTriangular(1, 1, 64, 64),
                new Restriction(DimensionRestriction.NETHER),
                true,
                new LootDrop(new ItemStack(MMItems.POWER_PYRITE.get()), 1, 1, Conditional.affectedByFortune)
        );
    }
    private void registerStoneType(@NotNull final IWorldGenRegistry registry) {
        registry.register(
                new ItemStack(MMBlocks.DIVE_AQUAMARINE_ORE.get()),
                new DistributionTriangular(3, 1, -10, 30),
                new Restriction(DimensionRestriction.OVERWORLD),
                true,
                new LootDrop(new ItemStack(MMItems.DIVE_AQUAMARINE.get()), 1, 1, Conditional.affectedByFortune)
        );

        registry.register(
                new ItemStack(MMBlocks.DIVINE_BERYL_ORE.get()),
                new DistributionTriangular(3, 1, -10, 30),
                new Restriction(DimensionRestriction.OVERWORLD),
                true,
                new LootDrop(new ItemStack(MMItems.DIVINE_BERYL.get()), 1, 1, Conditional.affectedByFortune)
        );

        registry.register(
                new ItemStack(MMBlocks.FIRE_RUBY_ORE.get()),
                new DistributionTriangular(2, 1, -10, 30),
                new Restriction(DimensionRestriction.OVERWORLD),
                true,
                new LootDrop(new ItemStack(MMItems.FIRE_RUBY.get()), 1, 1, Conditional.affectedByFortune)
        );

        registry.register(
                new ItemStack(MMBlocks.HASTE_PERIDOT_ORE.get()),
                new DistributionTriangular(2, 1, -10, 30),
                new Restriction(DimensionRestriction.OVERWORLD),
                true,
                new LootDrop(new ItemStack(MMItems.HASTE_PERIDOT.get()), 1, 1, Conditional.affectedByFortune)
        );

        registry.register(
                new ItemStack(MMBlocks.ICE_SAPPHIRE_ORE.get()),
                new DistributionTriangular(3, 1, -10, 30),
                new Restriction(DimensionRestriction.OVERWORLD),
                true,
                new LootDrop(new ItemStack(MMItems.ICE_SAPPHIRE.get()), 1, 1, Conditional.affectedByFortune)
        );

        registry.register(
                new ItemStack(MMBlocks.LUCKY_CITRINE_ORE.get()),
                new DistributionTriangular(2, 1, -10, 30),
                new Restriction(DimensionRestriction.OVERWORLD),
                true,
                new LootDrop(new ItemStack(MMItems.LUCKY_CITRINE.get()), 1, 1, Conditional.affectedByFortune)
        );

        registry.register(
                new ItemStack(MMBlocks.SPIDER_KUNZITE_ORE.get()),
                new DistributionTriangular(3, 1, -10, 30),
                new Restriction(DimensionRestriction.OVERWORLD),
                true,
                new LootDrop(new ItemStack(MMItems.SPIDER_KUNZITE.get()), 1, 1, Conditional.affectedByFortune)
        );

        registry.register(
                new ItemStack(MMBlocks.SPIRIT_GARNET_ORE.get()),
                new DistributionTriangular(3, 1, -10, 30),
                new Restriction(DimensionRestriction.OVERWORLD),
                true,
                new LootDrop(new ItemStack(MMItems.SPIRIT_GARNET.get()), 1, 1, Conditional.affectedByFortune)
        );

        registry.register(
                new ItemStack(MMBlocks.UNBREAKING_IOLITE_ORE.get()),
                new DistributionTriangular(2, 1, -10, 30),
                new Restriction(DimensionRestriction.OVERWORLD),
                true,
                new LootDrop(new ItemStack(MMItems.UNBREAKING_IOLITE.get()), 1, 1, Conditional.affectedByFortune)
        );
    }

    private void registerDeepslateType(@NotNull final IWorldGenRegistry registry) {
        registry.register(
                new ItemStack(MMBlocks.DEEPSLATE_DIVE_AQUAMARINE_ORE.get()),
                new DistributionTriangular(3, 1, -10, 30),
                new Restriction(DimensionRestriction.OVERWORLD),
                true,
                new LootDrop(new ItemStack(MMItems.DIVE_AQUAMARINE.get()), 1, 1, Conditional.affectedByFortune)
        );

        registry.register(
                new ItemStack(MMBlocks.DEEPSLATE_DIVINE_BERYL_ORE.get()),
                new DistributionTriangular(3, 1, -10, 30),
                new Restriction(DimensionRestriction.OVERWORLD),
                true,
                new LootDrop(new ItemStack(MMItems.DIVINE_BERYL.get()), 1, 1, Conditional.affectedByFortune)
        );

        registry.register(
                new ItemStack(MMBlocks.DEEPSLATE_FIRE_RUBY_ORE.get()),
                new DistributionTriangular(2, 1, -10, 30),
                new Restriction(DimensionRestriction.OVERWORLD),
                true,
                new LootDrop(new ItemStack(MMItems.FIRE_RUBY.get()), 1, 1, Conditional.affectedByFortune)
        );

        registry.register(
                new ItemStack(MMBlocks.DEEPSLATE_HASTE_PERIDOT_ORE.get()),
                new DistributionTriangular(2, 1, -10, 30),
                new Restriction(DimensionRestriction.OVERWORLD),
                true,
                new LootDrop(new ItemStack(MMItems.HASTE_PERIDOT.get()), 1, 1, Conditional.affectedByFortune)
        );

        registry.register(
                new ItemStack(MMBlocks.DEEPSLATE_ICE_SAPPHIRE_ORE.get()),
                new DistributionTriangular(3, 1, -10, 30),
                new Restriction(DimensionRestriction.OVERWORLD),
                true,
                new LootDrop(new ItemStack(MMItems.ICE_SAPPHIRE.get()), 1, 1, Conditional.affectedByFortune)
        );

        registry.register(
                new ItemStack(MMBlocks.DEEPSLATE_LUCKY_CITRINE_ORE.get()),
                new DistributionTriangular(2, 1, -10, 30),
                new Restriction(DimensionRestriction.OVERWORLD),
                true,
                new LootDrop(new ItemStack(MMItems.LUCKY_CITRINE.get()), 1, 1, Conditional.affectedByFortune)
        );

        registry.register(
                new ItemStack(MMBlocks.DEEPSLATE_SPIDER_KUNZITE_ORE.get()),
                new DistributionTriangular(3, 1, -10, 30),
                new Restriction(DimensionRestriction.OVERWORLD),
                true,
                new LootDrop(new ItemStack(MMItems.SPIDER_KUNZITE.get()), 1, 1, Conditional.affectedByFortune)
        );

        registry.register(
                new ItemStack(MMBlocks.DEEPSLATE_SPIRIT_GARNET_ORE.get()),
                new DistributionTriangular(3, 1, -10, 30),
                new Restriction(DimensionRestriction.OVERWORLD),
                true,
                new LootDrop(new ItemStack(MMItems.SPIRIT_GARNET.get()), 1, 1, Conditional.affectedByFortune)
        );

        registry.register(
                new ItemStack(MMBlocks.DEEPSLATE_UNBREAKING_IOLITE_ORE.get()),
                new DistributionTriangular(2, 1, -10, 30),
                new Restriction(DimensionRestriction.OVERWORLD),
                true,
                new LootDrop(new ItemStack(MMItems.UNBREAKING_IOLITE.get()), 1, 1, Conditional.affectedByFortune)
        );
    }
}
