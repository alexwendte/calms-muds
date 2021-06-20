package com.mostcalm.calms.muds.registry;

import com.mostcalm.calms.muds.CalmsMuds;
import com.mostcalm.calms.muds.MudFoodComponents;
import com.mostcalm.calms.muds.item.*;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.registry.Registry;

public class CMItems {
	public static final MudballItem MUDBALL = register("mudball",
			new MudballItem(new Item.Settings().group(ItemGroup.MISC)));

	public static final DriedMudBallItem DRIED_MUDBALL = register("dried_mudball",
			new DriedMudBallItem(new Item.Settings().group(ItemGroup.FOOD).food(MudFoodComponents.DRIED_MUDBALL)));

	private static <T extends Item> T register(String name, T item) {
		return Registry.register(Registry.ITEM, CalmsMuds.id(name), item);
	}

	public static void init() {
		// NO-OP
	}

	private CMItems() {
		// NO-OP
	}
}
