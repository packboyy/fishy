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

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		ModItems.init();
		FishingLootModifier.init();
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}