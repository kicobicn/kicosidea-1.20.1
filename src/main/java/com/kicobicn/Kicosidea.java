package com.kicobicn;

import com.kicobicn.block.ModBlocks;
import com.kicobicn.item.ModItemGroups;
import com.kicobicn.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Kicosidea implements ModInitializer {
	public static final String MOD_ID = "kicosidea";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		LOGGER.info("Kicos idea mod");
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		ModBlocks.registerModBlocks();
	}
}