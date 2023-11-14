package fr.alasdiablo.jerintegration.compat.thermal;

import com.legacy.randomite.RandomiteRegistry;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.infrastructure.config.AllConfigs;
import fr.alasdiablo.jerintegration.api.WorldGenIntegration;
import fr.alasdiablo.jerintegration.util.JERIntegrationUtils;
import jeresources.api.IWorldGenRegistry;
import jeresources.api.conditionals.Conditional;
import jeresources.api.distributions.DistributionSquare;
import jeresources.api.distributions.DistributionTriangular;
import jeresources.api.drop.LootDrop;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.ForgeConfigSpec;
import org.jetbrains.annotations.NotNull;

import static cofh.thermal.core.ThermalCore.BLOCKS;
import static cofh.thermal.core.ThermalCore.ITEMS;
import static cofh.thermal.core.util.RegistrationHelper.deepslate;

import java.util.HashMap;
import java.util.Map;

public class ThermalWorldGen extends WorldGenIntegration {
    @Override
    public void registerWorldGen(@NotNull IWorldGenRegistry registry) {
        JERIntegrationUtils.register(
                registry,
                new ItemStack(BLOCKS.get("apatite_ore")),
                new ItemStack(BLOCKS.get(deepslate("apatite_ore"))),
                new ItemStack(ITEMS.get("apatite")),
                new DistributionTriangular(
                        3,
                        9,
                        40,
                        56
                )
        );

        JERIntegrationUtils.register(
                registry,
                new ItemStack(BLOCKS.get("cinnabar_ore")),
                new ItemStack(BLOCKS.get(deepslate("cinnabar_ore"))),
                new ItemStack(ITEMS.get("cinnabar")),
                new DistributionTriangular(
                        1,
                        5,
                        16,
                        32
                )
        );

        JERIntegrationUtils.register(
                registry,
                new ItemStack(BLOCKS.get("lead_ore")),
                new ItemStack(BLOCKS.get(deepslate("lead_ore"))),
                new ItemStack(ITEMS.get("raw_lead")),
                new DistributionTriangular(
                        6,
                        8,
                        -10,
                        50
                )
        );

        JERIntegrationUtils.register(
                registry,
                new ItemStack(BLOCKS.get("nickel_ore")),
                new ItemStack(BLOCKS.get(deepslate("nickel_ore"))),
                new ItemStack(ITEMS.get("raw_nickel")),
                new DistributionTriangular(
                        4,
                        8,
                        40,
                        80
                )
        );

        JERIntegrationUtils.register(
                registry,
                new ItemStack(BLOCKS.get("niter_ore")),
                new ItemStack(BLOCKS.get(deepslate("niter_ore"))),
                new ItemStack(ITEMS.get("niter")),
                new DistributionTriangular(
                        2,
                        7,
                        24,
                        40
                )
        );

        JERIntegrationUtils.register(
                registry,
                new ItemStack(BLOCKS.get("silver_ore")),
                new ItemStack(BLOCKS.get(deepslate("silver_ore"))),
                new ItemStack(ITEMS.get("raw_silver")),
                new DistributionTriangular(
                        4,
                        8,
                        -10,
                        50
                )
        );

        JERIntegrationUtils.register(
                registry,
                new ItemStack(BLOCKS.get("sulfur_ore")),
                new ItemStack(BLOCKS.get(deepslate("sulfur_ore"))),
                new ItemStack(ITEMS.get("sulfur")),
                new DistributionTriangular(
                        2,
                        7,
                        8,
                        24
                )
        );

        JERIntegrationUtils.register(
                registry,
                new ItemStack(BLOCKS.get("tin_ore")),
                new ItemStack(BLOCKS.get(deepslate("tin_ore"))),
                new ItemStack(ITEMS.get("raw_tin")),
                new DistributionTriangular(
                        6,
                        9,
                        20,
                        40
                )
        );

        registry.register(
                new ItemStack(BLOCKS.get("oil_sand")),
                new DistributionTriangular(
                        2,
                        24,
                        60,
                        20
                ),
                new LootDrop(
                        ITEMS.get("oil_sand"),
                        1, 1
                )
        );

        registry.register(
                new ItemStack(BLOCKS.get("oil_red_sand")),
                new DistributionTriangular(
                        2,
                        24,
                        60,
                        20
                ),
                new LootDrop(
                        ITEMS.get("oil_red_sand"),
                        1, 1
                )
        );
    }
}
