package fr.alasdiablo.jerintegration.api.v1;

import jeresources.api.IDungeonRegistry;
import jeresources.api.IJERAPI;
import jeresources.api.IMobRegistry;
import jeresources.api.IPlantRegistry;
import org.jetbrains.annotations.NotNull;

public abstract class WorldGenIntegration implements IJERIntegration {
    @Deprecated
    @Override
    public void registerMob(IMobRegistry registry) {}

    @Deprecated
    @Override
    public void registerPlant(IPlantRegistry registry) {}

    @Deprecated
    @Override
    public void registerDungeon(IDungeonRegistry registry) {}

    @Override
    public void register(@NotNull IJERAPI jerApi) {
        registerWorldGen(jerApi.getWorldGenRegistry());
    }
}
