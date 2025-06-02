package com.kicobicn.item;

import com.kicobicn.Kicosidea;
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
                        entries.add(ModItems.TNTSNOWBALL);
                        entries.add(ModItems.STONEBALL);

                    }).build());


    public static void registerItemGroups(){
        Kicosidea.LOGGER.info("Registering Item Group for " + Kicosidea.MOD_ID);
    }
}
