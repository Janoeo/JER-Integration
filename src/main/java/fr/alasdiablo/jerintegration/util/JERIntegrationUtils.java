package fr.alasdiablo.jerintegration.util;

import jeresources.api.IWorldGenRegistry;
import jeresources.api.conditionals.Conditional;
import jeresources.api.distributions.DistributionBase;
import jeresources.api.drop.LootDrop;
import net.minecraft.world.item.ItemStack;

public interface JERIntegrationUtils {
    static void register(IWorldGenRegistry registry, ItemStack ore_normal, ItemStack ore_deepslate, ItemStack drop_item, DistributionBase distribution) {
        LootDrop drop = new LootDrop(
                drop_item,
                1, 1,
                Conditional.affectedByFortune
        );

        registry.register(
                ore_normal,
                distribution,
                true,
                drop
        );
        if (ore_deepslate != null) {
            registry.register(
                    ore_deepslate,
                    distribution,
                    true,
                    drop
            );
        }
    }
}
