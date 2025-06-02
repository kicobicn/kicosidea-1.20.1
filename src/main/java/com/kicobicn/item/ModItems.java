package com.kicobicn.item;

import com.kicobicn.Kicosidea;
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
    public static final Item ENDERPEARLBOW = registerItem("ender_pearl_bow", new Item(new FabricItemSettings()));

    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(COIN);
        entries.add(ENDERPEARLBOW);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Kicosidea.MOD_ID, name), item);
    }

    public static void registerModItems(){
        Kicosidea.LOGGER.info("Registering mod item for" + Kicosidea.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);
    }
}
