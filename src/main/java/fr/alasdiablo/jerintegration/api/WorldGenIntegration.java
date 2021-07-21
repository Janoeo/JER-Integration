package fr.alasdiablo.jerintegration.api;

import jeresources.api.*;

public abstract class WorldGenIntegration implements IJERIntegration {
    @Override
    public void registerMob(IMobRegistry registry) {}
    @Override
    public void registerPlant(IPlantRegistry registry) {}
    @Override
    public void registerDungeon(IDungeonRegistry registry) {}
    @Override
    public void register(IJERAPI jerApi) {
        registerWorldGen(jerApi.getWorldGenRegistry());
    }
}
