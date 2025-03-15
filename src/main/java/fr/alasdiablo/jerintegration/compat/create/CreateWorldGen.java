package fr.alasdiablo.jerintegration.compat.create;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import fr.alasdiablo.jerintegration.api.WorldGenIntegration;
import fr.alasdiablo.jerintegration.util.JERIntegrationUtils;
import jeresources.api.IWorldGenRegistry;
import jeresources.api.distributions.DistributionSquare;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class CreateWorldGen extends WorldGenIntegration {

    @Override
    public void registerWorldGen(@NotNull IWorldGenRegistry registry) {
        JERIntegrationUtils.register(
                registry,
                new ItemStack(AllBlocks.ZINC_ORE.get()),
                new ItemStack(AllBlocks.DEEPSLATE_ZINC_ORE.get()),
                new ItemStack(AllItems.RAW_ZINC.get()),
                new DistributionSquare(
                        8,
                        12,
                        -63,
                        70
                )
        );
    }
}
