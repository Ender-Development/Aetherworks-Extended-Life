package v0id.aw.compat.jei;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import v0id.aw.lib.AWConsts;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AnvilCategory implements IRecipeCategory<AnvilWrapper> {
    private final IDrawable drawable;

    public AnvilCategory(IGuiHelper helper) {
        this.drawable = helper.createDrawable(AWConsts.anvilUI, 0, 0, 87, 81);
    }

    @Override
    public String getUid() {
        return AWConsts.catIDAnvil;
    }

    @Override
    public String getTitle() {
        return I18n.format(AWConsts.catIDAnvil);
    }

    @Override
    public String getModName() {
        return AWConsts.MODID;
    }

    @Override
    public IDrawable getBackground() {
        return this.drawable;
    }

    @Nullable
    @Override
    public IDrawable getIcon() {
        return null;
    }

    @Override
    public void drawExtras(Minecraft minecraft) {

    }

    @Override
    public void setRecipe(IRecipeLayout iRecipeLayout, AnvilWrapper anvilWrapper, IIngredients iIngredients) {
        iRecipeLayout.getItemStacks().init(0, true, 4, 22);
        iRecipeLayout.getItemStacks().init(1, false, 58, 22);
        iRecipeLayout.getItemStacks().set(0, iIngredients.getInputs(ItemStack.class).get(0));
        iRecipeLayout.getItemStacks().set(1, iIngredients.getOutputs(ItemStack.class).stream().map(l -> l.get(0)).collect(Collectors.toList()));
    }

    @Override
    public List<String> getTooltipStrings(int i, int i1) {
        return Collections.emptyList();
    }
}
