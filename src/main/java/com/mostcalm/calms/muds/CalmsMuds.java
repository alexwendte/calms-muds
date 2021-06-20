package com.mostcalm.calms.muds;

import com.mostcalm.calms.muds.registry.*;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class CalmsMuds implements ModInitializer {
	public static Identifier id(String name) {
		return new Identifier("calmsmuds", name);
	}

	@Override
	public void onInitialize() {

		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		System.out.println("Hello Fabric world!");

		CMItems.init();
		CMEntities.init();
		CMBlocks.init();
		CMConfiguredFeatures.init();
	}
}