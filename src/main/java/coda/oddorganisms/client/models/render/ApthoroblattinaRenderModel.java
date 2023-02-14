package coda.oddorganisms.client.models.render;// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports


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

public class ApthoroblattinaRenderModel<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(OddOrganisms.MOD_ID, "apthoroblattina"), "main");
	private final ModelPart root;

	public ApthoroblattinaRenderModel(ModelPart root) {
		this.root = root.getChild("root");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -3.0F, -5.0F, 9.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition rightWing = root.addOrReplaceChild("rightWing", CubeListBuilder.create(), PartPose.offset(1.0F, -3.0F, -4.0F));

		PartDefinition cube_r1 = rightWing.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(28, 0).mirror().addBox(-1.5F, 0.0F, -0.5F, 6.0F, 0.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0436F, 0.0F, 0.0F));

		PartDefinition leftWing = root.addOrReplaceChild("leftWing", CubeListBuilder.create(), PartPose.offset(-1.0F, -3.0F, -4.0F));

		PartDefinition cube_r2 = leftWing.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(28, 0).addBox(-4.5F, 0.0F, -0.5F, 6.0F, 0.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0436F, 0.0F, 0.0F));

		PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(18, 30).addBox(-2.5F, -2.0F, -2.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 0.0F, -6.0F));

		PartDefinition leftAntenna = head.addOrReplaceChild("leftAntenna", CubeListBuilder.create().texOffs(27, 15).mirror().addBox(0.0F, -1.0F, -2.0F, 10.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.5F, 0.0F, -3.0F));

		PartDefinition rightAntenna = head.addOrReplaceChild("rightAntenna", CubeListBuilder.create().texOffs(27, 15).addBox(-10.0F, -1.0F, -2.0F, 10.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 0.0F, -3.0F));

		PartDefinition leftLeg1 = root.addOrReplaceChild("leftLeg1", CubeListBuilder.create().texOffs(19, 14).addBox(0.0F, 0.0F, -5.5F, 2.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(4.5F, 0.0F, -3.5F));

		PartDefinition rightLeg1 = root.addOrReplaceChild("rightLeg1", CubeListBuilder.create().texOffs(19, 14).mirror().addBox(-0.5F, 0.0F, -9.0F, 2.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.0F, 0.0F, 0.0F));

		PartDefinition leftLeg2 = root.addOrReplaceChild("leftLeg2", CubeListBuilder.create(), PartPose.offset(6.0F, 0.0F, 0.0F));

		PartDefinition cube_r3 = leftLeg2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 23).mirror().addBox(-0.5F, 0.5F, -1.5F, 4.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, -0.5F, 0.5F, 0.0F, 0.5236F, 0.0F));

		PartDefinition rightLeg2 = root.addOrReplaceChild("rightLeg2", CubeListBuilder.create(), PartPose.offset(-6.0F, 0.0F, 0.0F));

		PartDefinition cube_r4 = rightLeg2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 23).addBox(-3.5F, 0.5F, -1.5F, 4.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -0.5F, 0.5F, 0.0F, -0.5236F, 0.0F));

		PartDefinition leftLeg3 = root.addOrReplaceChild("leftLeg3", CubeListBuilder.create().texOffs(0, 14).mirror().addBox(-1.5F, 0.0F, 2.0F, 4.0F, 0.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(6.0F, 0.0F, 0.0F));

		PartDefinition rightLeg3 = root.addOrReplaceChild("rightLeg3", CubeListBuilder.create().texOffs(0, 14).addBox(-2.5F, 0.0F, 2.0F, 4.0F, 0.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}