package coda.oddorganisms.client.models.render;

import coda.oddorganisms.OddOrganisms;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class EolactoriaRenderModel<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(OddOrganisms.MOD_ID, "eolactoria"), "main");
	private final ModelPart body;

	public EolactoriaRenderModel(ModelPart root) {
		this.body = root.getChild("body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -5.0F, -3.0F, 4.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(6, 24).addBox(-1.0F, -2.0F, -4.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition leftPectoralFin = body.addOrReplaceChild("leftPectoralFin", CubeListBuilder.create().texOffs(0, 24).addBox(0.0F, -1.5F, 0.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -1.5F, -1.0F, 0.0F, 0.3927F, 0.0F));

		PartDefinition rightPectoralFin = body.addOrReplaceChild("rightPectoralFin", CubeListBuilder.create().texOffs(16, 18).addBox(0.0F, -1.5F, 0.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -1.5F, -1.0F, 0.0F, -0.3927F, 0.0F));

		PartDefinition rightBackHorn = body.addOrReplaceChild("rightBackHorn", CubeListBuilder.create().texOffs(0, 18).addBox(0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 0.0F, 3.0F));

		PartDefinition leftBackHorn = body.addOrReplaceChild("leftBackHorn", CubeListBuilder.create().texOffs(12, 11).addBox(0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.0F, 3.0F));

		PartDefinition analFin = body.addOrReplaceChild("analFin", CubeListBuilder.create().texOffs(10, 18).addBox(0.0F, -1.0F, 0.0F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 3.0F));

		PartDefinition dorsalFin = body.addOrReplaceChild("dorsalFin", CubeListBuilder.create().texOffs(12, 24).addBox(2.0F, -3.0F, 3.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -4.0F, -3.0F));

		PartDefinition rightFrontHorn = body.addOrReplaceChild("rightFrontHorn", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -1.0F, -6.0F, 0.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -4.0F, -3.0F));

		PartDefinition leftFrontHorn = body.addOrReplaceChild("leftFrontHorn", CubeListBuilder.create().texOffs(0, 11).addBox(0.0F, -1.0F, -6.0F, 0.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -4.0F, -3.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}