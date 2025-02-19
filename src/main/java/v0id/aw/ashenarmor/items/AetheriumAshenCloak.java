package v0id.aw.ashenarmor.items;


import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import teamroots.embers.api.event.EmberRemoveEvent;
import teamroots.embers.api.item.IInflictorGem;
import teamroots.embers.api.item.IInflictorGemHolder;
import teamroots.embers.api.item.IInfoGoggles;
import teamroots.embers.model.ModelAshenArmor;
import v0id.aw.AetherWorks;
import v0id.aw.lib.AWConsts;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class AetheriumAshenCloak extends ArmorBase implements IInflictorGemHolder, IInfoGoggles, ISpecialArmor {

    public AetheriumAshenCloak(ArmorMaterial material, int reduction, EntityEquipmentSlot slot) {
        super(material, reduction, slot, "aetherium_ashen_cloak", true);
    }


    @SideOnly(Side.CLIENT)
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
        return AWConsts.MODID + ":textures/models/armor/robe.png";
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ModelBiped getArmorModel(EntityLivingBase living, ItemStack stack, EntityEquipmentSlot slot, ModelBiped _default) {
        //return new ModelAshenCloak(slot);
        return new ModelAshenArmor(slot);
    }


    @Override
    public int getGemSlots(ItemStack holder) {
        return 7;
    }

    @Override
    public boolean canAttachGem(ItemStack holder, ItemStack gem) {
        return gem.getItem() instanceof IInflictorGem;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void attachGem(ItemStack holder, ItemStack gem, int slot) {
        if (!holder.hasTagCompound()) {
            holder.setTagCompound(new NBTTagCompound());
        }
        assert holder.getTagCompound() != null;
        holder.getTagCompound().setTag("gem" + slot, gem.writeToNBT(new NBTTagCompound()));
    }

    @Override
    public ItemStack detachGem(ItemStack holder, int slot) {
        if (holder.hasTagCompound()) {
            assert holder.getTagCompound() != null;
            if (holder.getTagCompound().hasKey("gem" + slot)) {
                ItemStack gem = new ItemStack(holder.getTagCompound().getCompoundTag("gem" + slot));
                holder.getTagCompound().removeTag("gem" + slot);
                return gem;
            }
        }
        return ItemStack.EMPTY;
    }

    @Override
    public void clearGems(ItemStack holder) {
        NBTTagCompound tagCompound = holder.getTagCompound();
        if (tagCompound == null) {
            return;
        }
        for (int i = 1; i <= getGemSlots(holder); i++) {
            if (tagCompound.hasKey("gem" + i)) {
                tagCompound.removeTag("gem" + i);
            }
        }
    }

    @Override
    public ItemStack[] getAttachedGems(ItemStack holder) { //Potentially default???
        ItemStack[] stacks = new ItemStack[getGemSlots(holder)];
        for (int i = 1; i <= stacks.length; i++) {
            if (holder.hasTagCompound()) {
                assert holder.getTagCompound() != null;
                stacks[i - 1] = new ItemStack(holder.getTagCompound().getCompoundTag("gem" + i));
            } else {
                stacks[i - 1] = ItemStack.EMPTY;
            }
        }
        return stacks;
    }


    @Override
    public void setDamage(ItemStack stack, int damage) {
        super.setDamage(stack, Math.min(damage, getMaxDamage(stack) - 1));
    }


    private boolean isBroken(ItemStack armor) {
        return armor.getItemDamage() >= armor.getMaxDamage() - 1;
    }

    private static boolean isProtectiveCloakPiece(ItemStack armor) {
        if (armor.getItem() instanceof AetheriumAshenCloak) {
            AetheriumAshenCloak cloak = (AetheriumAshenCloak) armor.getItem();
            return !cloak.isBroken(armor);
        }
        return false;

    }

    @Override
    public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage,
                                         int slot) {
        ArmorProperties prop = new ArmorProperties(0, 0, Integer.MAX_VALUE);
        if (!isBroken(armor)) {
            prop.Armor = damageReduceAmount;
            prop.Toughness = toughness;
        }
        return prop;
    }

    @Override
    public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) {

        return 0;
    }

    @Override
    public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot) {

    }

    @Override
    public boolean shouldDisplayInfo(EntityPlayer arg0, ItemStack arg1, EntityEquipmentSlot arg2) {
        return arg2 == EntityEquipmentSlot.HEAD;
    }

    @Override
    public float getTotalDamageResistance(EntityLivingBase arg0, DamageSource arg1, ItemStack arg2) {

        float reduction = 0;

        if (isProtectiveCloakPiece(arg0.getItemStackFromSlot(EntityEquipmentSlot.HEAD)) &&
                isProtectiveCloakPiece(arg0.getItemStackFromSlot(EntityEquipmentSlot.CHEST)) &&
                isProtectiveCloakPiece(arg0.getItemStackFromSlot(EntityEquipmentSlot.LEGS)) &&
                isProtectiveCloakPiece(arg0.getItemStackFromSlot(EntityEquipmentSlot.FEET))) {
            for (ItemStack stack : getAttachedGems(arg2)) {
                //System.out.println("for loop");
                Item item = stack.getItem();
                //System.out.println(item);
                if (item instanceof IInflictorGem && Objects.equals(((IInflictorGem) item).getAttunedSource(stack), arg1.getDamageType())) {
                    reduction += ((IInflictorGem) item).getDamageResistance(stack, reduction);
                    //System.out.println("if inner loop");
                }
            }
        }

        return reduction;
        //return 0;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(AetherWorks.proxy.translate("aw.enchantment.aetherid", "II"));
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    //@SideOnly(Side.CLIENT) //does this need to be here for this method? iunno //dont need it because hte particle check is remote
    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (stack.getItemDamage() > 0
                && worldIn.getWorldTime() % 24000 >= 15000
                && worldIn.getWorldTime() % 24000 <= 21000
                && worldIn.canBlockSeeSky(entityIn.getPosition().up())) {
            if (worldIn.rand.nextFloat() <= 0.04F) {
                BlockPos pos = entityIn.getPosition();
                Random rand = new Random();
                stack.setItemDamage(stack.getItemDamage() - 1);
                if (!worldIn.isRemote) {
                    v0id.aw.AetherWorks.proxy.spawnParticleSpark(worldIn, pos.getX() + rand.nextFloat(),
                            pos.getY() + rand.nextFloat(), pos.getZ() + rand.nextFloat(),
                            (rand.nextFloat() - rand.nextFloat()) / 20, rand.nextFloat() / 20,
                            (rand.nextFloat() - rand.nextFloat()) / 20, 0, 0.72F, 0.95F, 1 + rand.nextFloat(), 60);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onTake(EmberRemoveEvent event) {

        if (isProtectiveCloakPiece(event.getPlayer().getItemStackFromSlot(EntityEquipmentSlot.HEAD))
                && isProtectiveCloakPiece(event.getPlayer().getItemStackFromSlot(EntityEquipmentSlot.CHEST))
                && isProtectiveCloakPiece(event.getPlayer().getItemStackFromSlot(EntityEquipmentSlot.LEGS))
                && isProtectiveCloakPiece(event.getPlayer().getItemStackFromSlot(EntityEquipmentSlot.FEET))) {
            event.addReduction(0.15);
        }
    }
}
