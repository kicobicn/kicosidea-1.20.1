package com.kicobicn.datagen;

import com.kicobicn.block.ModBlocks;
import com.kicobicn.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModTags.Block.METAL_DETECTOR_DETECTAbLC_BLOCKS)
                .add(ModBlocks.DEEPSLATE_EXPERIENCE_ORE)
                .add(ModBlocks.END_STONE_EXPERIENCE_ORE)
                .add(ModBlocks.EXPERIENCE_ORE)
                .add(ModBlocks.NETHER_EXPERIENCE_ORE)
                .forceAddTag(BlockTags.GOLD_ORES)
                .forceAddTag(BlockTags.EMERALD_ORES)
                .forceAddTag(BlockTags.IRON_ORES)
                .forceAddTag(BlockTags.DIAMOND_ORES)
                .forceAddTag(BlockTags.COAL_ORES)
                .forceAddTag(BlockTags.COPPER_ORES)
                .forceAddTag(BlockTags.REDSTONE_ORES)
                .forceAddTag(BlockTags.LAPIS_ORES);


        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.DEEPSLATE_EXPERIENCE_ORE)
                .add(ModBlocks.END_STONE_EXPERIENCE_ORE)
                .add(ModBlocks.EXPERIENCE_ORE)
                .add(ModBlocks.NETHER_EXPERIENCE_ORE)
                .add(ModBlocks.KICO_LUCKY_BLOCK);

        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(ModBlocks.SHIT_BLOCK);

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE);

        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.DEEPSLATE_EXPERIENCE_ORE)
                .add(ModBlocks.END_STONE_EXPERIENCE_ORE)
                .add(ModBlocks.EXPERIENCE_ORE)
                .add(ModBlocks.NETHER_EXPERIENCE_ORE)
                .add(ModBlocks.KICO_LUCKY_BLOCK)
                .add(ModBlocks.COIN_BLOCK)
                .add(ModBlocks.SHIT_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.DEEPSLATE_EXPERIENCE_ORE)
                .add(ModBlocks.END_STONE_EXPERIENCE_ORE)
                .add(ModBlocks.EXPERIENCE_ORE)
                .add(ModBlocks.NETHER_EXPERIENCE_ORE)
                .add(ModBlocks.COIN_BLOCK)
                .add(ModBlocks.SHIT_BLOCK)
                .add(ModBlocks.KICO_LUCKY_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.SHIT_BLOCK)
                .add(ModBlocks.KICO_LUCKY_BLOCK);

        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric","needs_tool_level_4")))
                .add(ModBlocks.END_STONE_EXPERIENCE_ORE);

    }
}
