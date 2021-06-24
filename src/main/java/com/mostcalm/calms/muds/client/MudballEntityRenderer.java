package com.mostcalm.calms.muds.client;

import com.mostcalm.calms.muds.entity.projectile.thrown.MudballEntity;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Matrix3f;
import net.minecraft.util.math.Matrix4f;
import net.minecraft.util.math.Vec3f;

public class MudballEntityRenderer extends EntityRenderer<MudballEntity> {

  public MudballEntityRenderer(EntityRendererFactory.Context context) {
    super(context);
  }

  public void render(MudballEntity persistentProjectileEntity, float f, float g,
      MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider,
      int i) {

    matrixStack.push();
    matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(
        MathHelper.lerp(g, persistentProjectileEntity.prevYaw,
            persistentProjectileEntity.getYaw()) - 90.0F));
    matrixStack.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(
        MathHelper.lerp(g, persistentProjectileEntity.prevPitch,
            persistentProjectileEntity.getPitch())));
    boolean j = false;
    float h = 0.0F;
    float k = 0.5F;
    float l = 0.0F;
    float m = 0.15625F;
    float n = 0.0F;
    float o = 0.15625F;
    float p = 0.15625F;
    float q = 0.3125F;
    float r = 0.05625F;
    // float s = (float)persistentProjectileEntity.shake - g;
    // if (s > 0.0F) {
    // float t = -MathHelper.sin(s * 3.0F) * s;
    // matrixStack.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(t));
    // }

    matrixStack.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(45.0F));
    matrixStack.scale(0.05625F, 0.05625F, 0.05625F);
    matrixStack.translate(-4.0D, 0.0D, 0.0D);
    VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(RenderLayer
        .getEntityCutout(this.getTexture(persistentProjectileEntity)));
    MatrixStack.Entry entry = matrixStack.peek();
    Matrix4f matrix4f = entry.getModel();
    Matrix3f matrix3f = entry.getNormal();
    this.method_23153(matrix4f, matrix3f, vertexConsumer, -7, -2, -2, 0.0F,
        0.15625F, -1, 0, 0, i);
    this.method_23153(matrix4f, matrix3f, vertexConsumer, -7, -2, 2, 0.15625F,
        0.15625F, -1, 0, 0, i);
    this.method_23153(matrix4f, matrix3f, vertexConsumer, -7, 2, 2, 0.15625F,
        0.3125F, -1, 0, 0, i);
    this.method_23153(matrix4f, matrix3f, vertexConsumer, -7, 2, -2, 0.0F,
        0.3125F, -1, 0, 0, i);
    this.method_23153(matrix4f, matrix3f, vertexConsumer, -7, 2, -2, 0.0F,
        0.15625F, 1, 0, 0, i);
    this.method_23153(matrix4f, matrix3f, vertexConsumer, -7, 2, 2, 0.15625F,
        0.15625F, 1, 0, 0, i);
    this.method_23153(matrix4f, matrix3f, vertexConsumer, -7, -2, 2, 0.15625F,
        0.3125F, 1, 0, 0, i);
    this.method_23153(matrix4f, matrix3f, vertexConsumer, -7, -2, -2, 0.0F,
        0.3125F, 1, 0, 0, i);

    for (int u = 0; u < 4; ++u) {
      matrixStack.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(90.0F));
      this.method_23153(matrix4f, matrix3f, vertexConsumer, -8, -2, 0, 0.0F,
          0.0F, 0, 1, 0, i);
      this.method_23153(matrix4f, matrix3f, vertexConsumer, 8, -2, 0, 0.5F,
          0.0F, 0, 1, 0, i);
      this.method_23153(matrix4f, matrix3f, vertexConsumer, 8, 2, 0, 0.5F,
          0.15625F, 0, 1, 0, i);
      this.method_23153(matrix4f, matrix3f, vertexConsumer, -8, 2, 0, 0.0F,
          0.15625F, 0, 1, 0, i);
    }
    // int light,
    // int overlay,
    // int seed
    BakedModel bakedModel = MinecraftClient.getInstance()
        .getItemRenderer()
        .getHeldItemModel(persistentProjectileEntity.getStack(),
            persistentProjectileEntity.world, null,
            persistentProjectileEntity.getId());
    MinecraftClient.getInstance()
        .getItemRenderer()
        .renderItem(persistentProjectileEntity.getStack(),
            ModelTransformation.Mode.FIXED, false, matrixStack,
            vertexConsumerProvider, i, i, bakedModel);
    // ItemStack,Mode,int,int,MatrixStack,VertexConsumerProvider,int
    matrixStack.pop();
    // super.render(persistentProjectileEntity, f, g, matrixStack,
    // vertexConsumerProvider, i);
  }

  public void method_23153(Matrix4f matrix4f, Matrix3f matrix3f,
      VertexConsumer vertexConsumer, int i, int j, int k, float f, float g,
      int l, int m, int n, int o) {
    vertexConsumer.vertex(matrix4f, (float) i, (float) j, (float) k)
        .color(255, 255, 255, 255)
        .texture(f, g)
        .overlay(OverlayTexture.DEFAULT_UV)
        .light(o)
        .normal(matrix3f, (float) l, (float) n, (float) m)
        .next();
  }

  // public MudballEntityRenderer(EntityRendererFactory.Context ctx) {
  // super(ctx);
  // }

  @Override
  public Identifier getTexture(MudballEntity entity) {
    return null;
  }
  //
  //
  //
  // @Override
  // public void render(MudballEntity entity, float yaw, float tickDelta,
  // MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light,) {
  // matrices.push();
  // // Calculate the current offset in the y value
  // double offset = Math.sin((entity.world.getTime() + tickDelta) / 8.0) / 4.0;
  // // Move the item
  // matrices.translate(0.5, 1.25 + offset, 0.5);
  // System.out.println("test");
  // System.out.println("test2");
  // System.out.println("test2");
  // MinecraftClient.getInstance()
  // .getItemRenderer()
  // .renderItem(entity.getStack(), ModelTransformation.Mode.GROUND, light, matrices,
  // vertexConsumers);
  // matrices.pop();
  // // Rotate the item
  // // matrices.multiply(Vector3f.POSITIVE_Y
  // // .getDegreesQuaternion((entity.world.getTime() + tickDelta) * 4));
  //
  // //
  // //
  // // if (this.hasLabel(entity)) {
  // // this.renderLabelIfPresent(entity, entity.getDisplayName(), matrices, vertexConsumers, light);
  // // }
  // }
}
