package v0id.aw.ashenarmor.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import v0id.aw.lib.AWConsts;

public class Crown extends ModelBiped {

    protected static final ResourceLocation crownTexture = new ResourceLocation(AWConsts.MODID + ":textures/armor/aether_crown.png");
    public ModelRenderer Crown;

    public Crown() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.Crown = new ModelRenderer(this, 73, 15);

        this.Crown.setRotationPoint(0.0F, 0.0F, 0.0F);

        this.Crown.addBox(-1.0f, -5.0f, -1.0F, 32, 7, 12, 0.5f);
        this.bipedHead.addChild(Crown);
        //this.Crown.addBox(0.0F, 0.0F, 0.0F, 32, 7, 0, 0.5f);
    }

    @Override
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
        Minecraft.getMinecraft().renderEngine.bindTexture(crownTexture);
        //ModelBiped mb = new net.minecraft.client.model.ModelBiped();
        //AWItems.CROWN.getArmorModel(entityIn, new v0id.aw.common.item.AWCrown().getItemStackDisplayName(), EntityEquipmentSlot.HEAD, mb);
        setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        this.Crown.render(1);
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.Crown.rotateAngleX = 1F;
        this.Crown.rotateAngleY = 4.7F;
        this.Crown.rotateAngleZ = 1F;
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

}
