package fr.alasdiablo.jerintegration.api;

import jeresources.api.IDungeonRegistry;
import jeresources.api.IJERAPI;
import jeresources.api.IMobRegistry;
import jeresources.api.IWorldGenRegistry;
import org.jetbrains.annotations.NotNull;

public abstract class PlantIntegration implements IJERIntegration {
    @Deprecated
    @Override
    public void registerMob(IMobRegistry registry) {}

    @Deprecated
    @Override
    public void registerWorldGen(IWorldGenRegistry registry) {}

    @Deprecated
    @Override
    public void registerDungeon(IDungeonRegistry registry) {}

    @Override
    public void register(@NotNull IJERAPI jerApi) throws NoSuchFieldException, NoSuchMethodException {
        registerPlant(jerApi.getPlantRegistry());
    }
}
