package v0id.aw.common.recipe;

import com.google.common.collect.Lists;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.fluids.FluidStack;
import v0id.aw.lib.RecipeUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by V0idWa1k3r on 03-Jun-17.
 */
public class MetalFormerRecipes
{
    public static final List<MetalFormerRecipe> recipes = Lists.newArrayList();

    public static MetalFormerRecipe addRecipe(FluidStack fsIn, Ingredient in, ItemStack out, int temp)
    {
        return addRecipe(new MetalFormerRecipe(fsIn, in, out, temp));
    }

    public static MetalFormerRecipe addRecipe(MetalFormerRecipe rec)
    {
        recipes.add(rec);
        return rec;
    }

    public static Optional<MetalFormerRecipe> findMatchingRecipe(ItemStack in, FluidStack fs, int i)
    {
        return recipes.stream().filter(r -> r.matches(fs, in, i)).findFirst();
    }

    public static class MetalFormerRecipe
    {
        private final FluidStack fluidRequirements;
        private final Ingredient in;
        private final ItemStack out;
        private final int temperature;

        public MetalFormerRecipe(FluidStack fluidRequirements, Ingredient in, ItemStack out, int temperature)
        {
            this.fluidRequirements = fluidRequirements;
            this.in = in;
            this.out = out;
            this.temperature = temperature;
        }

        public boolean matches(FluidStack stack, ItemStack is, int temp)
        {
            return temp >= this.temperature && fluidRequirements.isFluidEqual(stack) && fluidRequirements.amount <= stack.amount && in.apply(is);
        }

        public ItemStack getResult()
        {
            return this.out;
        }

        public Ingredient getInput()
        {
            return this.in;
        }

        public FluidStack getFluidRequirements()
        {
            return this.fluidRequirements;
        }

        public int getTemperature()
        {
            return this.temperature;
        }

        public ItemStack getRecipeOutput()
        {
            return out;
        }
    }
}
