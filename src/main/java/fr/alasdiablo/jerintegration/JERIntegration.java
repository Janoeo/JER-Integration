package fr.alasdiablo.jerintegration;

import fr.alasdiablo.jerintegration.compat.CompatibilityHandler;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.ModConfigSpec;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

@Mod(JERIntegration.MOD_ID)
public class JERIntegration {
    public static final  String  MOD_ID   = "jerintegration";
    public static final  Logger  LOGGER   = LogManager.getLogger(JERIntegration.MOD_ID);
    private static final ModList MOD_LIST = ModList.get();

    public JERIntegration(IEventBus modEventBus, ModContainer modContainer) {
        modContainer.registerConfig(ModConfig.Type.CLIENT, DisableConfig.CONFIG_SPEC);

        modEventBus.addListener(this::setup);
    }

    private void setup(final FMLCommonSetupEvent commonSetupEvent) {
        CompatibilityHandler.init();
    }

    public static class DisableConfig {
        public static final ModConfigSpec CONFIG_SPEC;
        public static final DisableConfig.Config CONFIG;

        static {
            Pair<Config, ModConfigSpec> configPair = new ModConfigSpec.Builder().configure(DisableConfig.Config::new);
            CONFIG_SPEC = configPair.getRight();
            CONFIG      = configPair.getLeft();
        }

        public static class Config {
            public final ModConfigSpec.BooleanValue RANDOMITE;
            public final ModConfigSpec.BooleanValue CREATE;
            public final ModConfigSpec.BooleanValue THERMAL;
            public final ModConfigSpec.BooleanValue IMMERSIVE_ENGINEERING;
            public final ModConfigSpec.BooleanValue TINKERS_CONSTRUCT;
            public final ModConfigSpec.BooleanValue MEKANISM;
            public final ModConfigSpec.BooleanValue MINING_MASTER;

            public Config(ModConfigSpec.@NotNull Builder builder) {
                builder.comment("Jer Integration override options").push("jer-integration");

                RANDOMITE = builder.comment("Enable / Disable patch for Randomite Classic").define("randomite", true);

                CREATE = builder.comment("Enable / Disable patch for Create").define("create", true);

                THERMAL = builder.comment("Enable / Disable patch for Thermal").define("thermal", true);

                IMMERSIVE_ENGINEERING = builder.comment("Enable / Disable patch for Immersive Engineering").define("immersiveengineering", true);

                TINKERS_CONSTRUCT = builder.comment("Enable / Disable patch for Tinkers' Construct").define("tconstruct", true);

                MEKANISM = builder.comment("Enable / Disable patch for Mekanism").define("mekanism", true);

                MINING_MASTER = builder.comment("Enable / Disable patch for Mining Master").define("miningmaster", true);
            }
        }
    }

    public static class Compat {
        public static boolean RANDOMITE             = MOD_LIST.isLoaded("randomite");
        public static boolean CREATE                = MOD_LIST.isLoaded("create");
        public static boolean THERMAL               = MOD_LIST.isLoaded("thermal");
        public static boolean IMMERSIVE_ENGINEERING = MOD_LIST.isLoaded("immersiveengineering");
        public static boolean TINKERS_CONSTRUCT     = MOD_LIST.isLoaded("tconstruct");
        public static boolean MEKANISM              = MOD_LIST.isLoaded("mekanism");
        public static boolean MINING_MASTER         = MOD_LIST.isLoaded("miningmaster");
    }
}
