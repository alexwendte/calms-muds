package com.mostcalm.calms.muds.entity.projectile.thrown;

import com.mostcalm.calms.muds.CalmsMudsClient;
import com.mostcalm.calms.muds.entity.EntitySpawnPacket;
import com.mostcalm.calms.muds.entity.EntityTypes;
import com.mostcalm.calms.muds.item.Items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

@SuppressWarnings("EntityConstructor")
public class MudballEntity extends ThrownItemEntity {
  public MudballEntity(EntityType<? extends MudballEntity> entityType,
      World world) {
    super(entityType, world);
  }

  public MudballEntity(World world, LivingEntity owner) {
    super(EntityTypes.MUDBALL, owner, world);
  }

  public MudballEntity(World world, double x, double y, double z) {
    super(EntityTypes.MUDBALL, x, y, z, world);
  }

  protected Item getDefaultItem() {
    return Items.MUDBALL;
  }

  private ParticleEffect getParticleParameters() {
    ItemStack itemStack = this.getItem();
    return (ParticleEffect) (itemStack.isEmpty() ? ParticleTypes.ITEM_SNOWBALL
        : new ItemStackParticleEffect(ParticleTypes.ITEM, itemStack));
  }

  public void handleStatus(byte status) {
    if (status == 3) {
      ParticleEffect particleEffect = this.getParticleParameters();

      for (int i = 0; i < 8; ++i) {
        this.world.addParticle(particleEffect, this.getX(), this.getY(),
            this.getZ(), 0.0D, 0.0D, 0.0D);
      }
    }

  }

  protected void onEntityHit(EntityHitResult entityHitResult) {
    super.onEntityHit(entityHitResult);
    Entity entity = entityHitResult.getEntity();
    int damageToDo = 100;
    entity.damage(DamageSource.thrownProjectile(this, this.getOwner()),
        (float) damageToDo);
  }

  protected void onCollision(HitResult hitResult) {
    super.onCollision(hitResult);
    if (!this.world.isClient) {
      this.world.sendEntityStatus(this, (byte) 3);
      this.discard();
    }

  }

  @Override
  public Packet createSpawnPacket() {
    return EntitySpawnPacket.create(this, CalmsMudsClient.PacketID);
  }
}
