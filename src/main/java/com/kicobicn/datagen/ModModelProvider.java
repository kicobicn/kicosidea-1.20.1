package com.kicobicn.datagen;

import com.kicobicn.block.ModBlocks;
import com.kicobicn.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.EXPERIENCE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_EXPERIENCE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_EXPERIENCE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_STONE_EXPERIENCE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.KICO_LUCKY_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SHIT_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COIN_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SOUNDBLOCK);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.COIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.SHIT, Models.GENERATED);
        itemModelGenerator.register(ModItems.METAL_DETECTOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.STONE_BALL, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENDER_PEARL_ARROW, Models.GENERATED);
        itemModelGenerator.register(ModItems.SHARPENING_STONE,Models.GENERATED);

        itemModelGenerator.register(ModItems.MUSIC_DISC_1, Models.GENERATED);
        itemModelGenerator.register(ModItems.MUSIC_DISC_2, Models.GENERATED);
    }
}
