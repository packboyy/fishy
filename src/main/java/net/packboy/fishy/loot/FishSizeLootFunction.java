package net.packboy.fishy.loot;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import net.packboy.fishy.item.FishItem;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.function.ConditionalLootFunction;
import net.minecraft.loot.function.LootFunctionType;
import net.minecraft.util.JsonHelper;

import java.util.Random;

public class FishSizeLootFunction extends ConditionalLootFunction {
    private final int min;
    private final int max;
    private static final Random RANDOM = new Random();

    protected FishSizeLootFunction(LootCondition[] conditions, int min, int max) {
        super(conditions);
        this.min = min;
        this.max = max;
    }

    public static Builder builder(int min, int max) {
        return new Builder(min, max);
    }

    public static final LootFunctionType TYPE = new LootFunctionType(new Serializer());

    @Override
    public LootFunctionType getType() {
        return TYPE;
    }

    @Override
    protected ItemStack process(ItemStack stack, LootContext context) {
        if (stack.getItem() instanceof FishItem) {
            int size;
            if (max > min) {
                double randomValue = RANDOM.nextDouble();
                double power = 5.0;
                double percentage = Math.pow(randomValue, power);
                size = min + (int)(percentage * (max - min));
            } else {
                size = min;
            }
            FishItem.setSize(stack, size);
        }
        return stack;
    }

    public static class Builder extends ConditionalLootFunction.Builder<Builder> {
        private final int min;
        private final int max;

        public Builder(int min, int max) {
            this.min = min;
            this.max = Math.max(min, max); // Ensure max is at least min
        }

        @Override
        protected Builder getThisBuilder() {
            return this;
        }

        @Override
        public ConditionalLootFunction build() {
            return new FishSizeLootFunction(getConditions(), min, max);
        }
    }

    public static class Serializer extends ConditionalLootFunction.Serializer<FishSizeLootFunction> {
        @Override
        public void toJson(JsonObject json, FishSizeLootFunction function, JsonSerializationContext context) {
            super.toJson(json, function, context);
            json.addProperty("min", function.min);
            json.addProperty("max", function.max);
        }

        @Override
        public FishSizeLootFunction fromJson(JsonObject json, JsonDeserializationContext context, LootCondition[] conditions) {
            int min = JsonHelper.getInt(json, "min", 0);
            int max = JsonHelper.getInt(json, "max", 4096);
            return new FishSizeLootFunction(conditions, min, max);
        }
    }
}