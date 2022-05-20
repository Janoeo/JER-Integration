package fr.alasdiablo.jerintegration.util;

import com.mojang.serialization.Codec;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.WorldGenerationContext;
import net.minecraft.world.level.levelgen.blending.Blender;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@SuppressWarnings("ConstantConditions")
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class WorldContext extends WorldGenerationContext {
    public WorldContext(ChunkGenerator pGenerator, LevelHeightAccessor pLevel) {
        super(pGenerator, pLevel);
    }

    public WorldContext() {
        this(new ChunkGenerator(null, null, null) {
            @Override protected Codec<? extends ChunkGenerator> codec() {return null;}
            @Override public ChunkGenerator withSeed(long pSeed) {return null;}
            @Override public Climate.Sampler climateSampler() {return null;}
            @Override public void applyCarvers(WorldGenRegion pLevel, long pSeed, BiomeManager pBiomeManager, StructureFeatureManager pStructureFeatureManager, ChunkAccess pChunk, GenerationStep.Carving pStep) {}
            @Override public void buildSurface(WorldGenRegion pLevel, StructureFeatureManager pStructureFeatureManager, ChunkAccess pChunk) {}
            @Override public void spawnOriginalMobs(WorldGenRegion pLevel) {}
            @Override public CompletableFuture<ChunkAccess> fillFromNoise(Executor p_187748_, Blender p_187749_, StructureFeatureManager p_187750_, ChunkAccess p_187751_) {return null;}
            @Override public int getSeaLevel() {return 0;}
            @Override public int getBaseHeight(int pX, int pZ, Heightmap.Types pType, LevelHeightAccessor pLevel) {return 0;}
            @Override public NoiseColumn getBaseColumn(int pX, int pZ, LevelHeightAccessor pLevel) {return null;}
            @Override public void addDebugScreenInfo(List<String> p_208054_, BlockPos p_208055_) {}

            @Override
            public int getGenDepth() {
                return 319;
            }

            @Override
            public int getMinY() {
                return -64;
            }

        }, new LevelHeightAccessor() {
            @Override
            public int getHeight() {
                return 319;
            }

            @Override
            public int getMinBuildHeight() {
                return -64;
            }
        });
    }
}
