package v0id.aw.ashenarmor.items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import teamroots.embers.item.IModeledItem;
import v0id.aw.common.creativetabs.AWTabs;
import v0id.aw.lib.AWConsts;

public class AetheriumBase extends Item implements IModeledItem {
    public AetheriumBase(String name, boolean addToTab) {
        super();
        setTranslationKey(name);
        setRegistryName(new ResourceLocation(AWConsts.MODID, name));
        if (addToTab) {
            setCreativeTab(AWTabs.TAB_AW);
        }
    }

    @Override
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName().toString()));
    }
}
