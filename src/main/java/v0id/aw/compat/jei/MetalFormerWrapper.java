package v0id.aw.compat.jei;

import com.google.common.collect.Lists;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IIngredientType;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.fluids.FluidStack;
import teamroots.embers.compat.jei.EmbersJEIPlugin;
import v0id.aw.common.recipe.MetalFormerRecipes;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MetalFormerWrapper implements IRecipeWrapper {
    public final MetalFormerRecipes.MetalFormerRecipe recipe;

    public MetalFormerWrapper(MetalFormerRecipes.MetalFormerRecipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public void getIngredients(IIngredients ingredients) {
        ingredients.setInputLists(ItemStack.class, EmbersJEIPlugin.expandIngredients(recipe.getInput()));
        ingredients.setInput(FluidStack.class, recipe.getFluidRequirements());
        ingredients.setOutput(ItemStack.class, recipe.getRecipeOutput());
    }

    @Override
    public void drawInfo(Minecraft minecraft, int i, int i1, int i2, int i3) {
        minecraft.fontRenderer.drawStringWithShadow(I18n.format("aw.recipe.temp.req", this.recipe.getTemperature()), 24, 44, 0xffffffff);
    }

    @Override
    public List<String> getTooltipStrings(int i, int i1) {
        return Collections.emptyList();
    }

    @Override
    public boolean handleClick(Minecraft minecraft, int i, int i1, int i2) {
        return false;
    }
}
