package net.packboy.fishy.item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.FoodComponent;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class FishItem extends Item {
    private static final String SIZE_KEY = "FishSize";
    private static final Random RANDOM = new Random();

    private static final int BASE_HUNGER = 1;
    private static final float BASE_SATURATION = 0.1f;
    private static final int MAX_HUNGER = 1024;
    private static final float MAX_SATURATION = 24.0f;

    public enum FishRarity {
        COMMON(Formatting.WHITE, "item.fish.rarity.common"),
        UNCOMMON(Formatting.GREEN, "item.fish.rarity.uncommon"),
        RARE(Formatting.BLUE, "item.fish.rarity.rare"),
        SUPER_RARE(Formatting.LIGHT_PURPLE, "item.fish.rarity.super_rare"),
        LEGENDARY(Formatting.GOLD, "item.fish.rarity.legendary");

        private final Formatting color;
        private final String translationKey;

        FishRarity(Formatting color, String translationKey) {
            this.color = color;
            this.translationKey = translationKey;
        }

        public Formatting getColor() {
            return color;
        }

        public String getTranslationKey() {
            return translationKey;
        }

        public Text getText() {
            return Text.translatable(translationKey).formatted(color);
        }
    }

    private final FishRarity fishRarity;

    public FishItem(FishRarity fishRarity, Settings settings) {
        super(settings.food(new FoodComponent.Builder()
                .hunger(BASE_HUNGER)
                .saturationModifier(BASE_SATURATION)
                .build()));
        this.fishRarity = fishRarity;
    }

    public static int getSize(ItemStack stack) {
        NbtCompound nbt = stack.getNbt();
        if (nbt != null && nbt.contains(SIZE_KEY)) {
            return nbt.getInt(SIZE_KEY);
        }
        return 1;
    }

    public static void setSize(ItemStack stack, int size) {
        int clampedSize = Math.max(1, Math.min(size, 4096));
        NbtCompound nbt = stack.getOrCreateNbt();
        nbt.putInt(SIZE_KEY, clampedSize);
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
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.fish.rarity", fishRarity.getText()));
        int size = getSize(stack);
        tooltip.add(Text.translatable("item.fish.size", size).formatted(Formatting.GRAY));
        super.appendTooltip(stack, world, tooltip, context);
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
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        return super.use(world, user, hand);
    }
}