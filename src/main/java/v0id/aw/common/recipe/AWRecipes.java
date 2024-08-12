package v0id.aw.common.recipe;

import com.google.common.collect.Lists;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.OreIngredient;
import teamroots.embers.api.alchemy.AspectList;
import teamroots.embers.config.ConfigMaterial;
import teamroots.embers.register.FluidRegister;
import teamroots.embers.register.ItemRegister;
import teamroots.embers.recipe.*;
import v0id.aw.common.block.AWBlocks;
import v0id.aw.common.fluid.AWFluids;
import v0id.aw.common.item.AWItems;
import v0id.aw.common.item.Geode;
import v0id.aw.lib.ILifecycleListener;

import java.util.stream.Stream;

/**
 * Created by V0idWa1k3r on 31-May-17.
 */
@Mod.EventBusSubscriber
public class AWRecipes implements ILifecycleListener {

    @SubscribeEvent
    public static void onRegisterRecipes(RegistryEvent.Register<IRecipe> event) {
        /* MasterEnderman:
        This is hideous I know, but I don't want to redo all item registration as this would break backwards compatibility.
        Furthermore, I have no interest in looking up each Metadata, when working on recipes. Maybe at a later point in time.
         */
        ItemStack AETHER_SHARD = new ItemStack(AWItems.RESOURCE, 1, 0);
        ItemStack FOCUS_CRYSTAL = new ItemStack(AWItems.RESOURCE, 1, 1);
        // ItemStack AETHERIUM_LENS = new ItemStack(AWItems.RESOURCE, 1, 2);
        ItemStack PLATE_AETHER = new ItemStack(AWItems.RESOURCE, 1, 3);
        ItemStack INGOT_AETHER = new ItemStack(AWItems.RESOURCE, 1, 4);
        ItemStack GEM_AETHER = new ItemStack(AWItems.RESOURCE, 1, 5);
        ItemStack CRUDE_TOOL_ROD = new ItemStack(AWItems.RESOURCE, 1, 6);
        ItemStack TOOL_ROD = new ItemStack(AWItems.RESOURCE, 1, 7);
        ItemStack INFUSED_TOOL_ROD = new ItemStack(AWItems.RESOURCE, 1, 8);
        ItemStack CRUDE_PICKAXE_HEAD = new ItemStack(AWItems.RESOURCE, 1, 9);
        ItemStack PICKAXE_HEAD = new ItemStack(AWItems.RESOURCE, 1, 10);
        ItemStack PICKAXE_HEAD_AETHER = new ItemStack(AWItems.RESOURCE, 1, 11);
        ItemStack PICKAXE_HEAD_EMBER = new ItemStack(AWItems.RESOURCE, 1, 12);
        ItemStack CRUDE_AXE_HEAD = new ItemStack(AWItems.RESOURCE, 1, 13);
        ItemStack AXE_HEAD = new ItemStack(AWItems.RESOURCE, 1, 14);
        ItemStack AXE_HEAD_PRISMARINE = new ItemStack(AWItems.RESOURCE, 1, 15);
        ItemStack AXE_HEAD_ENDER = new ItemStack(AWItems.RESOURCE, 1, 16);
        ItemStack CRUDE_SHOVEL_HEAD = new ItemStack(AWItems.RESOURCE, 1, 17);
        ItemStack SHOVEL_HEAD = new ItemStack(AWItems.RESOURCE, 1, 18);
        ItemStack SHOVEL_HEAD_REDSTONE = new ItemStack(AWItems.RESOURCE, 1, 19);
        ItemStack SHOVEL_HEAD_SLIME = new ItemStack(AWItems.RESOURCE, 1, 20);
        ItemStack AETHER_CROWN_CRUDE = new ItemStack(AWItems.RESOURCE, 1, 21);
        ItemStack AETHER_CROWN_MUNDANE = new ItemStack(AWItems.RESOURCE, 1, 22);
        ItemStack CRUDE_CROSSBOW_FRAME = new ItemStack(AWItems.RESOURCE, 1, 23);
        ItemStack CRUDE_CROSSBOW_LIMBS = new ItemStack(AWItems.RESOURCE, 1, 24);
        ItemStack CROSSBOW_FRAME = new ItemStack(AWItems.RESOURCE, 1, 25);
        ItemStack CROSSBOW_LIMBS = new ItemStack(AWItems.RESOURCE, 1, 26);
        ItemStack INFUSED_CROSSBOW_FRAME = new ItemStack(AWItems.RESOURCE, 1, 27);
        ItemStack CROSSBOW_LIMBS_QUARTZ = new ItemStack(AWItems.RESOURCE, 1, 28);
        ItemStack CROSSBOW_LIMBS_MAGMA = new ItemStack(AWItems.RESOURCE, 1, 29);
        ItemStack CROWN = new ItemStack(AWItems.CROWN, 1, 0);

        RecipeRegistry.stampingRecipes.add(new ItemStampingRecipe(Ingredient.fromItem(ItemRegister.SHARD_EMBER), new FluidStack(FluidRegistry.WATER, 1000), Ingredient.fromItem(ItemRegister.STAMP_FLAT), FOCUS_CRYSTAL));
        RecipeRegistry.stampingRecipes.add(new ItemStampingRecipe(Ingredient.EMPTY, new FluidStack(AWFluids.FLUID_AETHERIUM_GAS, 16), Ingredient.fromItem(ItemRegister.STAMP_FLAT), AETHER_SHARD));

        RecipeRegistry.mixingRecipes.add(new FluidMixingRecipe(new FluidStack[]{new FluidStack(AWFluids.FLUID_IMPURE_AETHERIUM_GAS, 8), new FluidStack(FluidRegister.FLUID_MOLTEN_ELECTRUM, 8)}, new FluidStack(AWFluids.FLUID_AETHERIUM_GAS, 16)));

        RecipeRegistry.meltingRecipes.add(new ItemMeltingRecipe(new OreIngredient("shardAether"), new FluidStack(AWFluids.FLUID_AETHERIUM_GAS, 16)));

        RecipeRegistry.alchemyRecipes.add(new AlchemyRecipe(new AspectList.AspectRangeList()
                .setRange("iron", 12, 16)
                .setRange("dawnstone", 12, 16)
                .setRange("copper", 12, 16)
                .setRange("silver", 12, 16)
                .setRange("lead", 12, 16),
                Ingredient.fromStacks(TOOL_ROD),
                Lists.newArrayList(Ingredient.EMPTY, Ingredient.EMPTY, Ingredient.EMPTY, Ingredient.EMPTY),
                INFUSED_TOOL_ROD));

        RecipeRegistry.alchemyRecipes.add(new AlchemyRecipe(new AspectList.AspectRangeList()
                .setRange("iron", 32, 32)
                .setRange("dawnstone", 48, 64)
                .setRange("silver", 48, 64),
                Ingredient.fromStacks(PICKAXE_HEAD),
                Lists.newArrayList(Ingredient.fromStacks(AETHER_SHARD), Ingredient.fromStacks(AETHER_SHARD), Ingredient.fromStacks(AETHER_SHARD), Ingredient.fromStacks(AETHER_SHARD)),
                PICKAXE_HEAD_AETHER));
        RecipeRegistry.alchemyRecipes.add(new AlchemyRecipe(new AspectList.AspectRangeList()
                .setRange("iron", 32, 32)
                .setRange("copper", 48, 64)
                .setRange("lead", 48, 64),
                Ingredient.fromStacks(AXE_HEAD),
                Lists.newArrayList(Ingredient.fromItem(ItemRegister.CRYSTAL_EMBER), Ingredient.fromItem(ItemRegister.CRYSTAL_EMBER), Ingredient.fromItem(ItemRegister.CRYSTAL_EMBER), Ingredient.fromItem(ItemRegister.CRYSTAL_EMBER)),
                PICKAXE_HEAD_EMBER));

        RecipeRegistry.alchemyRecipes.add(new AlchemyRecipe(new AspectList.AspectRangeList()
                .setRange("silver", 32, 32)
                .setRange("dawnstone", 48, 64)
                .setRange("copper", 48, 64),
                Ingredient.fromStacks(AXE_HEAD),
                Lists.newArrayList(Ingredient.fromItem(Items.PRISMARINE_CRYSTALS), Ingredient.fromItem(Items.PRISMARINE_SHARD), Ingredient.fromItem(Items.PRISMARINE_CRYSTALS), Ingredient.fromItem(Items.PRISMARINE_SHARD)),
                AXE_HEAD_PRISMARINE));
        RecipeRegistry.alchemyRecipes.add(new AlchemyRecipe(new AspectList.AspectRangeList()
                .setRange("silver", 32, 32)
                .setRange("iron", 48, 64)
                .setRange("lead", 48, 64),
                Ingredient.fromStacks(AXE_HEAD),
                Lists.newArrayList(Ingredient.fromItem(Items.ENDER_PEARL), Ingredient.fromItem(Items.ENDER_EYE), Ingredient.fromItem(Items.ENDER_PEARL), Ingredient.fromItem(Items.ENDER_EYE)),
                AXE_HEAD_ENDER));

        RecipeRegistry.alchemyRecipes.add(new AlchemyRecipe(new AspectList.AspectRangeList()
                .setRange("lead", 30, 34)
                .setRange("iron", 48, 64)
                .setRange("copper", 48, 64),
                Ingredient.fromStacks(SHOVEL_HEAD),
                Lists.newArrayList(Ingredient.fromItem(Items.REDSTONE), Ingredient.fromItem(Item.getItemFromBlock(Blocks.PISTON)), Ingredient.fromItem(Item.getItemFromBlock(Blocks.REDSTONE_TORCH)), Ingredient.fromItem(Items.REPEATER)),
                SHOVEL_HEAD_REDSTONE));
        RecipeRegistry.alchemyRecipes.add(new AlchemyRecipe(new AspectList.AspectRangeList()
                .setRange("lead", 30, 34)
                .setRange("dawnstone", 48, 64)
                .setRange("silver", 32, 64),
                Ingredient.fromStacks(SHOVEL_HEAD),
                Lists.newArrayList(Ingredient.fromItem(Items.SLIME_BALL), Ingredient.fromItem(Item.getItemFromBlock(Blocks.STICKY_PISTON)), Ingredient.fromItem(Items.COMPARATOR), Ingredient.fromItem(Item.getItemFromBlock(Blocks.HOPPER))),
                SHOVEL_HEAD_SLIME));

        RecipeRegistry.alchemyRecipes.add(new AlchemyRecipe(new AspectList.AspectRangeList()
                .setRange("iron", 16, 16)
                .setRange("dawnstone", 16, 16)
                .setRange("copper", 16, 16)
                .setRange("silver", 16, 16)
                .setRange("lead", 16, 16),
                Ingredient.fromStacks(AETHER_CROWN_MUNDANE),
                Lists.newArrayList(Ingredient.fromStacks(GEM_AETHER), Ingredient.fromItem(Items.ENDER_EYE), Ingredient.fromItem(Item.getItemFromBlock(Blocks.OBSIDIAN)), Ingredient.fromItem(Item.getItemFromBlock(Blocks.OBSIDIAN))),
                CROWN));

        RecipeRegistry.alchemyRecipes.add(new AlchemyRecipe(new AspectList.AspectRangeList()
                .setRange("iron", 32, 48)
                .setRange("dawnstone", 32, 32)
                .setRange("lead", 32, 32),
                Ingredient.fromStacks(CROSSBOW_FRAME),
                Lists.newArrayList(new OreIngredient("plateLead"), Ingredient.fromItem(Item.getItemFromBlock(Blocks.LEVER)), new OreIngredient("plateLead"), Ingredient.fromItem(Item.getItemFromBlock(Blocks.IRON_BARS))),
                INFUSED_CROSSBOW_FRAME));

        RecipeRegistry.alchemyRecipes.add(new AlchemyRecipe(new AspectList.AspectRangeList()
                .setRange("lead", 32, 32)
                .setRange("dawnstone", 32, 48)
                .setRange("silver", 32, 32),
                Ingredient.fromStacks(CROSSBOW_LIMBS),
                Lists.newArrayList(new OreIngredient("blockQuartz"), new OreIngredient("blockGlass"), new OreIngredient("blockQuartz"), Ingredient.fromItem(ItemRegister.ELDRITCH_INSIGNIA)),
                CROSSBOW_LIMBS_QUARTZ));
        RecipeRegistry.alchemyRecipes.add(new AlchemyRecipe(new AspectList.AspectRangeList()
                .setRange("dawnstone", 32, 32)
                .setRange("copper", 32, 48)
                .setRange("lead", 32, 32),
                Ingredient.fromStacks(CROSSBOW_LIMBS),
                Lists.newArrayList(Ingredient.fromItem(Item.getItemFromBlock(Blocks.MAGMA)), Ingredient.fromItem(ItemRegister.BLASTING_CORE), Ingredient.fromItem(Item.getItemFromBlock(Blocks.MAGMA)), Ingredient.fromItem(ItemRegister.JET_AUGMENT)),
                CROSSBOW_LIMBS_QUARTZ));

        if (ConfigMaterial.BRONZE.isNotOff()) {
            MetalFormerRecipes.addRecipe(new FluidStack(AWFluids.FLUID_AETHERIUM_GAS, 144), new OreIngredient("ingotBronze"), INGOT_AETHER, 2100);
            MetalFormerRecipes.addRecipe(new FluidStack(AWFluids.FLUID_AETHERIUM_GAS, 144), new OreIngredient("plateBronze"), PLATE_AETHER, 2100);
        } else {
            MetalFormerRecipes.addRecipe(new FluidStack(AWFluids.FLUID_AETHERIUM_GAS, 144), new OreIngredient("ingotDawnstone"), INGOT_AETHER, 2100);
            MetalFormerRecipes.addRecipe(new FluidStack(AWFluids.FLUID_AETHERIUM_GAS, 144), new OreIngredient("plateDawnstone"), PLATE_AETHER, 2100);
        }

        MetalFormerRecipes.addRecipe(new FluidStack(AWFluids.FLUID_AETHERIUM_GAS, 576), Ingredient.fromItem(Items.DIAMOND), GEM_AETHER, 2200);
        MetalFormerRecipes.addRecipe(new FluidStack(AWFluids.FLUID_AETHERIUM_GAS, 576), Ingredient.fromItem(Items.EMERALD), GEM_AETHER, 2600);

        AetheriumAnvilRecipes.addRecipe(Ingredient.fromStacks(CRUDE_TOOL_ROD), TOOL_ROD, 1, 50, 15, 2100, 3000, 20);
        AetheriumAnvilRecipes.addRecipe(Ingredient.fromStacks(CRUDE_PICKAXE_HEAD), PICKAXE_HEAD, 4, 60, 30, 2400, 2900, 30);
        AetheriumAnvilRecipes.addRecipe(Ingredient.fromStacks(CRUDE_AXE_HEAD), AXE_HEAD, 4, 55, 35, 2350, 2800, 20);
        AetheriumAnvilRecipes.addRecipe(Ingredient.fromStacks(CRUDE_SHOVEL_HEAD), SHOVEL_HEAD, 4, 70, 25, 2500, 2900, 25);
        AetheriumAnvilRecipes.addRecipe(Ingredient.fromStacks(AETHER_CROWN_CRUDE), AETHER_CROWN_MUNDANE, 6, 80, 30, 2500, 2800, 30);
        AetheriumAnvilRecipes.addRecipe(Ingredient.fromStacks(CRUDE_CROSSBOW_FRAME), CROSSBOW_FRAME, 5, 60, 25, 2400, 2800, 20);
        AetheriumAnvilRecipes.addRecipe(Ingredient.fromStacks(CRUDE_CROSSBOW_LIMBS), CROSSBOW_LIMBS, 5, 60, 30, 2400, 2800, 20);

        Stream.of(Geode.Type.values()).forEach(t -> AetheriumAnvilRecipes.addRecipe(new AetheriumAnvilRecipes.GeodeRecipe(Ingredient.fromStacks(new ItemStack(AWItems.GEODE, 1, t.ordinal())), ItemStack.EMPTY, 1, 10, 5, 800, 3000, 10)));
        registerGeodes();

        event.getRegistry().register(new RecipePotionGem());
        event.getRegistry().register(new RecipeCrown());
    }

