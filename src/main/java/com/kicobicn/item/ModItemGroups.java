package com.kicobicn.item;

import com.kicobicn.Kicosidea;
import com.kicobicn.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup KICOSITEM = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Kicosidea.MOD_ID, "kicositem"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemgroup.kicosidea.kicositem"))
                    .icon(() -> new ItemStack(ModItems.COIN))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.COIN);
                        entries.add(ModItems.SHIT);
                        entries.add(ModItems.STONE_BALL);
                        entries.add(ModItems.METAL_DETECTOR);

                        entries.add(ModItems.ENDER_PEARL_ARROW);

                        entries.add(ModBlocks.COIN_BLOCK);
                        entries.add(ModBlocks.SHIT_BLOCK);
                        entries.add(ModBlocks.KICO_LUCKY_BLOCK);

                        entries.add(ModBlocks.EXPERIENCE_ORE);
                        entries.add(ModBlocks.DEEPSLATE_EXPERIENCE_ORE);
                        entries.add(ModBlocks.NETHER_EXPERIENCE_ORE);
                        entries.add(ModBlocks.END_STONE_EXPERIENCE_ORE);
                        entries.add(ModBlocks.SOUNDBLOCK);

                    })
                    .build());

    public static final ItemGroup KICOSMUSIC = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Kicosidea.MOD_ID, "kicosmusic"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemgroup.kicosidea.kicosmusic"))
                    .icon(() -> new ItemStack(ModItems.MUSIC_DISC_1))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.MUSIC_DISC_1);
                        entries.add(ModItems.MUSIC_DISC_2);
                    }).build());


    public static void registerItemGroups(){
        Kicosidea.LOGGER.info("Registering Item Group for " + Kicosidea.MOD_ID);
    }
}
