package net.packboy.fishy.loot;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.entry.ItemEntry;

import static net.packboy.fishy.item.ModItems.*;

public class FishingLootModifier {
    public static void init() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (LootTables.FISHING_FISH_GAMEPLAY.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .with(ItemEntry.builder(TUNA).weight(60)
                                .apply(FishSizeLootFunction.builder(5, 300)))
                        .with(ItemEntry.builder(GARFISH).weight(60)
                                .apply(FishSizeLootFunction.builder(5, 300)))
                        .with(ItemEntry.builder(CATFISH).weight(60)
                                .apply(FishSizeLootFunction.builder(5, 70)))
                        .with(ItemEntry.builder(BASS).weight(60)
                                .apply(FishSizeLootFunction.builder(5, 500)))
                        .with(ItemEntry.builder(ANCHOVY).weight(60)
                                .apply(FishSizeLootFunction.builder(2, 100)))
                        .with(ItemEntry.builder(HERRING).weight(60)
                                .apply(FishSizeLootFunction.builder(5, 500)))
                        .with(ItemEntry.builder(RED_HERRING).weight(10)
                                .apply(FishSizeLootFunction.builder(5, 500)))
                        .with(ItemEntry.builder(CARP).weight(60)
                                .apply(FishSizeLootFunction.builder(40, 500)))
                        .with(ItemEntry.builder(PLAICE).weight(25)
                                .apply(FishSizeLootFunction.builder(20, 150)))
//                        .with(ItemEntry.builder(KOI).weight(10)
//                                .apply(FishSizeLootFunction.builder(5, 1500)))
//                        .with(ItemEntry.builder(TUNA).weight(4)
//                                .apply(FishSizeLootFunction.builder(1000, 2000)))
                        .with(ItemEntry.builder(SWORDFISH).weight(4)
                                .apply(FishSizeLootFunction.builder(300, 5000)))
                        .with(ItemEntry.builder(GREEN_LUMPFISH).weight(4)
                                .apply(FishSizeLootFunction.builder(20, 70)))
                        .with(ItemEntry.builder(BLUE_LUMPFISH).weight(4)
                                .apply(FishSizeLootFunction.builder(20, 70)))
                        .with(ItemEntry.builder(PINK_LUMPFISH).weight(4)
                                .apply(FishSizeLootFunction.builder(20, 70)))
                        .with(ItemEntry.builder(KOI).weight(1)
                                .apply(FishSizeLootFunction.builder(1, 200)))
                        ;
                tableBuilder.pool(poolBuilder);
            }
        });
    }
}
