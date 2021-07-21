package fr.alasdiablo.jerintegration.api;

import jeresources.api.*;

public interface IJERIntegration {
    void registerMob(IMobRegistry registry);
    void registerWorldGen(IWorldGenRegistry registry);
    void registerPlant(IPlantRegistry registry);
    void registerDungeon(IDungeonRegistry registry);
    default void register(IJERAPI jerApi) {
        registerMob(jerApi.getMobRegistry());
        registerWorldGen(jerApi.getWorldGenRegistry());
        registerPlant(jerApi.getPlantRegistry());
        registerDungeon(jerApi.getDungeonRegistry());
    }
}
