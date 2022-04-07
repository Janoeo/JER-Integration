package fr.alasdiablo.jerintegration.api;

import jeresources.api.IJERAPI;
import jeresources.api.IMobRegistry;
import jeresources.api.IPlantRegistry;
import jeresources.api.IWorldGenRegistry;
import org.jetbrains.annotations.NotNull;

public abstract class DungeonIntegration implements IJERIntegration {
    @Deprecated
    @Override
    public void registerMob(IMobRegistry registry) {}

    @Deprecated
    @Override
    public void registerPlant(IPlantRegistry registry) {}

    @Deprecated
    @Override
    public void registerWorldGen(IWorldGenRegistry registry) {}

    @Override
    public void register(@NotNull IJERAPI jerApi) {
        registerDungeon(jerApi.getDungeonRegistry());
    }
}
