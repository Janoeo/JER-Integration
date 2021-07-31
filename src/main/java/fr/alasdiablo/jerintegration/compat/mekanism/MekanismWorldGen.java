package fr.alasdiablo.jerintegration.compat.mekanism;

import fr.alasdiablo.jerintegration.api.WorldGenIntegration;
import jeresources.api.IWorldGenRegistry;
import jeresources.api.distributions.DistributionBase;
import jeresources.api.distributions.DistributionSquare;
import jeresources.api.drop.LootDrop;
import mekanism.common.registries.MekanismBlocks;
import mekanism.common.registries.MekanismItems;
import mekanism.common.resource.OreType;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class MekanismWorldGen extends WorldGenIntegration {
    @Override
    public void registerWorldGen(IWorldGenRegistry registry) {
        // TODO MekanismConfig.world.salt;

        this.register(registry,
                MekanismBlocks.ORES.get(OreType.COPPER).getBlock(),
                OreType.COPPER.getPerChunk(),
                OreType.COPPER.getMaxVeinSize(),
                OreType.COPPER.getBottomOffset(),
                OreType.COPPER.getMaxHeight()
        );

        this.register(registry,
                MekanismBlocks.ORES.get(OreType.TIN).getBlock(),
                OreType.TIN.getPerChunk(),
                OreType.TIN.getMaxVeinSize(),
                OreType.TIN.getBottomOffset(),
                OreType.TIN.getMaxHeight()
        );

        this.register(registry,
                MekanismBlocks.ORES.get(OreType.OSMIUM).getBlock(),
                OreType.OSMIUM.getPerChunk(),
                OreType.OSMIUM.getMaxVeinSize(),
                OreType.OSMIUM.getBottomOffset(),
                OreType.OSMIUM.getMaxHeight()
        );

        this.register(registry,
                MekanismBlocks.ORES.get(OreType.URANIUM).getBlock(),
                OreType.URANIUM.getPerChunk(),
                OreType.URANIUM.getMaxVeinSize(),
                OreType.URANIUM.getBottomOffset(),
                OreType.URANIUM.getMaxHeight()
        );

        this.register(registry,
                MekanismBlocks.ORES.get(OreType.LEAD).getBlock(),
                OreType.LEAD.getPerChunk(),
                OreType.LEAD.getMaxVeinSize(),
                OreType.LEAD.getBottomOffset(),
                OreType.LEAD.getMaxHeight()
        );

        final DistributionBase fluoriteDistribution = new DistributionSquare(
                OreType.FLUORITE.getPerChunk(),
                OreType.FLUORITE.getMaxVeinSize(),
                OreType.FLUORITE.getBottomOffset(),
                OreType.FLUORITE.getMaxHeight()
        );
        final ItemStack fluoriteStack = new ItemStack(MekanismBlocks.ORES.get(OreType.FLUORITE).getBlock());
        final LootDrop fluoriteDrop = new LootDrop(new ItemStack(MekanismItems.FLUORITE_GEM.getItem(), 4));
        registry.register(fluoriteStack, fluoriteDistribution, fluoriteDrop);
    }


    public void register(IWorldGenRegistry registry, Block block, int count, int veinSize, int bottom, int top) {
        final DistributionBase distribution = new DistributionSquare(
                count,
                veinSize,
                bottom,
                top
        );
        final ItemStack stack = new ItemStack(block);
        final LootDrop drop = new LootDrop(stack);
        registry.register(stack, distribution, drop);
    }
}
