package com.mostcalm.calms.muds;

import java.util.UUID;

import com.mostcalm.calms.muds.entity.EntitySpawnPacket;
import com.mostcalm.calms.muds.entity.EntityTypes;
import com.mostcalm.calms.muds.item.Items;
import com.mostcalm.calms.muds.particle.CMParticleTypes;
import com.mostcalm.calms.muds.particle.MudballParticle;

import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.Registry;

public class CalmsMudsClient implements net.fabricmc.api.ClientModInitializer {

  public static final Identifier PacketID = CalmsMuds.id("spawn_packet");

  @Override
  public void onInitializeClient() {
    EntityRendererRegistry.INSTANCE.register(EntityTypes.MUDBALL,
        (context, Context) -> new FlyingItemEntityRenderer(context,
            Context.getItemRenderer()));
    ParticleFactoryRegistry.getInstance()
        .register(CMParticleTypes.ITEM_MUDBALL,
            // new MudballParticle.Factory(new MudballItem(new Item.Settings())));
            new MudballParticle.Factory(Items.MUDBALL));
    receiveEntityPacket();
  }

  public void receiveEntityPacket() {
    ClientSidePacketRegistry.INSTANCE.register(PacketID, (ctx, byteBuf) -> {
      EntityType<?> et = Registry.ENTITY_TYPE.get(byteBuf.readVarInt());
      UUID uuid = byteBuf.readUuid();
      int entityId = byteBuf.readVarInt();
      Vec3d pos = EntitySpawnPacket.PacketBufUtil.readVec3d(byteBuf);
      float pitch = EntitySpawnPacket.PacketBufUtil.readAngle(byteBuf);
      float yaw = EntitySpawnPacket.PacketBufUtil.readAngle(byteBuf);
      ctx.getTaskQueue().execute(() -> {
        if (MinecraftClient.getInstance().world == null)
          throw new IllegalStateException(
              "Tried to spawn entity in a null world!");
        Entity e = et.create(MinecraftClient.getInstance().world);
        if (e == null)
          throw new IllegalStateException(
              "Failed to create instance of entity \""
                  + Registry.ENTITY_TYPE.getId(et) + "\"!");
        e.updateTrackedPosition(pos);
        e.setPos(pos.x, pos.y, pos.z);
        e.pitch = pitch;
        e.yaw = yaw;
        e.setEntityId(entityId);
        e.setUuid(uuid);
        MinecraftClient.getInstance().world.addEntity(entityId, e);
      });
    });
  }
}
