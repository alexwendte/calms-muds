package com.mostcalm.calms.muds;

import com.mostcalm.calms.muds.block.Blocks;
import com.mostcalm.calms.muds.entity.EntityTypes;
import com.mostcalm.calms.muds.item.Items;
import com.mostcalm.calms.muds.particle.CMParticleTypes;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class CalmsMuds implements ModInitializer {
  public static Identifier id(String id) {
    return new Identifier("calmsmuds", id);
  }

  @Override
  public void onInitialize() {

    // This code runs as soon as Minecraft is in a mod-load-ready state.
    // However, some things (like resources) may still be uninitialized.
    // Proceed with mild caution.

    System.out.println("Hello Fabric world!");

    Items.init();
    EntityTypes.init();
    Blocks.init();
    CMParticleTypes.init();
    // CMConfiguredFeatures.init();
  }
}
