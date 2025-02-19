package v0id.aw.ashenarmor.items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import teamroots.embers.item.IModeledItem;
import v0id.aw.common.creativetabs.AWTabs;
import v0id.aw.lib.AWConsts;

public class ArmorBase extends ItemArmor implements IModeledItem {

    public ArmorBase(ArmorMaterial material, int reduction, EntityEquipmentSlot slot, String name, boolean addToTab) {
        super(material, reduction, slot);
        switch (slot) {

            case CHEST: {
                setTranslationKey(name + "_chest");
                break;
            }
            case FEET: {
                setTranslationKey(name + "_boots");
                break;
            }
            case HEAD: {
                setTranslationKey(name + "_head");
                break;
            }
            case LEGS: {
                setTranslationKey(name + "_legs");
                break;
            }
            default:
                break;
        }
        this.setMaxStackSize(1);

        this.setRegistryName(new ResourceLocation(AWConsts.MODID, getTranslationKey().substring(5)));
        if (addToTab) {
            setCreativeTab(AWTabs.TAB_AW);
        }
    }

    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}
