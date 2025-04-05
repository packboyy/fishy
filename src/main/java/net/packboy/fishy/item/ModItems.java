package net.packboy.fishy.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.packboy.fishy.Fishy;

public class ModItems {
    public static final Identifier SET_FISH_SIZE_ID = new Identifier("fishy", "set_fish_size");

    public static final FishItem TUNA = register("tuna", new FishItem(FishItem.FishRarity.COMMON, new Item.Settings()));
    public static final FishItem KOI = register("koi", new FishItem(FishItem.FishRarity.RARE, new Item.Settings()));
    public static final FishItem CATFISH = register("catfish", new FishItem(FishItem.FishRarity.COMMON, new Item.Settings()));
    public static final FishItem PLAICE = register("plaice", new FishItem(FishItem.FishRarity.COMMON, new Item.Settings()));



    public static <T extends Item> T register(String name, T item) {
        return Registry.register(Registries.ITEM,Fishy.id(name),item);
    }

    public static void init() {}
}
