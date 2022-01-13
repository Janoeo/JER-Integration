package fr.alasdiablo.jerintegration.compat.ae2;

import appeng.core.AEConfig;
import appeng.core.definitions.AEBlocks;
import appeng.core.definitions.AEItems;
import fr.alasdiablo.jerintegration.api.WorldGenIntegration;
import jeresources.api.IWorldGenRegistry;
import jeresources.api.conditionals.Conditional;
import jeresources.api.distributions.DistributionSquare;
import jeresources.api.drop.LootDrop;
import net.minecraft.world.item.ItemStack;

public class AppEngWorldGen extends WorldGenIntegration {
    @Override
    public void registerWorldGen(IWorldGenRegistry registry) {
        registry.register(
                new ItemStack(AEBlocks.QUARTZ_ORE),
                new DistributionSquare(
                        AEConfig.instance().getQuartzOresClusterAmount(),
                        AEConfig.instance().getQuartzOresPerCluster(),
                        -34, 36
                ), true,
                new LootDrop(new ItemStack(AEItems.CERTUS_QUARTZ_DUST), 2, 5, Conditional.affectedByFortune),
                new LootDrop(new ItemStack(AEItems.CERTUS_QUARTZ_CRYSTAL), 1, 4, 0.05f, 0, Conditional.affectedByFortune),
                new LootDrop(new ItemStack(AEItems.CERTUS_QUARTZ_CRYSTAL), 1, 4, 0.10f, 1, Conditional.affectedByFortune),
                new LootDrop(new ItemStack(AEItems.CERTUS_QUARTZ_CRYSTAL), 1, 4, 0.15f, 2, Conditional.affectedByFortune),
                new LootDrop(new ItemStack(AEItems.CERTUS_QUARTZ_CRYSTAL), 1, 4, 0.20f, 3, Conditional.affectedByFortune)
        );
    }
}
