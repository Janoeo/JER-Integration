package fr.alasdiablo.jerintegration.util;

import com.mojang.serialization.Codec;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.RandomState;
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
            @Override
            protected Codec<? extends ChunkGenerator> codec() {return null;}

            @Override
            public void applyCarvers(
                    WorldGenRegion pLevel, long pSeed, RandomState pRandom, BiomeManager pBiomeManager, StructureManager pStructureManager, ChunkAccess pChunk,
                    GenerationStep.Carving pStep
            ) {}

            @Override
            public void buildSurface(WorldGenRegion pLevel, StructureManager pStructureManager, RandomState pRandom, ChunkAccess pChunk) {}

            @Override
            public void spawnOriginalMobs(WorldGenRegion pLevel) {}

            @Override
            public int getSeaLevel() {return 0;}

            @Override
            public int getGenDepth() {
                return 319;
            }

            @Override
            public CompletableFuture<ChunkAccess> fillFromNoise(
                    Executor pExecutor, Blender pBlender, RandomState pRandom, StructureManager pStructureManager, ChunkAccess pChunk
            ) {return null;}

            @Override
            public int getMinY() {
                return -64;
            }

            @Override
            public int getBaseHeight(int pX, int pZ, Heightmap.Types pType, LevelHeightAccessor pLevel, RandomState pRandom) {return 0;}

            @Override
            public NoiseColumn getBaseColumn(int pX, int pZ, LevelHeightAccessor pHeight, RandomState pRandom) {return null;}

            @Override
            public void addDebugScreenInfo(List<String> pInfo, RandomState pRandom, BlockPos pPos) {}
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
