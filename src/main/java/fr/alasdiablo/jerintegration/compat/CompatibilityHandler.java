package fr.alasdiablo.jerintegration.compat;

import fr.alasdiablo.jerintegration.JERIntegration;
import fr.alasdiablo.jerintegration.api.IJERIntegration;
import fr.alasdiablo.jerintegration.compat.tconstruct.TConstructWorldGen;
import jeresources.api.IJERAPI;
import jeresources.compatibility.JERAPI;

public class CompatibilityHandler {

    public IJERIntegration tconstruct;

    public CompatibilityHandler() {
        if (JERIntegration.Compat.TINKERS_CONSTRUCT) {
            this.tconstruct = new TConstructWorldGen();
        }
    }

    public void init() {
        IJERAPI jerApi = JERAPI.getInstance();
        if (JERIntegration.Compat.TINKERS_CONSTRUCT) {
            this.tconstruct.register(jerApi);
            JERIntegration.LOGGER.info("Tinkers' Construct integration have been initialized");
        }
    }
}
