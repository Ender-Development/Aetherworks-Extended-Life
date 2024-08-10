package v0id.aw.compat.jei;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import teamroots.embers.compat.jei.EmbersJEIPlugin;
import teamroots.embers.register.ItemRegister;
import v0id.aw.common.item.Geode;
import v0id.aw.common.recipe.AetheriumAnvilRecipes;

import java.awt.*;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class AnvilWrapper implements IRecipeWrapper {
    public final AetheriumAnvilRecipes.AetheriumAnvilRecipe recipe;
    public static final Random RAND = new Random();

    public AnvilWrapper(AetheriumAnvilRecipes.AetheriumAnvilRecipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public void getIngredients(IIngredients iIngredients) {
        iIngredients.setInput(ItemStack.class, EmbersJEIPlugin.expandIngredients(this.recipe.getInput()));
        if (this.recipe instanceof AetheriumAnvilRecipes.GeodeRecipe) {
            List<AetheriumAnvilRecipes.GeodeRecipe.Entry> oreNames = AetheriumAnvilRecipes.GeodeRecipe.oreDictEntries.get(Geode.getType(this.recipe.getInput().getMatchingStacks()[0]));
            List<ItemStack> ret = oreNames.stream().filter(e -> OreDictionary.doesOreNameExist(e.entry) && !OreDictionary.getOres(e.entry).isEmpty()).map(e -> OreDictionary.getOres(e.entry).get(0)).collect(Collectors.toList());
            iIngredients.setOutputs(ItemStack.class, ret);
        } else {
            iIngredients.setOutput(ItemStack.class, this.recipe.getOutput(null));
        }
    }

    @Override
    public void drawInfo(Minecraft minecraft, int i, int i1, int i2, int i3) {
        FontRenderer fr = minecraft.fontRenderer;
        fr.drawString("x" + this.recipe.getHitsRequired(), 10, 12, 0xff000000);
        int offsetX = fr.drawStringWithShadow(I18n.format("options.difficulty") + ": ", 0, 46, 0xffffffff);
        int difficulty = this.recipe.getDifficulty();
        if (difficulty < 8) {
            fr.drawStringWithShadow(I18n.format("aw.recipe.difficulty." + difficulty), offsetX, 46, 0xffffffff);
        } else {
            if (difficulty == 8) {
                String str = I18n.format("aw.recipe.difficulty.8");
                for (char c : str.toCharArray()) {
                    RAND.setSeed(Character.getNumericValue(c) ^ 64354L);
                    offsetX = fr.drawStringWithShadow(Character.toString(c), offsetX, 46 + RAND.nextInt(6) - RAND.nextInt(6), 0xffff4444);
                }
            } else {
                if (difficulty == 9) {
                    String str = I18n.format("aw.recipe.difficulty.9");
                    int index = 0;
                    for (char c : str.toCharArray()) {
                        GlStateManager.pushMatrix();
                        GlStateManager.translate(Math.sin((Math.toRadians((minecraft.world.getWorldTime() + index + minecraft.getRenderPartialTicks()) * 10) % 360)), Math.cos(Math.toRadians(((minecraft.world.getWorldTime() + index + minecraft.getRenderPartialTicks()) * 10) % 360)), 0);
                        offsetX = fr.drawStringWithShadow(Character.toString(c), offsetX, 46, 0xff483315);
                        GlStateManager.popMatrix();
                        ++index;
                    }
                } else {
                    String str = I18n.format("aw.recipe.difficulty.10");
                    int index = 0;
                    for (char c : str.toCharArray()) {
                        Color color = Color.getHSBColor((float) (((minecraft.world.getWorldTime() + index * 2) * 10) % 360) / 360, 1, 1);
                        offsetX = fr.drawStringWithShadow(Character.toString(c), offsetX, 46, color.getRGB());
                        ++index;
                    }
                }
            }
        }

        minecraft.getRenderItem().renderItemAndEffectIntoGUI(this.getEmbersStack(), -4, 54);
        fr.drawStringWithShadow(I18n.format("aw.recipe.anvil.ember", recipe.getEmbersPerHit()), 8, 58, 0xffffffff);
        fr.drawStringWithShadow(I18n.format("aw.recipe.anvil.temp", recipe.getTemperatureRequiredMin(), recipe.getTemperatureRequiredMax()), 0, 68, 0xffffffff);
    }

    private ItemStack is;

    private ItemStack getEmbersStack() {
        if (this.is == null) {
            this.is = new ItemStack(ItemRegister.SHARD_EMBER, 1, 0);
        }

        return this.is;
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
