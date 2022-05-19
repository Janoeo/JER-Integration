package fr.alasdiablo.jerintegration.compat;

import fr.alasdiablo.jerintegration.JERIntegration;
import fr.alasdiablo.jerintegration.compat.ae2.AppEngWorldGen;
import fr.alasdiablo.jerintegration.compat.create.CreateWorldGen;
import fr.alasdiablo.jerintegration.compat.immersiveengineering.ImmersiveEngineeringWorldGen;
import fr.alasdiablo.jerintegration.compat.mekanism.MekanismWorldGen;
import fr.alasdiablo.jerintegration.compat.tconstruct.TConstructWorldGen;
import jeresources.api.IJERAPI;
import jeresources.compatibility.JERAPI;
import org.jetbrains.annotations.NotNull;

import java.io.PrintWriter;
import java.io.StringWriter;

public class CompatibilityHandler {

    public void init() {
        IJERAPI jerApi = JERAPI.getInstance();

        JERIntegration.LOGGER.info("Applying Minecraft patch");
        if (JERIntegration.Compat.AE2) {
            try {
                JERIntegration.LOGGER.info("Applying Applied Energistics 2 patch");
                new AppEngWorldGen().register(jerApi);
            } catch (Exception e) {
                JERIntegration.LOGGER.info("Failing to apply patch for");
                loggerError(e);
            }
        }
        if (JERIntegration.Compat.CREATE) {
            try {
                JERIntegration.LOGGER.info("Applying Create patch");
                new CreateWorldGen().register(jerApi);
            } catch (Exception e) {
                JERIntegration.LOGGER.info("Failing to apply patch for Create");
                loggerError(e);
            }
        }

        if (JERIntegration.Compat.IMMERSIVE_ENGINEERING) {
            try {
                JERIntegration.LOGGER.info("Applying Immersive Engineering patch");
                new ImmersiveEngineeringWorldGen().register(jerApi);
            } catch (Exception e) {
                JERIntegration.LOGGER.info("Failing to apply patch for Immersive Engineering");
                loggerError(e);
            }
        }

        if (JERIntegration.Compat.TINKERS_CONSTRUCT) {
            try {
                JERIntegration.LOGGER.info("Applying Tinkers' Construct patch");
                new TConstructWorldGen().register(jerApi);
            } catch (Exception e) {
                JERIntegration.LOGGER.info("Failing to apply patch for Tinkers' Construct");
                loggerError(e);
            }
        }

        if (JERIntegration.Compat.MEKANISM) {
            try {
                JERIntegration.LOGGER.info("Applying Mekanism patch");
                new MekanismWorldGen().register(jerApi);
            } catch (Exception e) {
                JERIntegration.LOGGER.info("Failing to apply patch for Mekanism");
                loggerError(e);
            }
        }
    }

    private static void loggerError(@NotNull Exception e) {
        StringWriter message = new StringWriter();
        PrintWriter writer = new PrintWriter(message);
        e.printStackTrace(writer);
        JERIntegration.LOGGER.debug(message);
    }
}
