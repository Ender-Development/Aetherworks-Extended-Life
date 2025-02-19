package v0id.aw.ashenarmor.recipes;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import teamroots.embers.recipe.RecipeRegistry;
import teamroots.embers.register.ItemRegister;
import v0id.aw.ashenarmor.AetheriumRegister;
import v0id.aw.common.config.ConfigTool;
import v0id.aw.common.fluid.AWFluids;
import v0id.aw.lib.AWConsts;

@Mod.EventBusSubscriber(modid = AWConsts.MODID)
public class Register {
    @SubscribeEvent
	public static void init(RegistryEvent.Register<IRecipe> event){

		Ingredient stampBar = Ingredient.fromItem(ItemRegister.STAMP_BAR);
		Ingredient ashenGoggles = Ingredient.fromItem(ItemRegister.ASHEN_CLOAK_HEAD);
		Ingredient ashenChestPlate = Ingredient.fromItem(ItemRegister.ASHEN_CLOAK_CHEST);
		Ingredient ashenLeggings = Ingredient.fromItem(ItemRegister.ASHEN_CLOAK_LEGS);
		Ingredient ashenBoots = Ingredient.fromItem(ItemRegister.ASHEN_CLOAK_BOOTS);

		if (ConfigTool.AETHERIUM_ASHEN_ARMOR.aetheriumArmorRecipes) {
			FluidStack aetheriumGasFluidStack = new FluidStack(AWFluids.FLUID_AETHERIUM_GAS, ConfigTool.AETHERIUM_ASHEN_ARMOR.aetheriumGasCost);
			RecipeRegistry.stampingRecipes.add(new NBTItemStampingRecipe(ashenGoggles, aetheriumGasFluidStack, stampBar, new ItemStack(AetheriumRegister.AETHERIUM_ASHEN_HELMET,1)));
			RecipeRegistry.stampingRecipes.add(new NBTItemStampingRecipe(ashenChestPlate, aetheriumGasFluidStack, stampBar,new ItemStack(AetheriumRegister.AETHERIUM_ASHEN_CHESTPLATE,1)));
			RecipeRegistry.stampingRecipes.add(new NBTItemStampingRecipe(ashenLeggings, aetheriumGasFluidStack, stampBar,new ItemStack(AetheriumRegister.AETHERIUM_ASHEN_LEGGINGS,1)));
			RecipeRegistry.stampingRecipes.add(new NBTItemStampingRecipe(ashenBoots, aetheriumGasFluidStack, stampBar,new ItemStack(AetheriumRegister.AETHERIUM_ASHEN_BOOTS,1)));
		}
	}

}
