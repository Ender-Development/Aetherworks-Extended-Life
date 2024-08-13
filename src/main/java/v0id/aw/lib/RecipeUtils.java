package v0id.aw.lib;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;

import java.util.Arrays;

/**
 * Created by V0idWa1k3r on 03-Jun-17.
 */
public class RecipeUtils
{
    public static boolean areItemStacksEqual(ItemStack l, ItemStack r)
    {
        return ItemStack.areItemsEqual(l, r) && ItemStack.areItemStackTagsEqual(l, r) && l.getMetadata() == r.getMetadata();
    }

    public static boolean areItemStacksEqual(ItemStack item, Ingredient ingredient)
    {
        return Arrays.stream(ingredient.getMatchingStacks()).anyMatch(is -> areItemStacksEqual(is, item));
    }

    public static boolean areItemStacksEqual(Ingredient ingredient, ItemStack item)
    {
        return Arrays.stream(ingredient.getMatchingStacks()).anyMatch(is -> areItemStacksEqual(is, item));
    }

    public static boolean areItemStacksEqual(Ingredient l, Ingredient r)
    {
        return Arrays.stream(l.getMatchingStacks()).anyMatch(ls -> Arrays.stream(r.getMatchingStacks()).anyMatch(rs -> areItemStacksEqual(ls, rs)));
    }
}
