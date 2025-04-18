package net.packboy.fishy.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.packboy.fishy.Fishy;

public class ModItems {
    public static final FishItem TUNA = register("tuna", new FishItem(FishItem.FishRarity.COMMON, new Item.Settings(), false));
    public static final FishItem COOKED_TUNA = register("cooked_tuna", new FishItem(FishItem.FishRarity.COMMON, new Item.Settings(), true));

    public static final FishItem KOI = register("koi", new FishItem(FishItem.FishRarity.LEGENDARY, new Item.Settings(), false));
    public static final FishItem COOKED_KOI = register("cooked_koi", new FishItem(FishItem.FishRarity.LEGENDARY, new Item.Settings(), true));

    public static final FishItem CATFISH = register("catfish", new FishItem(FishItem.FishRarity.COMMON, new Item.Settings(), false));
    public static final FishItem COOKED_CATFISH = register("cooked_catfish", new FishItem(FishItem.FishRarity.COMMON, new Item.Settings(), true));

    public static final FishItem PLAICE = register("plaice", new FishItem(FishItem.FishRarity.UNCOMMON, new Item.Settings(), false));
    public static final FishItem COOKED_PLAICE = register("cooked_plaice", new FishItem(FishItem.FishRarity.UNCOMMON, new Item.Settings(), true));

    public static final FishItem GARFISH = register("garfish", new FishItem(FishItem.FishRarity.UNCOMMON, new Item.Settings(), false));
    public static final FishItem COOKED_GARFISH = register("cooked_garfish", new FishItem(FishItem.FishRarity.UNCOMMON, new Item.Settings(), true));

    public static final FishItem BASS = register("bass", new FishItem(FishItem.FishRarity.COMMON, new Item.Settings(), false));
    public static final FishItem COOKED_BASS = register("cooked_bass", new FishItem(FishItem.FishRarity.COMMON, new Item.Settings(), true));

    public static final FishItem HERRING = register("herring", new FishItem(FishItem.FishRarity.COMMON, new Item.Settings(), false));
    public static final FishItem RED_HERRING = register("red_herring", new FishItem(FishItem.FishRarity.RARE, new Item.Settings(), false));
    public static final FishItem COOKED_HERRING = register("cooked_herring", new FishItem(FishItem.FishRarity.COMMON, new Item.Settings(), true));

    public static final FishItem ANCHOVY = register("anchovy", new FishItem(FishItem.FishRarity.COMMON, new Item.Settings(), false));
    public static final FishItem COOKED_ANCHOVY = register("cooked_anchovy", new FishItem(FishItem.FishRarity.COMMON, new Item.Settings(), true));

    public static final FishItem SWORDFISH = register("swordfish", new FishItem(FishItem.FishRarity.COMMON, new Item.Settings(), false));
    public static final FishItem COOKED_SWORDFISH = register("cooked_swordfish", new FishItem(FishItem.FishRarity.COMMON, new Item.Settings(), true));

    public static final FishItem GREEN_LUMPFISH = register("green_lumpfish", new FishItem(FishItem.FishRarity.RARE, new Item.Settings(), false));
    public static final FishItem BLUE_LUMPFISH = register("blue_lumpfish", new FishItem(FishItem.FishRarity.RARE, new Item.Settings(), false));
    public static final FishItem PINK_LUMPFISH = register("pink_lumpfish", new FishItem(FishItem.FishRarity.RARE, new Item.Settings(), false));
    public static final FishItem COOKED_LUMPFISH = register("cooked_lumpfish", new FishItem(FishItem.FishRarity.RARE, new Item.Settings(), true));

    public static final FishItem CARP = register("carp", new FishItem(FishItem.FishRarity.COMMON, new Item.Settings(), false));
    public static final FishItem COOKED_CARP = register("cooked_carp", new FishItem(FishItem.FishRarity.COMMON, new Item.Settings(), true));

    public static <T extends Item> T register(String name, T item) {
        return Registry.register(Registries.ITEM, Fishy.id(name), item);
    }

    public static void init() {}
}