package fr.alasdiablo.jerintegration.compat.create;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.infrastructure.config.AllConfigs;
import fr.alasdiablo.jerintegration.api.WorldGenIntegration;
import fr.alasdiablo.jerintegration.util.JERIntegrationUtils;
import jeresources.api.IWorldGenRegistry;
import jeresources.api.conditionals.Conditional;
import jeresources.api.distributions.DistributionSquare;
import jeresources.api.drop.LootDrop;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeConfigSpec;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class CreateWorldGen extends WorldGenIntegration {

    @SuppressWarnings("SameParameterValue")
    private @NotNull Map<String, Number> getValues(String path) {
        Map<String, Number> output = new HashMap<>();
        var                 config = AllConfigs.common().specification.getValues();
        output.put("clusterSize", config.<ForgeConfigSpec.IntValue>get(path + ".clusterSize").get());
        output.put("maxHeight", config.<ForgeConfigSpec.IntValue>get(path + ".maxHeight").get());
        output.put("minHeight", config.<ForgeConfigSpec.IntValue>get(path + ".minHeight").get());
        output.put("frequency", config.<ForgeConfigSpec.DoubleValue>get(path + ".frequency").get());
        return output;
    }

    @Override
    public void registerWorldGen(@NotNull IWorldGenRegistry registry) {
        var config = this.getValues("worldgen.v2.zinc_ore");
        JERIntegrationUtils.register(registry,
                new ItemStack(AllBlocks.ZINC_ORE.get()),
                new ItemStack(AllBlocks.DEEPSLATE_ZINC_ORE.get()),
                new ItemStack(AllItems.RAW_ZINC.get()),
                new DistributionSquare(
                        config.get("clusterSize").intValue(),
                        config.get("frequency").intValue(),
                        config.get("minHeight").intValue(),
                        config.get("maxHeight").intValue()
                ));
    }
}
