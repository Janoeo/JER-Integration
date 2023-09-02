package fr.alasdiablo.jerintegration.util;

import jeresources.api.IWorldGenRegistry;
import jeresources.api.conditionals.Conditional;
import jeresources.api.distributions.DistributionBase;
import jeresources.api.drop.LootDrop;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public interface JERIntegrationUtils {
    static void register(
            @NotNull IWorldGenRegistry registry, ItemStack stoneOreBlock, ItemStack deepslateOreBlock, ItemStack rawItem, DistributionBase distribution
    ) {
        LootDrop drop = new LootDrop(
                rawItem,
                1, 1,
                Conditional.affectedByFortune
        );

        registry.register(
                stoneOreBlock,
                distribution,
                true,
                drop
        );
        if (deepslateOreBlock != null) {
            registry.register(
                    deepslateOreBlock,
                    distribution,
                    true,
                    drop
            );
        }
    }
}
