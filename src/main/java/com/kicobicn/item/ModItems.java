package com.kicobicn.item;

import com.kicobicn.Kicosidea;
import com.kicobicn.item.custom.EnderArrowItem;
import com.kicobicn.item.custom.MetalDetectorItem;
import com.kicobicn.item.custom.SharpeningStoneItem;
import com.kicobicn.item.custom.StoneBallItem;
import com.kicobicn.sound.ModSounds;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModItems {

    public static final Item COIN = registerItem("coin", new Item(new FabricItemSettings()));

    public static final Item STONE_BALL = registerItem("stone_ball", new StoneBallItem(new FabricItemSettings()));
    public static final Item SHARPENING_STONE = registerItem("sharpening_stone", new SharpeningStoneItem(new FabricItemSettings()));

    public static final Item SHIT = registerItem("shit", new Item(new FabricItemSettings().food(ModFoodCompenents.SHIT)));

    public static final Item ENDER_PEARL_ARROW = registerItem("ender_pearl_arrow", new EnderArrowItem(new FabricItemSettings()));

    public static final Item METAL_DETECTOR = registerItem("metal_detector", new MetalDetectorItem(new FabricItemSettings().maxDamage(150)));

    public static final Item MUSIC_DISC_1 = registerItem("music_disc_1", new MusicDiscItem(
            7, ModSounds.MUSIC_DISC_1, new FabricItemSettings().maxCount(1), 301));
    public static final Item MUSIC_DISC_2 = registerItem("music_disc_2", new MusicDiscItem(
            7, ModSounds.MUSIC_DISC_2, new FabricItemSettings().maxCount(1), 178));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Kicosidea.MOD_ID, name), item);
    }

    public static void registerModItems(){Kicosidea.LOGGER.info("Registering mod item for" + Kicosidea.MOD_ID);
    }
}
