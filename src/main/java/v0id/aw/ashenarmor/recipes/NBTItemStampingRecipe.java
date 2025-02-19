package v0id.aw.ashenarmor.recipes;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fluids.FluidStack;
import teamroots.embers.recipe.ItemStampingRecipe;

public class NBTItemStampingRecipe extends ItemStampingRecipe {

    public NBTItemStampingRecipe(Ingredient input, FluidStack fluid, Ingredient stamp, ItemStack result) {
        super(input, fluid, stamp, result);
    }

    @Override
    public ItemStack getResult(TileEntity tile, ItemStack input, FluidStack fluid, ItemStack stamp) {

        NBTTagCompound newTag = null;
        ItemStack resultNBT = this.result.copy();


        if (input.hasTagCompound()) {
            assert input.getTagCompound() != null;
            newTag = input.getTagCompound().copy();
            resultNBT.setTagCompound(newTag);
            return resultNBT;
        }
        return resultNBT;
    }
}