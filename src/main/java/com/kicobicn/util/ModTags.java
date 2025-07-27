package com.kicobicn.util;

import com.kicobicn.Kicosidea;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Block {
        public static final TagKey<net.minecraft.block.Block> METAL_DETECTOR_DETECTAbLC_BLOCKS =
                createTags("metal_detector_detectable_block");

        private static TagKey<net.minecraft.block.Block> createTags(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(Kicosidea.MOD_ID, name));
        }
    }

    public static class Item {

        private static TagKey<net.minecraft.item.Item> createTags(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(Kicosidea.MOD_ID, name));
        }
    }
}

