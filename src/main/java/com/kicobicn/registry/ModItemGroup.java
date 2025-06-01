package com.kicobicn.registry;

import com.kicobicn.Kicosidea;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {

    public static ItemGroup NORMAL = FabricItemGroup.builder()

            .displayName(Text.translatable("itemgroup.kicosidea.coin"))
            .icon(()-> new ItemStack(ModItems.COIN))
            .build();
    public static void registerModItemGroup(){
        Kicosidea.LOGGER.debug("Registering mod item group for" + Kicosidea.MOD_ID);
    }
}
