package fr.alasdiablo.jerintegration.api;

import jeresources.api.*;

public abstract class PlantIntegration implements IJERIntegration {
    @Override
    public void registerMob(IMobRegistry registry) {}
    @Override
    public void registerWorldGen(IWorldGenRegistry registry) {}
    @Override
    public void registerDungeon(IDungeonRegistry registry) {}
    @Override
    public void register(IJERAPI jerApi) {
        registerPlant(jerApi.getPlantRegistry());
    }
}
