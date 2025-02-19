package v0id.aw.common.recipe;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.WeightedRandom;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;
import v0id.aw.common.item.Geode;
import v0id.aw.lib.RecipeUtils;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 * Created by V0idWa1k3r on 03-Jun-17.
 */
public class AetheriumAnvilRecipes
{
    public static final List<AetheriumAnvilRecipe> recipes = Lists.newArrayList();

    public static AetheriumAnvilRecipe addRecipe(Ingredient input, ItemStack output, int difficulty, int embersPerHit, int hitsRequired, int temperatureRequiredMin, int temperatureRequiredMax, float temperatureFluctuation)
    {
        return addRecipe(new AetheriumAnvilRecipe(input, output, difficulty, embersPerHit, hitsRequired, temperatureRequiredMin, temperatureRequiredMax, temperatureFluctuation));
    }

    public static AetheriumAnvilRecipe addRecipe(AetheriumAnvilRecipe rec)
    {
        recipes.add(rec);
        return rec;
    }

    public static Optional<AetheriumAnvilRecipe> findMatchingRecipe(ItemStack is, int temp)
    {
        return recipes.stream().filter(r -> r.matches(is, temp)).findFirst();
    }

    public static class GeodeRecipe extends AetheriumAnvilRecipe
    {
        public static final ListMultimap<Geode.Type, Entry> oreDictEntries = ArrayListMultimap.create();

        public static class Entry extends WeightedRandom.Item
        {
            public final String entry;
            private Entry(String s ,int itemWeightIn)
            {
                super(itemWeightIn);
                this.entry = s;
            }
        }

        public GeodeRecipe(Ingredient input, ItemStack output, int difficulty, int embersPerHit, int hitsRequired, int temperatureRequiredMin, int temperatureRequiredMax, float temperatureFluctuation)
        {
            super(input, output, difficulty, embersPerHit, hitsRequired, temperatureRequiredMin, temperatureRequiredMax, temperatureFluctuation);
        }

        public static void addEntry(Geode.Type type, String oreDict, int itemweight)
        {
            if (OreDictionary.doesOreNameExist(oreDict))
            {
                oreDictEntries.put(type, new Entry(oreDict, itemweight));
            }
        }

        public static final Random RANDOM = new Random();

        @Override
        public ItemStack getOutput(@Nullable World w)
        {
            Geode.Type geodeType = Geode.getType(this.getInput().getMatchingStacks()[0]);
            if (oreDictEntries.containsKey(geodeType))
            {
                List<Entry> entries = oreDictEntries.get(geodeType);
                RANDOM.setSeed(w != null ? w.getWorldTime() : 0);
                Entry e = WeightedRandom.getRandomItem(entries, RANDOM.nextInt(WeightedRandom.getTotalWeight(entries)));
                String oreDictName = e.entry;
                NonNullList<ItemStack> items = OreDictionary.getOres(oreDictName);
                ItemStack outputItem = items.isEmpty() ? super.getOutput(w) : items.get(0);
                if (outputItem.getItemDamage() == OreDictionary.WILDCARD_VALUE)
                {
                    outputItem.setItemDamage(0);
                }
                return outputItem;
            }

            return super.getOutput(w);
        }
    }

    public static class AetheriumAnvilRecipe
    {
        private final Ingredient input;
        private final ItemStack output;
        private final int difficulty;
        private final int embersPerHit;
        private final int hitsRequired;
        private final int temperatureRequiredMin;
        private final int temperatureRequiredMax;
        private final float temperatureFluctuation;

        public AetheriumAnvilRecipe(Ingredient input, ItemStack output, int difficulty, int embersPerHit, int hitsRequired, int temperatureRequiredMin, int temperatureRequiredMax, float temperatureFluctuation)
        {
            this.input = input;
            this.output = output;
            this.difficulty = difficulty;
            this.embersPerHit = embersPerHit;
            this.hitsRequired = hitsRequired;
            this.temperatureRequiredMin = temperatureRequiredMin;
            this.temperatureRequiredMax = temperatureRequiredMax;
            this.temperatureFluctuation = temperatureFluctuation;
        }

        public boolean matches(ItemStack in, int temperature)
        {
            return this.getInput().apply(in) && temperature >= this.getTemperatureRequiredMin() && temperature <= this.getTemperatureRequiredMax();
        }

        public Ingredient getInput()
        {
            return input;
        }

        public ItemStack getOutput(World w)
        {
            return output;
        }

        public ItemStack getResult()
        {
            return output;
        }

        public int getDifficulty()
        {
            return difficulty;
        }

        public int getEmbersPerHit()
        {
            return embersPerHit;
        }

        public int getHitsRequired()
        {
            return hitsRequired;
        }

        public int getTemperatureRequiredMin()
        {
            return temperatureRequiredMin;
        }

        public int getTemperatureRequiredMax()
        {
            return temperatureRequiredMax;
        }

        public float getTemperatureFluctuation()
        {
            return temperatureFluctuation;
        }
    }
}
