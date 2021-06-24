package com.mostcalm.calms.muds.item;

import java.util.Optional;
import com.mostcalm.calms.muds.CalmsMuds;
import com.mostcalm.calms.muds.MudFoodComponents;
import com.mostcalm.calms.muds.block.Blocks;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Items {
	public static final Item MUDBALL;
	public static final Item DRIED_MUDBALL;
	public static final Item MUD_BLOCK;
	public static final Item MUD_ORE;


	private static Item register(String id, Item item) {
		return register(CalmsMuds.id(id), item);
	}


	private static Item register(Block block) {
		return register(new BlockItem(block, new Item.Settings()));
	}

	private static Item register(Block block, ItemGroup group) {
		return register(new BlockItem(block, (new Item.Settings()).group(group)));
	}

	private static Item register(Block block, Optional<ItemGroup> group) {
		return (Item) group.map((groupx) -> {
			return register(block, groupx);
		}).orElseGet(() -> {
			return register(block);
		});
	}

	private static Item register(Block block, ItemGroup group, Block... blocks) {
		BlockItem blockItem = new BlockItem(block, (new Item.Settings()).group(group));
		Block[] var4 = blocks;
		int var5 = blocks.length;

		for (int var6 = 0; var6 < var5; ++var6) {
			Block block2 = var4[var6];
			Item.BLOCK_ITEMS.put(block2, blockItem);
		}

		return register(blockItem);
	}

	private static Item register(BlockItem item) {
		return register((Block) item.getBlock(), (Item) item);
	}

	protected static Item register(Block block, Item item) {
		return register(Registry.BLOCK.getId(block), item);
	}


	private static Item register(Identifier id, Item item) {
		if (item instanceof BlockItem) {
			((BlockItem) item).appendBlocks(Item.BLOCK_ITEMS, item);
		}

		return (Item) Registry.register(Registry.ITEM, (Identifier) id, item);
	}

	static {
		MUDBALL = register("mudball",
				(Item) (new MudballItem(new Item.Settings().group(ItemGroup.MISC).maxCount(16))));
		DRIED_MUDBALL = register("dried_mudball", (Item) (new DriedMudBallItem(new Item.Settings()
				.group(ItemGroup.FOOD).food(MudFoodComponents.DRIED_MUDBALL).maxCount(16))));
		MUD_BLOCK = register(Blocks.MUD_BLOCK, ItemGroup.BUILDING_BLOCKS);
		MUD_ORE = register(Blocks.MUD_ORE, ItemGroup.BUILDING_BLOCKS);
	}


	public static void init() {
		// NO-OP
	}
}
