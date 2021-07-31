package fr.alasdiablo.jerintegration.compat;

import fr.alasdiablo.jerintegration.JERIntegration;
import fr.alasdiablo.jerintegration.api.IJERIntegration;
import fr.alasdiablo.jerintegration.compat.mekanism.MekanismWorldGen;
import fr.alasdiablo.jerintegration.compat.minecraft.MinecraftWorldGen;
import fr.alasdiablo.jerintegration.compat.tconstruct.TConstructWorldGen;
import jeresources.api.IJERAPI;
import jeresources.compatibility.JERAPI;

public class CompatibilityHandler {

    public IJERIntegration tconstruct;

    public IJERIntegration minecraft;

    public IJERIntegration mekanism;

    public CompatibilityHandler() {
        this.minecraft = new MinecraftWorldGen();
        if (JERIntegration.Compat.TINKERS_CONSTRUCT) {
            this.tconstruct = new TConstructWorldGen();
        }

        if (JERIntegration.Compat.MEKANISM) {
            this.mekanism = new MekanismWorldGen();
        }
    }

    public void init() {
        IJERAPI jerApi = JERAPI.getInstance();
        this.minecraft.register(jerApi);
        if (JERIntegration.Compat.TINKERS_CONSTRUCT) {
            this.tconstruct.register(jerApi);
            JERIntegration.LOGGER.info("Tinkers' Construct integration have been initialized");
        }

        if (JERIntegration.Compat.MEKANISM) {
            this.mekanism.register(jerApi);
            JERIntegration.LOGGER.info("Mekanism integration have been initialized");
        }
    }
}
