package fr.alasdiablo.jerintegration.compat;

import fr.alasdiablo.jerintegration.JERIntegration;
import fr.alasdiablo.jerintegration.api.IJERIntegration;
import fr.alasdiablo.jerintegration.compat.ae2.AppEngWorldGen;
import fr.alasdiablo.jerintegration.compat.minecraft.MinecraftWorldGen;
import jeresources.api.IJERAPI;
import jeresources.compatibility.JERAPI;

import java.util.ArrayList;
import java.util.List;

public class CompatibilityHandler {

    public List<IJERIntegration> compatibilityPatch;

    public CompatibilityHandler() {
        this.compatibilityPatch = new ArrayList<>();

        JERIntegration.LOGGER.info("Applying Minecraft patch");
        this.compatibilityPatch.add(new MinecraftWorldGen());
        if (JERIntegration.Compat.AE2) {
            JERIntegration.LOGGER.info("Applying Applied Energistics 2 patch");
            this.compatibilityPatch.add(new AppEngWorldGen());
        }
    }

    public void init() {
        IJERAPI jerApi = JERAPI.getInstance();
        JERIntegration.LOGGER.info("Building patch list");
        this.compatibilityPatch.forEach(ijerIntegration -> ijerIntegration.register(jerApi));
    }
}
