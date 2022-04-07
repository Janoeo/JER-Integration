package fr.alasdiablo.jerintegration.api;

import jeresources.api.IDungeonRegistry;
import jeresources.api.IJERAPI;
import jeresources.api.IPlantRegistry;
import jeresources.api.IWorldGenRegistry;
import org.jetbrains.annotations.NotNull;

public abstract class MobIntegration implements IJERIntegration {
    @Deprecated
    @Override
    public void registerWorldGen(IWorldGenRegistry registry) {}

    @Deprecated
    @Override
    public void registerPlant(IPlantRegistry registry) {}

    @Deprecated
    @Override
    public void registerDungeon(IDungeonRegistry registry) {}

    @Override
    public void register(@NotNull IJERAPI jerApi) {
        registerMob(jerApi.getMobRegistry());
    }
}
