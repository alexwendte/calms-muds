package com.mostcalm.calms.muds.item;

import com.mostcalm.calms.muds.entity.projectile.thrown.MudballEntity;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class MudballItem extends Item {
  public MudballItem(Item.Settings settings) {
    super(settings);
  }

  public TypedActionResult<ItemStack> use(World world, PlayerEntity user,
      Hand hand) {
    ItemStack itemStack = user.getStackInHand(hand);
    world.playSound(null, user.getX(), user.getY(), user.getZ(),
        SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F,
        0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
    if (!world.isClient) {
      MudballEntity mudballEntity = new MudballEntity(world, user);
      mudballEntity.setItem(itemStack);
      mudballEntity.setProperties(user, user.pitch, user.yaw, 0.0F, 1.5F, 1.0F);
      world.spawnEntity(mudballEntity);
    }

    user.incrementStat(Stats.USED.getOrCreateStat(this));
    if (!user.abilities.creativeMode) {
      itemStack.decrement(1);
    }

    return TypedActionResult.success(itemStack, world.isClient());
  }
}
