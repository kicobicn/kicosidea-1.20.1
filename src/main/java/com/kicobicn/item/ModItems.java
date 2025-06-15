package com.kicobicn.item;

import com.kicobicn.Kicosidea;
import com.kicobicn.item.custom.MetalDetectorItem;
import com.kicobicn.item.custom.StoneBallItem;
import com.kicobicn.item.custom.TNTBallItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModItems {

    public static final Item COIN = registerItem("coin", new Item(new FabricItemSettings()));
    public static final Item TNTSBALL = registerItem("tnt_snowball", new TNTBallItem(new FabricItemSettings()));
    public static final Item STONEBALL = registerItem("stone_ball", new StoneBallItem(new FabricItemSettings()));
    public static final Item SHIT = registerItem("shit", new Item(new FabricItemSettings()));

    public static final Item METAL_DETECTOR = registerItem("metal_detector", new MetalDetectorItem(new FabricItemSettings().maxDamage(150)));



    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries) {

    }

    private static void addItemsToCombatTabItemGroup(FabricItemGroupEntries entries) {

    }

    private static void addItemsToBuildingBlockTabItemGroup(FabricItemGroupEntries entries) {

    }


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Kicosidea.MOD_ID, name), item);
    }

    public static void registerModItems(){
        Kicosidea.LOGGER.info("Registering mod item for" + Kicosidea.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToCombatTabItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ModItems::addItemsToBuildingBlockTabItemGroup);
    }
}