    @Override
    public void init(FMLInitializationEvent evt) {
        ItemStack AETHER_SHARD = new ItemStack(AWItems.RESOURCE, 1, 0);
        // ItemStack FOCUS_CRYSTAL = new ItemStack(AWItems.RESOURCE, 1, 1);
        ItemStack AETHERIUM_LENS = new ItemStack(AWItems.RESOURCE, 1, 2);
        ItemStack PLATE_AETHER = new ItemStack(AWItems.RESOURCE, 1, 3);
        ItemStack INGOT_AETHER = new ItemStack(AWItems.RESOURCE, 1, 4);
        ItemStack GEM_AETHER = new ItemStack(AWItems.RESOURCE, 1, 5);

        OreDictionary.registerOre("ice", Blocks.ICE);
        OreDictionary.registerOre("icePacked", Blocks.PACKED_ICE);
        OreDictionary.registerOre("oreAether", AWBlocks.AETHER_ORE);
        OreDictionary.registerOre("blockAether", AWBlocks.BLOCK_AETHER);

        OreDictionary.registerOre("shardAether", AETHER_SHARD);
        OreDictionary.registerOre("nuggetAether", AETHER_SHARD);
        OreDictionary.registerOre("lensAether", AETHERIUM_LENS);
        OreDictionary.registerOre("plateAether", PLATE_AETHER);
        OreDictionary.registerOre("ingotAether", INGOT_AETHER);
        OreDictionary.registerOre("gemAether", GEM_AETHER);
    }

