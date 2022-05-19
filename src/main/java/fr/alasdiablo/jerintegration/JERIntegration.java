package fr.alasdiablo.jerintegration;

import fr.alasdiablo.jerintegration.compat.CompatibilityHandler;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(JERIntegration.MOD_ID)
public class JERIntegration {
    public static final  String               MOD_ID      = "jerintegration";
    public static final  Logger               LOGGER      = LogManager.getLogger(JERIntegration.MOD_ID);
    private static final ModList              MOD_LIST    = ModList.get();
    public final         CompatibilityHandler compatibilityHandler;

    public JERIntegration() {
        this.compatibilityHandler = new CompatibilityHandler();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    }

    private void setup(final FMLCommonSetupEvent commonSetupEvent) {
        this.compatibilityHandler.init();
    }

    public static class Compat {
        public static boolean AE2                   = MOD_LIST.isLoaded("ae2");
        public static boolean CREATE                = MOD_LIST.isLoaded("create");
        public static boolean IMMERSIVE_ENGINEERING = MOD_LIST.isLoaded("immersiveengineering");
        public static boolean TINKERS_CONSTRUCT     = MOD_LIST.isLoaded("tconstruct");
        public static boolean MEKANISM              = MOD_LIST.isLoaded("mekanism");
    }
}
