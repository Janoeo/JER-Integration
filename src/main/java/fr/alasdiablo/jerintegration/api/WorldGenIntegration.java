package fr.alasdiablo.jerintegration.api;

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
    public void register(@NotNull IJERAPI jerApi) throws IllegalStateException, NoSuchFieldException, NoSuchMethodException, NoClassDefFoundError {
        registerWorldGen(jerApi.getWorldGenRegistry());
    }
}
