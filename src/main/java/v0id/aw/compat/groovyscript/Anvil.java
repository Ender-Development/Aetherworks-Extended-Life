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
import v0id.aw.common.recipe.AetheriumAnvilRecipes;
import v0id.aw.lib.AWConsts;

import java.util.Arrays;

@RegistryDescription(linkGenerator = AWConsts.MODID)
public class Anvil extends VirtualizedRegistry<AetheriumAnvilRecipes.AetheriumAnvilRecipe> {
    @RecipeBuilderDescription(example = @Example(".input(item('minecraft:iron_ingot')).output(item('minecraft:iron_nugget') * 9).difficulty(2).embersPerHit(100).hits(10).temperature(1900, 2500).temperatureFluctuation(10)"))
    public RecipeBuilder recipeBuilder() {
        return new RecipeBuilder();
    }

    @Override
    @GroovyBlacklist
    public void onReload() {
        AetheriumAnvilRecipes.recipes.removeAll(removeScripted());
        AetheriumAnvilRecipes.recipes.addAll(restoreFromBackup());
    }

    public void add(AetheriumAnvilRecipes.AetheriumAnvilRecipe recipe) {
        if (recipe != null) {
            addScripted(recipe);
            AetheriumAnvilRecipes.recipes.add(recipe);
        }
    }

    public boolean remove(AetheriumAnvilRecipes.AetheriumAnvilRecipe recipe) {
        if (AetheriumAnvilRecipes.recipes.removeIf(r -> r == recipe)) {
            addBackup(recipe);
            return true;
        }
        return false;
    }

    @MethodDescription(type = MethodDescription.Type.REMOVAL, example = @Example("item('minecraft:diamond')"))
    public boolean removeByInput(IIngredient input) {
        return AetheriumAnvilRecipes.recipes.removeIf(r -> {
            if (Arrays.stream(r.getInput().getMatchingStacks()).anyMatch(input)) {
                addBackup(r);
                return true;
            }
            return false;
        });
    }

    @MethodDescription(type = MethodDescription.Type.REMOVAL, example = @Example("item('aetherworks:item_resource', 4)"))
    public boolean removeByOutput(IIngredient output) {
        return AetheriumAnvilRecipes.recipes.removeIf(r -> {
            if (output.test(r.getResult())) {
                addBackup(r);
                return true;
            }
            return false;
        });
    }

    @MethodDescription(type = MethodDescription.Type.QUERY)
    public SimpleObjectStream<AetheriumAnvilRecipes.AetheriumAnvilRecipe> streamRecipes() {
        return new SimpleObjectStream<>(AetheriumAnvilRecipes.recipes).setRemover(this::remove);
    }

    @MethodDescription(type = MethodDescription.Type.REMOVAL, priority = 2000, example = @Example(commented = true))
    public void removeAll() {
        AetheriumAnvilRecipes.recipes.forEach(this::addBackup);
        AetheriumAnvilRecipes.recipes.clear();
    }

    @Property(property = "input", valid = @Comp("1"))
    @Property(property = "output", valid = @Comp("1"))
    public static class RecipeBuilder extends AbstractRecipeBuilder<AetheriumAnvilRecipes.AetheriumAnvilRecipe> {
        @Property(defaultValue = "1", valid = {@Comp(value = "1", type = Comp.Type.GTE), @Comp(value = "10", type = Comp.Type.LTE)}, value = "groovyscript.wiki.aetherworks.difficulty.value")
        private int difficulty = 1;

        @Property(defaultValue = "1", valid = @Comp(value = "1", type = Comp.Type.GTE), value = "groovyscript.wiki.aetherworks.ember_per_hit.value")
        private int ember_per_hit = 1;

        @Property(defaultValue = "1", valid = @Comp(value = "1", type = Comp.Type.GTE), value = "groovyscript.wiki.aetherworks.hits_required.value")
        private int hits_required = 1;

        @Property(defaultValue = "1", valid = @Comp(value = "1", type = Comp.Type.GTE), value = "groovyscript.wiki.aetherworks.temperature_min.value")
        private int temperature_min = 1;

        @Property(defaultValue = "1", valid = @Comp(value = "1", type = Comp.Type.GTE), value = "groovyscript.wiki.aetherworks.temperature_max.value")
        private int temperature_max = 1;

        @Property(defaultValue = "1", valid = @Comp(value = "1", type = Comp.Type.GTE), value = "groovyscript.wiki.aetherworks.temperature_fluctuation.value")
        private int temperature_fluctuation = 1;

        @RecipeBuilderMethodDescription(field = "difficulty")
        public RecipeBuilder difficulty(int difficulty) {
            this.difficulty = difficulty;
            return this;
        }
        @RecipeBuilderMethodDescription(field = "embers_per_hit")
        public RecipeBuilder embersPerHit(int embers) {
            this.ember_per_hit = embers;
            return this;
        }
        @RecipeBuilderMethodDescription(field = "hits_required")
        public RecipeBuilder hits(int hits) {
            this.hits_required = hits;
            return this;
        }
        @RecipeBuilderMethodDescription(field = "temperature_min")
        public RecipeBuilder minTemperature(int temp_min) {
            this.temperature_min = temp_min;
            return this;
        }
        @RecipeBuilderMethodDescription(field = "temperature_max")
        public RecipeBuilder maxTemperature(int temp_max) {
            this.temperature_max = temp_max;
            return this;
        }
        @RecipeBuilderMethodDescription(field = {"temperature_min","temperature_max"})
        public RecipeBuilder temperature(int temp_min, int temp_max) {
            this.temperature_min = temp_min;
            this.temperature_max = temp_max;
            return this;
        }
        @RecipeBuilderMethodDescription(field = "temperature_fluctuation")
        public RecipeBuilder temperatureFluctuation(int temp_fluc) {
            this.temperature_fluctuation = temp_fluc;
            return this;
        }

        @Override
        public String getErrorMsg() {
            return "Error adding Aetherworks Aetherium Anvil recipe";
        }

        @Override
        public void validate(GroovyLog.Msg msg) {
            validateItems(msg,1,1,1,1);
            validateFluids(msg, 0, 0, 0, 0);
            msg.add(temperature_min < 1, "Minimum temperature must be greater than 0");
            msg.add(temperature_max > ConfigMachine.FORGE.heat_capacity, "Maximum Temperature must be less than " + ConfigMachine.FORGE.heat_capacity);
            msg.add(temperature_max <= temperature_min, "Minimum temperature must be less than or equal to maximum temperature");
            msg.add(difficulty < 1 || difficulty > 10, "Difficulty must be between 1 and 10");
        }

        @Override
        @RecipeBuilderRegistrationMethod
        public @Nullable AetheriumAnvilRecipes.AetheriumAnvilRecipe register() {
            if (!validate()) return null;
            AetheriumAnvilRecipes.AetheriumAnvilRecipe recipe = new AetheriumAnvilRecipes.AetheriumAnvilRecipe(input.get(0).toMcIngredient(), output.get(0), difficulty, ember_per_hit, hits_required, temperature_min, temperature_max, (float) temperature_fluctuation);
            GSPlugin.instance.anvil.add(recipe);
            return recipe;
        }
    }
}
