package net.packboy.fishy;

import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import net.packboy.fishy.item.ModItems;
import net.packboy.fishy.loot.FishingLootModifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Fishy implements ModInitializer {
	public static final String MOD_ID = "fishy";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		ModItems.init();
		FishingLootModifier.ModifyFishTable();
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}