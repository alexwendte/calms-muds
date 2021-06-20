package com.mostcalm.calms.muds;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class MudFoodComponents {
	public static final FoodComponent DRIED_MUDBALL = new FoodComponent.Builder().hunger(2).saturationModifier(0.3F)
			.statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 600, 0), .8F).snack().build();
}