    private static void registerGeodes() {
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.BASIC, "cobblestone", 10);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.BASIC, "stone", 10);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.BASIC, "stoneGranite", 10);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.BASIC, "stoneDiorite", 10);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.BASIC, "stoneAndesite", 10);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.BASIC, "marble", 10);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.BASIC, "basalt", 10);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.BASIC, "oreCoal", 20);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.BASIC, "oreIron", 10);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.BASIC, "oreGold", 5);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.BASIC, "oreDiamond", 2);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.BASIC, "oreEmerald", 2);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.BASIC, "oreCopper", 15);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.BASIC, "oreTin", 15);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.BASIC, "oreSilver", 10);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.BASIC, "oreNickel", 10);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.BASIC, "oreLead", 10);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.BASIC, "orePlatinum", 3);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.BASIC, "oreIridium", 1);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.BASIC, "oreAluminum", 15);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.BASIC, "oreRedstone", 10);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.BASIC, "oreSalt", 20);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.BASIC, "oreSaltpeter", 20);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.BASIC, "oreNiter", 20);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.BASIC, "oreLapis", 20);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.BASIC, "oreSapphire", 2);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.BASIC, "oreRuby", 2);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.BASIC, "orePeridot", 2);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.BASIC, "oreGarnet", 2);

        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.HOT, "cobblestone", 2);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.HOT, "stone", 10);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.HOT, "stoneGranite", 20);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.HOT, "stoneDiorite", 10);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.HOT, "stoneAndesite", 10);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.HOT, "marble", 10);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.HOT, "basalt", 30);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.HOT, "sandstone", 30);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.HOT, "obsidian", 20);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.HOT, "oreCoal", 10);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.HOT, "oreIron", 25);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.HOT, "oreGold", 15);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.HOT, "oreDiamond", 3);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.HOT, "oreEmerald", 3);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.HOT, "oreCopper", 12);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.HOT, "oreTin", 12);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.HOT, "oreSilver", 15);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.HOT, "oreNickel", 12);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.HOT, "oreLead", 15);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.HOT, "orePlatinum", 2);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.HOT, "oreIridium", 1);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.HOT, "oreAluminum", 10);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.HOT, "oreRedstone", 20);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.HOT, "oreSalt", 20);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.HOT, "oreSaltpeter", 20);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.HOT, "oreNiter", 50);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.HOT, "oreLapis", 15);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.HOT, "oreSapphire", 3);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.HOT, "oreRuby", 3);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.HOT, "orePeridot", 3);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.HOT, "oreGarnet", 3);

        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.COLD, "ice", 10);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.COLD, "icePacked", 10);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.COLD, "stone", 5);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.COLD, "stoneGranite", 5);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.COLD, "stoneDiorite", 5);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.COLD, "stoneAndesite", 5);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.COLD, "marble", 15);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.COLD, "basalt", 5);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.COLD, "oreCoal", 25);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.COLD, "oreIron", 10);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.COLD, "oreGold", 5);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.COLD, "oreDiamond", 2);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.COLD, "oreEmerald", 2);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.COLD, "oreCopper", 12);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.COLD, "oreTin", 20);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.COLD, "oreSilver", 20);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.COLD, "oreNickel", 20);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.COLD, "oreLead", 20);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.COLD, "orePlatinum", 6);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.COLD, "oreIridium", 1);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.COLD, "oreAluminum", 20);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.COLD, "oreRedstone", 8);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.COLD, "oreSalt", 2);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.COLD, "oreSaltpeter", 40);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.COLD, "oreNiter", 10);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.COLD, "oreLapis", 10);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.COLD, "oreSapphire", 3);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.COLD, "oreRuby", 2);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.COLD, "orePeridot", 2);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.COLD, "oreGarnet", 2);

        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.OCEAN, "sand", 60);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.OCEAN, "stone", 2);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.OCEAN, "stoneGranite", 2);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.OCEAN, "stoneDiorite", 2);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.OCEAN, "stoneAndesite", 2);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.OCEAN, "blockPrismarine", 30);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.OCEAN, "gemPrismarine", 20);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.OCEAN, "dustPrismarine", 20);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.OCEAN, "marble", 2);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.OCEAN, "basalt", 2);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.OCEAN, "oreCoal", 10);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.OCEAN, "oreIron", 8);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.OCEAN, "oreGold", 4);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.OCEAN, "oreDiamond", 8);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.OCEAN, "oreEmerald", 8);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.OCEAN, "oreCopper", 8);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.OCEAN, "oreTin", 8);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.OCEAN, "oreSilver", 8);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.OCEAN, "oreNickel", 8);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.OCEAN, "oreLead", 8);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.OCEAN, "orePlatinum", 2);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.OCEAN, "oreIridium", 1);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.OCEAN, "oreAluminum", 8);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.OCEAN, "oreRedstone", 25);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.OCEAN, "oreSalt", 50);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.OCEAN, "oreSaltpeter", 8);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.OCEAN, "oreNiter", 8);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.OCEAN, "oreLapis", 30);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.OCEAN, "oreSapphire", 8);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.OCEAN, "oreRuby", 8);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.OCEAN, "orePeridot", 8);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.OCEAN, "oreGarnet", 8);

        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.NETHER, "netherrack", 100);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.NETHER, "oreQuartz", 10);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.NETHER, "oreNetherCoal", 20);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.NETHER, "oreNetherIron", 10);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.NETHER, "oreNetherGold", 5);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.NETHER, "oreNetherDiamond", 2);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.NETHER, "oreNetherEmerald", 2);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.NETHER, "oreNetherCopper", 15);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.NETHER, "oreNetherTin", 15);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.NETHER, "oreNetherSilver", 10);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.NETHER, "oreNetherNickel", 10);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.NETHER, "oreNetherLead", 10);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.NETHER, "oreNetherPlatinum", 3);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.NETHER, "oreNetherIridium", 1);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.NETHER, "oreNetherAluminum", 15);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.NETHER, "oreNetherRedstone", 10);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.NETHER, "oreNetherSalt", 20);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.NETHER, "oreNetherSaltpeter", 20);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.NETHER, "oreNetherNiter", 20);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.NETHER, "oreNetherLapis", 20);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.NETHER, "oreNetherSapphire", 2);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.NETHER, "oreNetherRuby", 2);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.NETHER, "oreNetherPeridot", 2);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.NETHER, "oreNetherGarnet", 2);

        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.END, "endstone", 100);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.END, "obsidian", 30);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.END, "oreEndCoal", 20);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.END, "oreEndIron", 10);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.END, "oreEndGold", 5);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.END, "oreEndDiamond", 2);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.END, "oreEndEmerald", 2);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.END, "oreEndCopper", 15);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.END, "oreEndTin", 15);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.END, "oreEndSilver", 10);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.END, "oreEndNickel", 10);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.END, "oreEndLead", 10);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.END, "oreEndPlatinum", 3);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.END, "oreEndIridium", 1);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.END, "oreEndAluminum", 15);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.END, "oreEndRedstone", 10);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.END, "oreEndSalt", 20);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.END, "oreEndSaltpeter", 20);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.END, "oreEndNiter", 20);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.END, "oreEndLapis", 20);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.END, "oreEndSapphire", 2);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.END, "oreEndRuby", 2);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.END, "oreEndPeridot", 2);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.END, "oreEndGarnet", 2);
        AetheriumAnvilRecipes.GeodeRecipe.addEntry(Geode.Type.END, "oreDraconium", 10);
    }
}
