package com.mostcalm.calms.muds.registry;

import com.mostcalm.calms.muds.CalmsMuds;
import com.mostcalm.calms.muds.entity.MudballEntity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.registry.Registry;

public class CMEntities {
	public static final EntityType<MudballEntity> SPEAR = register("spear",
			FabricEntityTypeBuilder.<MudballEntity>create(SpawnGroup.MISC, (MudballEntity::new)).trackRangeBlocks(128)
					.trackedUpdateRate(1).forceTrackedVelocityUpdates(true).dimensions(EntityDimensions.fixed(.25f, .25f))
					.build());

	private static <T extends Entity> EntityType<T> register(String name, EntityType<T> entity) {
		return Registry.register(Registry.ENTITY_TYPE, CalmsMuds.id(name), entity);
	}

	private static <T extends BlockEntity> BlockEntityType<T> register(String name, BlockEntityType<T> entity) {
		return Registry.register(Registry.BLOCK_ENTITY_TYPE, CalmsMuds.id(name), entity);
	}

	public static void init() {
		// NO-OP
	}

	private CMEntities() {
		// NO-OP
	}
}
