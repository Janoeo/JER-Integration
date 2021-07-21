package fr.alasdiablo.jerintegration.api;

import jeresources.api.*;

public abstract class DungeonIntegration implements IJERIntegration {
    @Override
    public void registerMob(IMobRegistry registry) {}
    @Override
    public void registerPlant(IPlantRegistry registry) {}
    @Override
    public void registerWorldGen(IWorldGenRegistry registry) {}
    @Override
    public void register(IJERAPI jerApi) {
        registerDungeon(jerApi.getDungeonRegistry());
    }
}
