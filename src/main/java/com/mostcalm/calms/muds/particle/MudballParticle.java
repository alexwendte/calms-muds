package com.mostcalm.calms.muds.particle;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.particle.ParticleTextureSheet;
import net.minecraft.client.particle.SpriteBillboardParticle;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.particle.DefaultParticleType;

/**
 * LightParticle
 *
 * @author Hexeption admin@hexeption.co.uk
 * @since 17/05/2020 - 04:34 pm
 */
public class MudballParticle extends SpriteBillboardParticle {

  protected MudballParticle(ClientWorld world, double x, double y, double z,
      ItemConvertible itemConvertible) {
    super(world, x, y, z);
    this.setSprite(MinecraftClient.getInstance()
        .getItemRenderer()
        .getModels()
        .getSprite(itemConvertible));
    this.maxAge = 80;
  }

  public ParticleTextureSheet getType() {
    return ParticleTextureSheet.TERRAIN_SHEET;
  }

  public static class Factory implements ParticleFactory<DefaultParticleType> {

    private Item theItem;

    public Factory(Item item) {
      theItem = item;
    }

    @Override
    public Particle createParticle(DefaultParticleType parameters,
        ClientWorld world, double x, double y, double z, double velocityX,
        double velocityY, double velocityZ) {
      return new MudballParticle(world, x, y, z, theItem);
    }
  }
}
