package com.kicobicn.datagen;

import com.kicobicn.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.ARROWS)
                .add(ModItems.ENDER_PEARL_ARROW);

        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ModItems.MUSIC_DISC_1)
                .add(ModItems.MUSIC_DISC_2);

        getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ModItems.MUSIC_DISC_1)
                .add(ModItems.MUSIC_DISC_2);
    }
}
