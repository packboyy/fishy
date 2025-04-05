package net.packboy.fishy;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.util.Identifier;
import net.packboy.fishy.item.ModItems;
import net.packboy.fishy.loot.FishSizeLootFunction;
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
		FishingLootModifier.init();
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}