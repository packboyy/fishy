package net.packboy.fishy.item;

import com.mojang.serialization.Codec;
import net.minecraft.component.ComponentType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class FishItem extends Item {
    public static final ComponentType<Integer> FISH_SIZE = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of("fishy", "fish_size"),
            ComponentType.<Integer>builder().codec(Codec.INT).build()
    );

    private static final int BASE_HUNGER = 1;
    private static final float BASE_SATURATION = 0.1f;
    private static final int MAX_HUNGER = 1024;
    private static final float MAX_SATURATION = 24.0f;

    public enum FishRarity {
        COMMON(Formatting.GREEN, "item.fish.rarity.common"),
        UNCOMMON(Formatting.BLUE, "item.fish.rarity.uncommon"),
        RARE(Formatting.RED, "item.fish.rarity.rare"),
        SUPER_RARE(Formatting.LIGHT_PURPLE, "item.fish.rarity.super_rare"),
        LEGENDARY(Formatting.GOLD, "item.fish.rarity.legendary");

        private final Formatting color;
        private final String translationKey;

        FishRarity(Formatting color, String translationKey) {
            this.color = color;
            this.translationKey = translationKey;
        }
        public Text getText() {
            return Text.translatable(translationKey).formatted(color);
        }
    }

    public final FishRarity fishRarity;
    private final boolean IsCooked;

    public FishItem(FishRarity fishRarity, Settings settings, boolean isCooked) {
        super(settings.food(new FoodComponent.Builder()
                .nutrition(isCooked ? BASE_HUNGER * 2 : BASE_HUNGER)
                .saturationModifier(BASE_SATURATION)
                .build()));
        this.fishRarity = fishRarity;
        IsCooked = isCooked;
    }

    public static int getSize(ItemStack stack) {
        if (stack.contains(FISH_SIZE)) {
            return stack.get(FISH_SIZE);
        }
        return 1;
    }

    public static void setSize(ItemStack stack, int size) {
        int clampedSize = Math.max(1, Math.min(size, 4096));
        stack.set(FISH_SIZE, clampedSize);
    }

    private int getHungerFromSize(int size) {
        double sizeRatio = (double) size / 4096.0;
        int additionalHunger = (int) Math.round((MAX_HUNGER - BASE_HUNGER) * sizeRatio);
        return BASE_HUNGER + additionalHunger;
    }

    private float getSaturationFromSize(int size) {
        double sizeRatio = (double) size / 4096.0;
        float additionalSaturation = (float) ((MAX_SATURATION - BASE_SATURATION) * sizeRatio);
        return BASE_SATURATION + additionalSaturation;
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (user instanceof PlayerEntity player && !world.isClient) {
            int size = getSize(stack);
            int hunger = getHungerFromSize(size);
            float saturation = getSaturationFromSize(size);
            player.getHungerManager().add(hunger, saturation);
        }
        return super.finishUsing(stack, world, user);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        return super.use(world, user, hand);
    }
}