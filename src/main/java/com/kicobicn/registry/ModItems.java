package com.kicobicn.registry;

import com.kicobicn.Kicosidea;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModItems {

    public  static  final Item COIN = registItem("coin",
            new Item(new FabricItemSettings()));

    public  static  final Item ENDERPEARLBOW = registItem("ender_pearl_bow",
            new Item(new FabricItemSettings()));

    @SafeVarargs
    public static Item registItem(String name, Item item, RegistryKey<ItemGroup>... itemGroups) {
        Item registeredItem = Registry.register(Registries.ITEM, new Identifier(Kicosidea.MOD_ID, name), item);
        for (RegistryKey<ItemGroup> itemGroup : itemGroups) {
            ItemGroupEvents.modifyEntriesEvent(itemGroup).register(fabricItemGroupEntries -> fabricItemGroupEntries.add(registeredItem));
        }
        return registeredItem;
    }
    public static  void registerModItems(){
        Kicosidea.LOGGER.debug("Registering mod item for" + Kicosidea.MOD_ID);
    }
}
