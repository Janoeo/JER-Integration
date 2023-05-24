package fr.alasdiablo.jerintegration.compat;

import fr.alasdiablo.jerintegration.JERIntegration;
import fr.alasdiablo.jerintegration.compat.create.CreateWorldGen;
import fr.alasdiablo.jerintegration.compat.immersiveengineering.ImmersiveEngineeringWorldGen;
import fr.alasdiablo.jerintegration.compat.mekanism.MekanismWorldGen;
import fr.alasdiablo.jerintegration.compat.miningmaster.MiningMasterWorldGen;
import fr.alasdiablo.jerintegration.compat.randomite.RandomiteWorldGen;
import fr.alasdiablo.jerintegration.compat.tconstruct.TConstructWorldGen;
import jeresources.compatibility.api.JERAPI;
import org.jetbrains.annotations.NotNull;

import java.io.PrintWriter;
import java.io.StringWriter;

public class CompatibilityHandler {

    public static void init() {
        var api = JERAPI.getInstance();
        if (JERIntegration.Compat.CREATE && JERIntegration.DisableConfig.CONFIG.CREATE.get()) {
            try {
                JERIntegration.LOGGER.info("Applying Create patch");
                new CreateWorldGen().register(api);
            } catch (Exception e) {
                JERIntegration.LOGGER.info("Failing to apply patch for Create");
                loggerError(e);
            }
        }

        if (JERIntegration.Compat.IMMERSIVE_ENGINEERING && JERIntegration.DisableConfig.CONFIG.IMMERSIVE_ENGINEERING.get()) {
            try {
                JERIntegration.LOGGER.info("Applying Immersive Engineering patch");
                new ImmersiveEngineeringWorldGen().register(api);
            } catch (Exception e) {
                JERIntegration.LOGGER.info("Failing to apply patch for Immersive Engineering");
                loggerError(e);
            }
        }

        if (JERIntegration.Compat.TINKERS_CONSTRUCT && JERIntegration.DisableConfig.CONFIG.TINKERS_CONSTRUCT.get()) {
            try {
                JERIntegration.LOGGER.info("Applying Tinkers' Construct patch");
                new TConstructWorldGen().register(api);
            } catch (Exception e) {
                JERIntegration.LOGGER.info("Failing to apply patch for Tinkers' Construct");
                loggerError(e);
            }
        }

        if (JERIntegration.Compat.MEKANISM && JERIntegration.DisableConfig.CONFIG.MEKANISM.get()) {
            try {
                JERIntegration.LOGGER.info("Applying Mekanism patch");
                new MekanismWorldGen().register(api);
            } catch (Exception e) {
                JERIntegration.LOGGER.info("Failing to apply patch for Mekanism");
                loggerError(e);
            }
        }

        if (JERIntegration.Compat.RANDOMITE && JERIntegration.DisableConfig.CONFIG.RANDOMITE.get()) {
            try {
                JERIntegration.LOGGER.info("Applying Randomite patch");
                new RandomiteWorldGen().register(api);
            } catch (Exception e) {
                JERIntegration.LOGGER.info("Failing to apply patch for Randomite");
                loggerError(e);
            }
        }

        if (JERIntegration.Compat.MINING_MASTER && JERIntegration.DisableConfig.CONFIG.MINING_MASTER.get()) {
            try {
                JERIntegration.LOGGER.info("Applying Mining Master patch");
                new MiningMasterWorldGen().register(api);
            } catch (Exception e) {
                JERIntegration.LOGGER.info("Failing to apply patch for Mining Master");
                loggerError(e);
            }
        }
    }

    private static void loggerError(@NotNull Exception e) {
        StringWriter message = new StringWriter();
        PrintWriter  writer  = new PrintWriter(message);
        e.printStackTrace(writer);
        JERIntegration.LOGGER.debug(message);
    }
}
