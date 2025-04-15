package net.packboy.fishy.loot;

import net.fabricmc.fabric.api.loot.v2.FabricLootTableBuilder;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;

import static net.packboy.fishy.item.ModItems.*;

public class FishingLootModifier {


    public static void ModifyFishTable() {
        LootTableEvents.MODIFY.register((ResourceManager, LootManager, id, tablebuilder, source) -> {
            if (LootTables.FISHING_FISH_GAMEPLAY.equals(id)) {
                tablebuilder.modifyPools((pools) -> {
                    pools
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
                            .with(ItemEntry.builder(PLAICE).weight(25)
                                    .apply(FishSizeLootFunction.builder(20, 150)))
                            .with(ItemEntry.builder(KOI).weight(1)
                                    .apply(FishSizeLootFunction.builder(1, 200)))
                            .with(ItemEntry.builder(SWORDFISH).weight(1)
                                    .apply(FishSizeLootFunction.builder(300, 5000)))
                            .with(ItemEntry.builder(GREEN_LUMPFISH).weight(1)
                                    .apply(FishSizeLootFunction.builder(20, 70)))
                            .with(ItemEntry.builder(BLUE_LUMPFISH).weight(1)
                                    .apply(FishSizeLootFunction.builder(20, 70)))
                            .with(ItemEntry.builder(PINK_LUMPFISH).weight(1)
                                    .apply(FishSizeLootFunction.builder(20, 70)));
                });
            }
        });
    }
}
