package v0id.aw.compat.groovyscript;

import com.cleanroommc.groovyscript.api.GroovyBlacklist;
import com.cleanroommc.groovyscript.api.GroovyLog;
import com.cleanroommc.groovyscript.api.IIngredient;
import com.cleanroommc.groovyscript.api.documentation.annotations.*;
import com.cleanroommc.groovyscript.helper.SimpleObjectStream;
import com.cleanroommc.groovyscript.helper.recipe.AbstractRecipeBuilder;
import com.cleanroommc.groovyscript.registry.VirtualizedRegistry;
import groovyjarjarantlr4.v4.runtime.misc.Nullable;
import v0id.aw.common.config.ConfigMachine;
import v0id.aw.common.recipe.MetalFormerRecipes;
import v0id.aw.lib.AWConsts;

import java.util.Arrays;

@RegistryDescription(linkGenerator = AWConsts.MODID)
public class MetalFormer extends VirtualizedRegistry<MetalFormerRecipes.MetalFormerRecipe> {
    @RecipeBuilderDescription(example = @Example(".fluidInput(fluid('water') * 100).input(item('minecraft:iron_ingot')).output(item('minecraft:iron_nugget') * 9).temperature(2000)"))
    public RecipeBuilder recipeBuilder() {
        return new RecipeBuilder();
    }

    @Override
    @GroovyBlacklist
    public void onReload() {
        MetalFormerRecipes.recipes.removeAll(removeScripted());
        MetalFormerRecipes.recipes.addAll(restoreFromBackup());
    }

    public void add(MetalFormerRecipes.MetalFormerRecipe recipe) {
        if (recipe != null) {
            addScripted(recipe);
            MetalFormerRecipes.recipes.add(recipe);
        }
    }

    public boolean remove(MetalFormerRecipes.MetalFormerRecipe recipe) {
        if (MetalFormerRecipes.recipes.removeIf(r -> r == recipe)) {
            addBackup(recipe);
            return true;
        }
        return false;
    }

    @MethodDescription(type = MethodDescription.Type.REMOVAL, example = @Example("item('minecraft:diamond')"))
    public boolean removeByInput(IIngredient input) {
        return MetalFormerRecipes.recipes.removeIf(r -> {
            if (Arrays.stream(r.getInput().getMatchingStacks()).anyMatch(input)) {
                addBackup(r);
                return true;
            }
            return false;
        });
    }

    @MethodDescription(type = MethodDescription.Type.REMOVAL, example = @Example("item('aetherworks:item_resource', 4)"))
    public boolean removeByOutput(IIngredient output) {
        return MetalFormerRecipes.recipes.removeIf(r -> {
            if (output.test(r.getResult())) {
                addBackup(r);
                return true;
            }
            return false;
        });
    }

    @MethodDescription(type = MethodDescription.Type.QUERY)
    public SimpleObjectStream<MetalFormerRecipes.MetalFormerRecipe> streamRecipes() {
        return new SimpleObjectStream<>(MetalFormerRecipes.recipes).setRemover(this::remove);
    }

    @MethodDescription(type = MethodDescription.Type.REMOVAL, priority = 2000, example = @Example(commented = true))
    public void removeAll() {
        MetalFormerRecipes.recipes.forEach(this::addBackup);
        MetalFormerRecipes.recipes.clear();
    }

    @Property(property = "input", valid = @Comp("1"))
    @Property(property = "fluidInput", valid = @Comp("1"))
    @Property(property = "output", valid = @Comp("1"))
    public static class RecipeBuilder extends AbstractRecipeBuilder<MetalFormerRecipes.MetalFormerRecipe> {
        @Property(defaultValue = "1", valid = @Comp(value = "1", type = Comp.Type.GTE), value = "groovyscript.wiki.aetherworks.temperature.value")
        private int temperature = 1;

        @RecipeBuilderMethodDescription(field = "temperature")
        public RecipeBuilder temperature(int temp) {
            this.temperature = temp;
            return this;
        }

        @Override
        public String getErrorMsg() {
            return "Error adding Aetherworks Metal Former recipe";
        }

        @Override
        public void validate(GroovyLog.Msg msg) {
            validateItems(msg,1,1,1,1);
            validateFluids(msg, 1, 1, 0, 0);
            msg.add(temperature < 1, "Temperature must be greater than 0");
            msg.add(temperature > ConfigMachine.FORGE.heat_capacity, "Temperature must be less than " + ConfigMachine.FORGE.heat_capacity);
            msg.add(Arrays.stream(input.get(0).getMatchingStacks()).anyMatch(itemStack -> itemStack.getCount() > 1), "Input must be a single item");
        }

        @Override
        @RecipeBuilderRegistrationMethod
        public @Nullable MetalFormerRecipes.MetalFormerRecipe register() {
            if (!validate()) return null;
            MetalFormerRecipes.MetalFormerRecipe recipe = new MetalFormerRecipes.MetalFormerRecipe(fluidInput.get(0), input.get(0).toMcIngredient(), output.get(0), temperature);
            GSPlugin.instance.metalFormer.add(recipe);
            return recipe;
        }
    }
}
