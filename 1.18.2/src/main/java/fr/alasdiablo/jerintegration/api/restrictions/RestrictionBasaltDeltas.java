package fr.alasdiablo.jerintegration.api.restrictions;

import jeresources.api.restrictions.BiomeRestriction;
import jeresources.api.restrictions.Restriction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biomes;

import java.util.Collections;
import java.util.List;

public class RestrictionBasaltDeltas extends Restriction {

    public RestrictionBasaltDeltas() {
        super(BiomeRestriction.NONE);
    }

    @Override
    public List<String> getBiomeRestrictions() {
        return Collections.singletonList("  " + Biomes.BASALT_DELTAS.getRegistryName());
    }

    @Override
    public String getDimensionRestriction() {
        return Level.NETHER.location().toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Restriction)) return false;
        Restriction other = (Restriction) obj;
        if (!other.getBiomeRestrictions().equals(this.getBiomeRestrictions())) return false;
        return other.getBiomeRestrictions().equals(this.getBiomeRestrictions());
    }

    @Override
    public String toString() {
        return getDimensionRestriction() + ", " + getBiomeRestrictions().toString();
    }

    @Override
    public int hashCode() {
        return getDimensionRestriction().hashCode() ^ getBiomeRestrictions().hashCode();
    }
}
