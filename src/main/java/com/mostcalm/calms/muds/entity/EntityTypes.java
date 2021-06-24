package com.mostcalm.calms.muds.entity;

import com.mostcalm.calms.muds.entity.projectile.thrown.MudballEntity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.registry.Registry;

public class EntityTypes<T extends Entity> {

  public static final EntityType<MudballEntity> MUDBALL;

  static {
    MUDBALL = register("mudball",
        FabricEntityTypeBuilder
            .<MudballEntity> create(SpawnGroup.MISC, MudballEntity::new)
            .dimensions(EntityDimensions.fixed(0.25F, 0.25F)) // dimensions in Minecraft units of the projectile
            .trackRangeBlocks(4)
            .trackedUpdateRate(10) // necessary for all thrown projectiles (as it prevents it from breaking, lol)
            .build()); // VERY IMPORTANT DONT DELETE FOR THE LOVE OF GOD PSLSSSSSS
  }

  private EntityTypes() {
    // NO-OP
  }

  private static <T extends Entity> EntityType<T> register(String id,
      EntityType<T> type) {
    return Registry.register(Registry.ENTITY_TYPE, (String) id, type);
  }

  public static void init() {
    // NO-OP
  }
}
