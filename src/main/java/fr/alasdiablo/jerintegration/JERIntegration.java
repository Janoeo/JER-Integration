package fr.alasdiablo.jerintegration;

import fr.alasdiablo.jerintegration.compat.CompatibilityHandler;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

@Mod(JERIntegration.MOD_ID)
public class JERIntegration {
    public static final  String               MOD_ID      = "jerintegration";
    public static final  Logger               LOGGER      = LogManager.getLogger(JERIntegration.MOD_ID);
    private static final ModList              MOD_LIST    = ModList.get();

    public JERIntegration() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, DisableConfig.CONFIG_SPEC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    }

    private void setup(final FMLCommonSetupEvent commonSetupEvent) {
        CompatibilityHandler.init();
    }

    public static class DisableConfig {
        public static final ForgeConfigSpec CONFIG_SPEC;
        public static final DisableConfig.Config CONFIG;
        static {
            Pair<Config, ForgeConfigSpec> configPair = new ForgeConfigSpec.Builder().configure(DisableConfig.Config::new);
            CONFIG_SPEC = configPair.getRight();
            CONFIG = configPair.getLeft();
        }
        public static class Config {
            public final ForgeConfigSpec.BooleanValue AE2;
            public final ForgeConfigSpec.BooleanValue CREATE;
            public final ForgeConfigSpec.BooleanValue IMMERSIVE_ENGINEERING;
            public final ForgeConfigSpec.BooleanValue TINKERS_CONSTRUCT;
            public final ForgeConfigSpec.BooleanValue MEKANISM;
            public Config(ForgeConfigSpec.@NotNull Builder builder) {
                builder.comment("Jer Integration override options").push("jer-integration");

                AE2 = builder.comment("Enable / Disable patch for Applied Energistics 2").define("ae2", true);

                CREATE = builder.comment("Enable / Disable patch for Create").define("create", true);

                IMMERSIVE_ENGINEERING = builder.comment("Enable / Disable patch for Immersive Engineering").define("immersiveengineering", true);

                TINKERS_CONSTRUCT = builder.comment("Enable / Disable patch for Tinkers' Construct").define("tconstruct", true);

                MEKANISM = builder.comment("Enable / Disable patch for Mekanism").define("mekanism", true);
            }
        }
    }

    public static class Compat {
        public static boolean CREATE                = MOD_LIST.isLoaded("create");
        public static boolean IMMERSIVE_ENGINEERING = MOD_LIST.isLoaded("immersiveengineering");
        public static boolean TINKERS_CONSTRUCT     = MOD_LIST.isLoaded("tconstruct");
        public static boolean MEKANISM              = MOD_LIST.isLoaded("mekanism");
    }
}
