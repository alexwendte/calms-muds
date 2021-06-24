package com.mostcalm.calms.muds.block;

import com.mostcalm.calms.muds.CalmsMuds;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.registry.Registry;

public class Blocks {
	public static final Block MUD_BLOCK;
	public static final Block MUD_ORE;


	private static Block register(String id, Block block) {
		return Registry.register(Registry.BLOCK, CalmsMuds.id(id), block);
	}

	static {
		MUD_BLOCK = register("mud_block", new MudBlock(FabricBlockSettings.of(Material.SOIL)
				.strength(0.5F, 0.5F).sounds(BlockSoundGroup.GRAVEL).breakByTool(FabricToolTags.SHOVELS)));
		MUD_ORE =
				register("mud_ore", new MudOreBlock(FabricBlockSettings.of(Material.STONE).strength(3F, 3F)
						.sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES).requiresTool()));
	}

	public static void init() {
		// NO-OP
	}
}
