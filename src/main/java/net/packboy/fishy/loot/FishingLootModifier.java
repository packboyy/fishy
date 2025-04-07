package net.packboy.fishy.loot;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;

import static net.packboy.fishy.item.ModItems.*;

public class FishingLootModifier {
    public static void init() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (LootTables.FISHING_FISH_GAMEPLAY.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .with(ItemEntry.builder(TUNA).weight(60)
                                .apply(FishSizeLootFunction.builder(5, 500)))
                        .with(ItemEntry.builder(GARFISH).weight(60)
                                .apply(FishSizeLootFunction.builder(5, 500)))
                        .with(ItemEntry.builder(CATFISH).weight(60)
                                .apply(FishSizeLootFunction.builder(5, 500)))
                        .with(ItemEntry.builder(BASS).weight(60)
                                .apply(FishSizeLootFunction.builder(5, 500)))
                        .with(ItemEntry.builder(HERRING).weight(60)
                                .apply(FishSizeLootFunction.builder(5, 500)))
                        .with(ItemEntry.builder(PLAICE).weight(25)
                                .apply(FishSizeLootFunction.builder(5, 500)))
                        .with(ItemEntry.builder(KOI).weight(10)
                                .apply(FishSizeLootFunction.builder(5, 1500)))
//                        .with(ItemEntry.builder(TUNA).weight(4)
//                                .apply(FishSizeLootFunction.builder(1000, 2000)))
//                        .with(ItemEntry.builder(TUNA).weight(1)
//                                .apply(FishSizeLootFunction.builder(1500, 2568)))
                        ;
                tableBuilder.pool(poolBuilder);
            }
        });
    }
}
