package net.packboy.fishy;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.packboy.fishy.item.FishItem;

import static net.packboy.fishy.item.FishItem.getSize;

public class FishyClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		registerTooltipCallback();
	}
	private void registerTooltipCallback() {
		ItemTooltipCallback.EVENT.register((stack, context, tooltipType, tooltip) -> {
			if (stack.getItem() instanceof FishItem) {
				tooltip.add(Text.translatable("item.fish.rarity", ((FishItem)stack.getItem()).fishRarity.getText()));
				int size = getSize(stack);
				tooltip.add(Text.translatable("item.fish.size", size).formatted(Formatting.GRAY));
			}
		});
	}
}