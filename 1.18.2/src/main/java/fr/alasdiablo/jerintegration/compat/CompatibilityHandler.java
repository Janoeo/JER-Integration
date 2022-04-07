package fr.alasdiablo.jerintegration.compat;

import fr.alasdiablo.jerintegration.JERIntegration;
import fr.alasdiablo.jerintegration.api.IJERIntegration;
import fr.alasdiablo.jerintegration.compat.ae2.AppEngWorldGen;
import fr.alasdiablo.jerintegration.compat.create.CreateWorldGen;
import fr.alasdiablo.jerintegration.compat.immersiveengineering.ImmersiveEngineeringWorldGen;
import jeresources.api.IJERAPI;
import jeresources.compatibility.JERAPI;

import java.util.ArrayList;
import java.util.List;

public class CompatibilityHandler {

    public List<IJERIntegration> compatibilityPatch;

    public CompatibilityHandler() {
        this.compatibilityPatch = new ArrayList<>();
    }

    public void preInit() {
        JERIntegration.LOGGER.info("Applying Minecraft patch");
        if (JERIntegration.Compat.AE2) {
            try {
                JERIntegration.LOGGER.info("Applying Applied Energistics 2 patch");
                this.compatibilityPatch.add(new AppEngWorldGen());
            } catch (Exception e) {
                JERIntegration.LOGGER.info("Failing to apply patch for");
            }
        }
        if (JERIntegration.Compat.CREATE) {
            try {
                JERIntegration.LOGGER.info("Applying Create patch");
                this.compatibilityPatch.add(new CreateWorldGen());
            } catch (Exception e) {
                JERIntegration.LOGGER.info("Failing to apply patch for Create");
            }
        }

        if (JERIntegration.Compat.IMMERSIVE_ENGINEERING) {
            try {
                JERIntegration.LOGGER.info("Applying Immersive Engineering patch");
                this.compatibilityPatch.add(new ImmersiveEngineeringWorldGen());
            } catch (Exception e) {
                JERIntegration.LOGGER.info("Failing to apply patch for Immersive Engineering");
            }
        }
    }

    public void init() {
        IJERAPI jerApi = JERAPI.getInstance();
        JERIntegration.LOGGER.info("Building patch list");
        this.compatibilityPatch.forEach(ijerIntegration -> ijerIntegration.register(jerApi));
    }
}
