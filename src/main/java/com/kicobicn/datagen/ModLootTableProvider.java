package com.kicobicn.datagen;

import com.kicobicn.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.EXPERIENCE_ORE, copperLikeOreDrops(ModBlocks.EXPERIENCE_ORE, Items.AIR));
        addDrop(ModBlocks.DEEPSLATE_EXPERIENCE_ORE, copperLikeOreDrops(ModBlocks.EXPERIENCE_ORE, Items.AIR));
        addDrop(ModBlocks.NETHER_EXPERIENCE_ORE, copperLikeOreDrops(ModBlocks.EXPERIENCE_ORE, Items.AIR));
        addDrop(ModBlocks.END_STONE_EXPERIENCE_ORE, copperLikeOreDrops(ModBlocks.EXPERIENCE_ORE, Items.AIR));

    }
    public LootTable.Builder copperLikeOreDrops(Block drop, Item item) {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop, (LootPoolEntry.Builder)this.applyExplosionDecay(drop,
                ((LeafEntry.Builder)
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider
                                        .create(2.0f, 6.0f))))
                        .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }
}
