package v0id.aw.ashenarmor;

import baubles.api.BaubleType;
import baubles.api.BaublesApi;
import baubles.api.IBauble;
import baubles.api.cap.BaublesCapabilities;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.IItemHandler;
import v0id.aw.common.item.AWItems;

public class CrownToBauble {
    private static final IBauble awcrown = new IBauble() {
        @Override
        public BaubleType getBaubleType(ItemStack itemstack) {
            return BaubleType.HEAD;
        }

        @Override
        public void onWornTick(ItemStack itemStack, EntityLivingBase player) {
            itemStack.getItem().onUpdate(itemStack, player.world, player, -1, false);

            if (player.ticksExisted % 100 == 0 && itemStack.hasTagCompound() && itemStack.getTagCompound().hasKey("potionType", Constants.NBT.TAG_STRING))
            {
                PotionType type = PotionType.REGISTRY.getObject(new ResourceLocation(itemStack.getTagCompound().getString("potionType")));
                for (PotionEffect effect1 : type.getEffects())
                {
                    PotionEffect effect = new PotionEffect(effect1.getPotion(), 400, effect1.getAmplifier(), effect1.getIsAmbient(), false);
                    if (effect.getPotion() == MobEffects.INSTANT_HEALTH)
                    {
                        effect = new PotionEffect(MobEffects.REGENERATION, effect.getDuration(), effect.getAmplifier(), effect.getIsAmbient(), effect.doesShowParticles());
                    }

                    if (effect.getPotion() == MobEffects.INSTANT_DAMAGE)
                    {
                        effect = new PotionEffect(MobEffects.POISON, effect.getDuration(), effect.getAmplifier(), effect.getIsAmbient(), effect.doesShowParticles());
                    }

                    player.addPotionEffect(effect);
                }
            }
        }

        @Override
        public boolean willAutoSync(ItemStack stack, EntityLivingBase player) {
            return true;
        }
    };

    public static void init() {

    }

    @SideOnly(Side.CLIENT)
    public static IItemHandler getItemHandler() {
        return BaublesApi.getBaublesHandler(Minecraft.getMinecraft().player);
    }

    @SubscribeEvent
    public void attachBaubles(AttachCapabilitiesEvent<ItemStack> event) {
        if (event.getObject().getItem() == AWItems.CROWN) {
            event.addCapability(new ResourceLocation("baubles", "bauble"), new ICapabilityProvider() {
                @Override
                public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
                    return capability == BaublesCapabilities.CAPABILITY_ITEM_BAUBLE;
                }

                @Override
                public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
                    return capability == BaublesCapabilities.CAPABILITY_ITEM_BAUBLE ? BaublesCapabilities.CAPABILITY_ITEM_BAUBLE.cast(awcrown) : null;
                }
            });
        }
    }
}
