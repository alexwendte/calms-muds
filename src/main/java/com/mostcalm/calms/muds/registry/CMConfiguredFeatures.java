package com.mostcalm.calms.muds.registry;

import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class CMConfiguredFeatures {
	// public static final EntityType<MudballEntity> SPEAR = register("spear",
	// FabricEntityTypeBuilder.<MudballEntity>create(SpawnGroup.MISC,
	// (MudballEntity::new)).trackRangeBlocks(128)
	// .trackedUpdateRate(1).forceTrackedVelocityUpdates(true).dimensions(EntityDimensions.fixed(.25f,
	// .25f))
	// .build());

	// private static ConfiguredFeature<?, ?> MUD_ORE_OVERWORLD =
	// register("mud_ore",
	// Feature.ORE
	// .configure(
	// new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
	// CMBlocks.MUD_ORE.getDefaultState(), 9))
	// .uniformRange(YOffset.getBottom(),
	// YOffset.fixed(64)).spreadHorizontally().repeat(20));

	// private static <FC extends FeatureConfig> ConfiguredFeature<FC, ?>
	// register(String id,
	// ConfiguredFeature<FC, ?> configuredFeature) {
	// return (ConfiguredFeature)
	// Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, (String) id,
	// configuredFeature);
	// }

	public static void init() {
		// BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
		// GenerationStep.Feature.UNDERGROUND_ORES,
		// mudOreOverworld);
	}

	private CMConfiguredFeatures() {
		// NO-OP
	}
}