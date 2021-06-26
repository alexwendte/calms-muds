package com.mostcalm.calms.muds.particle;

import com.mostcalm.calms.muds.CalmsMuds;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.registry.Registry;

public class CMParticleTypes {
  public static final DefaultParticleType ITEM_MUDBALL;

  static {
    ITEM_MUDBALL = register("item_mudball");
  }

  private static DefaultParticleType register(String name) {
    System.out.printf("register %s\n", name);
    return Registry.register(Registry.PARTICLE_TYPE, CalmsMuds.id(name),
        FabricParticleTypes.simple());
  }

  public static void init() {
    // NO-OP
  }
}
