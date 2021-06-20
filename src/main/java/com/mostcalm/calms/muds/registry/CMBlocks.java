package com.mostcalm.calms.muds.registry;

import com.mostcalm.calms.muds.CalmsMuds;
import com.mostcalm.calms.muds.block.*;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.registry.Registry;

public class CMBlocks {
	private static <T extends Block> T register(String name, T block, Item.Settings settings) {
		T registeredBlock = Registry.register(Registry.BLOCK, CalmsMuds.id(name), block);
		Registry.register(Registry.ITEM, CalmsMuds.id(name), new BlockItem(registeredBlock, settings));
		return registeredBlock;
	}

	private static <T extends Block> T register(String name, T block) {
		return Registry.register(Registry.BLOCK, CalmsMuds.id(name), block);
	}

	public static final Block MUD_BLOCK = register("mud_block", new MudBlock(FabricBlockSettings.of(Material.SOIL)
			.strength(0.5F, 0.5F).sounds(BlockSoundGroup.GRAVEL).breakByTool(FabricToolTags.SHOVELS)));

	public static final Block MUD_ORE = register("mud_ore", new MudOreBlock(FabricBlockSettings.of(Material.STONE)
			.strength(3F, 3F).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES).requiresTool()));

	public static void init() {
		// NO-OP
	}

	private CMBlocks() {
		// NO-OP
	}
}
