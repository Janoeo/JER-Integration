package fr.alasdiablo.jerintegration.api;

import jeresources.api.*;

public abstract class MobIntegration implements IJERIntegration {
    @Override
    public void registerWorldGen(IWorldGenRegistry registry) {}
    @Override
    public void registerPlant(IPlantRegistry registry) {}
    @Override
    public void registerDungeon(IDungeonRegistry registry) {}
    @Override
    public void register(IJERAPI jerApi) {
        registerMob(jerApi.getMobRegistry());
    }
}
