package v0id.aw.ashenarmor;

import baubles.api.BaublesApi;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import v0id.aw.ashenarmor.items.Crown;
import v0id.aw.common.config.ConfigTool;
import v0id.aw.common.item.AWItems;
import v0id.aw.lib.AWConsts;

public class CrownRenderer implements LayerRenderer<EntityPlayer> {

    //protected final RenderPlayer renderer;
    protected static final ResourceLocation awCrownResource = new ResourceLocation(AWConsts.MODID, "textures/items/aether_crown.png");
    protected static ModelBase model;
    private RenderPlayer renderer;

    public CrownRenderer(RenderPlayer renderPlayer) {
        this.renderer = renderPlayer;
    }

    @Override
    public void doRenderLayer(EntityPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {

        if (player == null) {
            return;
        }
        if (!baubles.common.Config.renderBaubles || player.getActivePotionEffect(MobEffects.INVISIBILITY) != null) {
            return;
        }

        if (ConfigTool.AETHERIUM_ASHEN_ARMOR.aetheriumCrownAsBauble) {
            ItemStack headBauble = BaublesApi.getBaublesHandler(player).getStackInSlot(4);
            if (!headBauble.isEmpty()) {
                if (headBauble.getItem() == AWItems.CROWN) {
                    this.renderCrown(player, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch, scale);
                }
            }
        }
    }

    protected void renderCrown(EntityPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        GlStateManager.pushMatrix();
        ModelBase t = new Crown();
        GlStateManager.translate(0, 0, 0);
        t.render(player, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        GlStateManager.popMatrix();
    }

    @Override
    public boolean shouldCombineTextures() {
        // Auto-generated method stub
        return false;
    }

}