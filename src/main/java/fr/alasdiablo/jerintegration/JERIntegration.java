package fr.alasdiablo.jerintegration;

import fr.alasdiablo.jerintegration.compat.CompatibilityHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(JERIntegration.MOD_ID)
public class JERIntegration {
    public static final  String               MOD_ID   = "jerintegration";
    public static final  Logger               LOGGER   = LogManager.getLogger(JERIntegration.MOD_ID);
    private static final ModList              MOD_LIST = ModList.get();
    public final         CompatibilityHandler compatibilityHandler;
    public               boolean              oneTimeLoad = false;

    public JERIntegration() {
        this.compatibilityHandler = new CompatibilityHandler();
        MinecraftForge.EVENT_BUS.addListener(this::onPlayerJoinWorld);
    }

    private void onPlayerJoinWorld(PlayerEvent.PlayerLoggedInEvent event) {
        if (!this.oneTimeLoad) {
            this.compatibilityHandler.preInit();
            this.compatibilityHandler.init();
            this.oneTimeLoad = true;
        }
    }

    public static class Compat {
        public static boolean AE2    = MOD_LIST.isLoaded("ae2");
        public static boolean CREATE = MOD_LIST.isLoaded("create");
        public static boolean IMMERSIVE_ENGINEERING = MOD_LIST.isLoaded("immersiveengineering");
    }
}
