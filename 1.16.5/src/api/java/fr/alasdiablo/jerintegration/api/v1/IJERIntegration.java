package fr.alasdiablo.jerintegration.api.v1;

import jeresources.api.*;
import org.jetbrains.annotations.NotNull;

public interface IJERIntegration {
    void registerMob(IMobRegistry registry);

    void registerWorldGen(IWorldGenRegistry registry);

    void registerPlant(IPlantRegistry registry);

    void registerDungeon(IDungeonRegistry registry);

    default void register(@NotNull IJERAPI jerApi) {
        registerMob(jerApi.getMobRegistry());
        registerWorldGen(jerApi.getWorldGenRegistry());
        registerPlant(jerApi.getPlantRegistry());
        registerDungeon(jerApi.getDungeonRegistry());
    }
}
