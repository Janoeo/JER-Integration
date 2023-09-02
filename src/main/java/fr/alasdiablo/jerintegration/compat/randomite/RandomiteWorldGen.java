package fr.alasdiablo.jerintegration.compat.randomite;

import com.legacy.randomite.RandomiteRegistry;
import fr.alasdiablo.jerintegration.api.WorldGenIntegration;
import jeresources.api.IWorldGenRegistry;
import jeresources.api.conditionals.Conditional;
import jeresources.api.distributions.DistributionTriangular;
import jeresources.api.drop.LootDrop;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

public class RandomiteWorldGen extends WorldGenIntegration {
    @Override
    public void registerWorldGen(@NotNull IWorldGenRegistry registry)
            throws IllegalStateException, NoSuchFieldException, NoSuchMethodException, NoClassDefFoundError {
        registry.register(
                new ItemStack(RandomiteRegistry.RANDOMITE_ORE.get()),
                new DistributionTriangular(2, 4, 0, 32),
                new LootDrop(Items.COAL, 1, 1, 25f / 178f, Conditional.affectedByFortune),
                new LootDrop(Items.LAPIS_LAZULI, 4, 9, 27f / 178f),
                new LootDrop(Items.EGG, 1, 1, 20f / 178f),
                new LootDrop(Items.REDSTONE, 4, 5, 10f / 178f, Conditional.affectedByFortune),
                new LootDrop(Items.QUARTZ, 1, 2, 10f / 178f, Conditional.affectedByFortune),
                new LootDrop(Items.DIAMOND, 1, 1, 3f / 178f),
                new LootDrop(Items.EMERALD, 1, 1, 5f / 178f),
                new LootDrop(Items.RAW_COPPER, 2, 3, 25f / 178f),
                new LootDrop(Items.SLIME_BALL, 1, 2, 30f / 178f, Conditional.affectedByFortune),
                new LootDrop(Items.RAW_GOLD, 1, 1, 10f / 178f),
                new LootDrop(Items.RAW_IRON, 1, 1, 13f / 178f)
        );
    }
}
