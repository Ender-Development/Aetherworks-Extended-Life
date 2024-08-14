package v0id.aw.common.research;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import teamroots.embers.register.BlockRegister;
import teamroots.embers.research.ResearchBase;
import teamroots.embers.research.ResearchCategory;
import teamroots.embers.research.ResearchManager;
import teamroots.embers.research.subtypes.ResearchFakePage;
import teamroots.embers.research.subtypes.ResearchShowItem;
import teamroots.embers.research.subtypes.ResearchSwitchCategory;
import teamroots.embers.util.Vec2i;
import v0id.aw.common.block.AWBlocks;
import v0id.aw.common.item.AWItems;
import v0id.aw.lib.AWConsts;
import v0id.aw.lib.ILifecycleListener;

public class AWResearch implements ILifecycleListener {
    public static ResearchCategory categoryAetherworks;
    public static ResearchCategory subCategoryAetherCollector;
    public static ResearchCategory subCategoryAetheriumTools;
    public static ResearchBase aetherium_ore;
    public static ResearchBase aether_collector;
    public static ResearchBase purifying_aetherium;
    public static ResearchBase forge;
    public static ResearchBase heater;
    public static ResearchBase cooler;
    public static ResearchBase vent;
    public static ResearchBase metal_former;
    public static ResearchBase anvil;
    public static ResearchBase aetherium_tools;
    public static ResearchBase pickaxe_boundless_sky;
    public static ResearchBase pickaxe_molten_depths;
    public static ResearchBase axe_ancient_torrents;
    public static ResearchBase axe_twisted_realm;
    public static ResearchBase shovel_perfect_machines;
    public static ResearchBase shovel_ineluctable_changes;
    public static ResearchBase crossbow_impending_doom;
    public static ResearchBase crossbow_raging_volcano;
    public static ResearchBase aetherium_crown;
    public static ResearchBase potion_gem;
    public static ResearchBase collector_large_pillar_1, collector_large_pillar_2, collector_large_pillar_3, collector_large_pillar_4;
    public static ResearchBase collector_small_pillar_1, collector_small_pillar_2, collector_small_pillar_3, collector_small_pillar_4;
    public static ResearchBase redstone_control;

    public static void initResearch() {
        Vec2i[] randomPositions = new Vec2i[]{new Vec2i(0, 6), new Vec2i(1, 3), new Vec2i(0, 0), new Vec2i(6, 3), new Vec2i(6, 6), new Vec2i(9, 0), new Vec2i(12, 3), new Vec2i(9, 5), new Vec2i(9, 7), new Vec2i(11, 7), new Vec2i(5, 5), new Vec2i(4, 7), new Vec2i(12, 5), new Vec2i(2, 4)};
        Vec2i[] ringPositions = new Vec2i[]{new Vec2i(1, 1), new Vec2i(0, 3), new Vec2i(0, 5), new Vec2i(1, 7), new Vec2i(11, 7), new Vec2i(12, 5), new Vec2i(12, 3), new Vec2i(11, 1), new Vec2i(4, 1), new Vec2i(8, 1), new Vec2i(4, 7), new Vec2i(8, 7), new Vec2i(10, 4), new Vec2i(8, 1)};
        Vec2i[] pillarPositions = new Vec2i[]{new Vec2i(6, 0), new Vec2i(6, 8), new Vec2i(2, 4), new Vec2i(10, 4), new Vec2i(3, 1), new Vec2i(9, 1), new Vec2i(3, 7), new Vec2i(9, 7)};
        categoryAetherworks = new ResearchCategory("aetherworks", new ResourceLocation(AWConsts.MODID, "textures/gui/codex_index.png"), 192.0, 16.0).pushGoodLocations(randomPositions);
        subCategoryAetherCollector = new ResearchCategory("aether_collector", 0.0).pushGoodLocations(pillarPositions);
        subCategoryAetheriumTools = new ResearchCategory("aetherium_tools", 0.0).pushGoodLocations(ringPositions);

        aetherium_ore = new ResearchBase("aetherium_ore", new ItemStack(AWBlocks.AETHER_ORE), categoryAetherworks.popGoodLocation());
        purifying_aetherium = new ResearchBase("purifying_aetherium", new ItemStack(BlockRegister.MIXER), categoryAetherworks.popGoodLocation()).addAncestor(aetherium_ore);
        forge = new ResearchBase("forge", new ItemStack(AWBlocks.FORGE_COMPONENT, 1, 0), categoryAetherworks.popGoodLocation()).addPage(new ResearchBase("forge_1", ItemStack.EMPTY, 0, 0)).addPage(new ResearchBase("forge_2", ItemStack.EMPTY, 0, 0)).addAncestor(purifying_aetherium);
        heater = new ResearchBase("heater", new ItemStack(AWBlocks.FORGE_COMPONENT, 1, 1), categoryAetherworks.popGoodLocation()).addPage(new ResearchBase("heater_1", ItemStack.EMPTY, 0, 0)).addAncestor(forge);
        cooler = new ResearchBase("cooler", new ItemStack(AWBlocks.FORGE_COMPONENT, 1, 2), categoryAetherworks.popGoodLocation()).addPage(new ResearchBase("cooler_1", ItemStack.EMPTY, 0, 0)).addAncestor(forge);
        vent = new ResearchBase("vent", new ItemStack(AWBlocks.FORGE_COMPONENT, 1, 3), categoryAetherworks.popGoodLocation()).addAncestor(forge);
        metal_former = new ResearchBase("metal_former", new ItemStack(AWBlocks.FORGE_COMPONENT, 1, 4), categoryAetherworks.popGoodLocation()).addAncestor(forge);
        anvil = new ResearchBase("anvil", new ItemStack(AWBlocks.FORGE_COMPONENT, 1, 5), categoryAetherworks.popGoodLocation()).addPage(new ResearchBase("anvil_1", ItemStack.EMPTY, 0, 0)).addAncestor(metal_former);

        aether_collector = new ResearchShowItem("aether_collector", new ItemStack(AWBlocks.PRISM), categoryAetherworks.popGoodLocation()).addItem(new ResearchShowItem.DisplayItem(new ItemStack(BlockRegister.BLOCK_TANK), new ItemStack(AWBlocks.PRISM_SUPPORT), new ItemStack(AWBlocks.PRISM_SUPPORT), new ItemStack(AWBlocks.PRISM))).addPage(new ResearchBase("aether_collector_1", ItemStack.EMPTY, 0, 0));

        collector_large_pillar_1 = new ResearchShowItem("collector_large_pillar", new ItemStack(AWBlocks.MOONLIGHT_AMPLIFIER, 1, 0), subCategoryAetherCollector.popGoodLocation()).addItem(new ResearchShowItem.DisplayItem(new ItemStack(BlockRegister.ARCHAIC_BRICKS), new ItemStack(BlockRegister.ARCHAIC_BRICKS), new ItemStack(BlockRegister.ARCHAIC_EDGE), new ItemStack(AWBlocks.MOONLIGHT_AMPLIFIER, 1, 0)));
        collector_large_pillar_2 = new ResearchShowItem("collector_large_pillar", new ItemStack(AWBlocks.MOONLIGHT_AMPLIFIER, 1, 0), subCategoryAetherCollector.popGoodLocation()).addItem(new ResearchShowItem.DisplayItem(new ItemStack(BlockRegister.ARCHAIC_BRICKS), new ItemStack(BlockRegister.ARCHAIC_BRICKS), new ItemStack(BlockRegister.ARCHAIC_EDGE), new ItemStack(AWBlocks.MOONLIGHT_AMPLIFIER, 1, 0)));
        collector_large_pillar_3 = new ResearchShowItem("collector_large_pillar", new ItemStack(AWBlocks.MOONLIGHT_AMPLIFIER, 1, 0), subCategoryAetherCollector.popGoodLocation()).addItem(new ResearchShowItem.DisplayItem(new ItemStack(BlockRegister.ARCHAIC_BRICKS), new ItemStack(BlockRegister.ARCHAIC_BRICKS), new ItemStack(BlockRegister.ARCHAIC_EDGE), new ItemStack(AWBlocks.MOONLIGHT_AMPLIFIER, 1, 0)));
        collector_large_pillar_4 = new ResearchShowItem("collector_large_pillar", new ItemStack(AWBlocks.MOONLIGHT_AMPLIFIER, 1, 0), subCategoryAetherCollector.popGoodLocation()).addItem(new ResearchShowItem.DisplayItem(new ItemStack(BlockRegister.ARCHAIC_BRICKS), new ItemStack(BlockRegister.ARCHAIC_BRICKS), new ItemStack(BlockRegister.ARCHAIC_EDGE), new ItemStack(AWBlocks.MOONLIGHT_AMPLIFIER, 1, 0)));
        collector_small_pillar_1 = new ResearchShowItem("collector_small_pillar", new ItemStack(AWBlocks.AETHER_PRISM_CONTROLLER_MATRIX, 1, 0), subCategoryAetherCollector.popGoodLocation()).addItem(new ResearchShowItem.DisplayItem(new ItemStack(BlockRegister.ARCHAIC_BRICKS), new ItemStack(BlockRegister.ARCHAIC_EDGE), new ItemStack(AWBlocks.AETHER_PRISM_CONTROLLER_MATRIX, 1, 0)));
        collector_small_pillar_2 = new ResearchShowItem("collector_small_pillar", new ItemStack(AWBlocks.AETHER_PRISM_CONTROLLER_MATRIX, 1, 0), subCategoryAetherCollector.popGoodLocation()).addItem(new ResearchShowItem.DisplayItem(new ItemStack(BlockRegister.ARCHAIC_BRICKS), new ItemStack(BlockRegister.ARCHAIC_EDGE), new ItemStack(AWBlocks.AETHER_PRISM_CONTROLLER_MATRIX, 1, 0)));
        collector_small_pillar_3 = new ResearchShowItem("collector_small_pillar", new ItemStack(AWBlocks.AETHER_PRISM_CONTROLLER_MATRIX, 1, 0), subCategoryAetherCollector.popGoodLocation()).addItem(new ResearchShowItem.DisplayItem(new ItemStack(BlockRegister.ARCHAIC_BRICKS), new ItemStack(BlockRegister.ARCHAIC_EDGE), new ItemStack(AWBlocks.AETHER_PRISM_CONTROLLER_MATRIX, 1, 0)));
        collector_small_pillar_4 = new ResearchShowItem("collector_small_pillar", new ItemStack(AWBlocks.AETHER_PRISM_CONTROLLER_MATRIX, 1, 0), subCategoryAetherCollector.popGoodLocation()).addItem(new ResearchShowItem.DisplayItem(new ItemStack(BlockRegister.ARCHAIC_BRICKS), new ItemStack(BlockRegister.ARCHAIC_EDGE), new ItemStack(AWBlocks.AETHER_PRISM_CONTROLLER_MATRIX, 1, 0)));

        aetherium_tools = new ResearchBase("aetherium_tools", new ItemStack(AWItems.RESOURCE, 1, 7), categoryAetherworks.popGoodLocation()).addPage(new ResearchBase("aetherium_tools_1", ItemStack.EMPTY, 0, 0));

        pickaxe_boundless_sky = new ResearchBase("pickaxe_boundless_sky", new ItemStack(AWItems.PICKAXE_AETHERIUM), subCategoryAetheriumTools.popGoodLocation());
        pickaxe_molten_depths = new ResearchBase("pickaxe_molten_depths", new ItemStack(AWItems.PICKAXE_EMBER), subCategoryAetheriumTools.popGoodLocation());
        axe_ancient_torrents = new ResearchBase("axe_ancient_torrents", new ItemStack(AWItems.AXE_PRISMARINE), subCategoryAetheriumTools.popGoodLocation());
        axe_twisted_realm = new ResearchBase("axe_twisted_realm", new ItemStack(AWItems.AXE_ENDER), subCategoryAetheriumTools.popGoodLocation());
        shovel_perfect_machines = new ResearchBase("shovel_perfect_machines", new ItemStack(AWItems.SHOVEL_REDSTONE), subCategoryAetheriumTools.popGoodLocation()).addPage(new ResearchBase("shovel_perfect_machines_1", ItemStack.EMPTY, 0, 0));
        shovel_ineluctable_changes = new ResearchBase("shovel_ineluctable_changes", new ItemStack(AWItems.SHOVEL_SLIME), subCategoryAetheriumTools.popGoodLocation());
        crossbow_impending_doom = new ResearchBase("crossbow_impending_doom", new ItemStack(AWItems.CROSSBOW_QUARTZ), subCategoryAetheriumTools.popGoodLocation()).addPage(new ResearchBase("crossbow_impending_doom_1", ItemStack.EMPTY, 0, 0));
        crossbow_raging_volcano = new ResearchBase("crossbow_raging_volcano", new ItemStack(AWItems.CROSSBOW_MAGMA), subCategoryAetheriumTools.popGoodLocation()).addPage(new ResearchBase("crossbow_raging_volcano_1", ItemStack.EMPTY, 0, 0));
        aetherium_crown = new ResearchBase("aetherium_crown", new ItemStack(AWItems.CROWN), subCategoryAetheriumTools.popGoodLocation());
        potion_gem = new ResearchBase("potion_gem", new ItemStack(AWItems.POTION_GEM), subCategoryAetheriumTools.popGoodLocation());

        redstone_control = new ResearchShowItem("redstone_control_forge", new ItemStack(Items.COMPARATOR), 12, 0).addItem(new ResearchShowItem.DisplayItem(new ItemStack(AWBlocks.FORGE_COMPONENT)));
        redstone_control.addPage(new ResearchShowItem("redstone_control_anvil", ItemStack.EMPTY, 0, 0).addItem(new ResearchShowItem.DisplayItem(new ItemStack(AWBlocks.FORGE_COMPONENT, 1, 5))));
        redstone_control.addPage(new ResearchShowItem("redstone_control_metalformer", ItemStack.EMPTY, 0, 0).addItem(new ResearchShowItem.DisplayItem(new ItemStack(AWBlocks.FORGE_COMPONENT, 1, 4))));

        ResearchBase aetherium_tools_page = new ResearchFakePage(aetherium_tools, 6, 4);
        subCategoryAetheriumTools.addResearch(aetherium_tools_page);
        subCategoryAetheriumTools.addResearch(pickaxe_boundless_sky.addAncestor(aetherium_tools_page));
        subCategoryAetheriumTools.addResearch(pickaxe_molten_depths.addAncestor(aetherium_tools_page));
        subCategoryAetheriumTools.addResearch(axe_ancient_torrents.addAncestor(aetherium_tools_page));
        subCategoryAetheriumTools.addResearch(axe_twisted_realm.addAncestor(aetherium_tools_page));
        subCategoryAetheriumTools.addResearch(shovel_perfect_machines.addAncestor(aetherium_tools_page));
        subCategoryAetheriumTools.addResearch(shovel_ineluctable_changes.addAncestor(aetherium_tools_page));
        subCategoryAetheriumTools.addResearch(crossbow_impending_doom.addAncestor(aetherium_tools_page));
        subCategoryAetheriumTools.addResearch(crossbow_raging_volcano.addAncestor(aetherium_tools_page));
        subCategoryAetheriumTools.addResearch(aetherium_crown.addAncestor(aetherium_tools_page));
        subCategoryAetheriumTools.addResearch(potion_gem.addAncestor(aetherium_crown));

        ResearchBase aether_collector_page = new ResearchFakePage(aether_collector, 6, 4);
        subCategoryAetherCollector.addResearch(aether_collector_page);
        subCategoryAetherCollector.addResearch(collector_large_pillar_1.addAncestor(aether_collector_page));
        subCategoryAetherCollector.addResearch(collector_large_pillar_2.addAncestor(aether_collector_page));
        subCategoryAetherCollector.addResearch(collector_large_pillar_3.addAncestor(aether_collector_page));
        subCategoryAetherCollector.addResearch(collector_large_pillar_4.addAncestor(aether_collector_page));
        subCategoryAetherCollector.addResearch(collector_small_pillar_1.addAncestor(aether_collector_page));
        subCategoryAetherCollector.addResearch(collector_small_pillar_2.addAncestor(aether_collector_page));
        subCategoryAetherCollector.addResearch(collector_small_pillar_3.addAncestor(aether_collector_page));
        subCategoryAetherCollector.addResearch(collector_small_pillar_4.addAncestor(aether_collector_page));

        ResearchBase collectorSwitch = makeCategorySwitch(subCategoryAetherCollector, 3, 6, new ItemStack(AWBlocks.PRISM), 0, 1).addAncestor(aetherium_ore);
        ResearchBase toolSwitch = makeCategorySwitch(subCategoryAetheriumTools, 12, 6, new ItemStack(AWItems.RESOURCE, 1, 7), 0, 1).addAncestor(anvil);

        categoryAetherworks.addPrerequisite(ResearchManager.dawnstone);
        categoryAetherworks.addResearch(aetherium_ore);
        categoryAetherworks.addResearch(purifying_aetherium);
        categoryAetherworks.addResearch(forge);
        categoryAetherworks.addResearch(heater);
        categoryAetherworks.addResearch(cooler);
        categoryAetherworks.addResearch(vent);
        categoryAetherworks.addResearch(metal_former);
        categoryAetherworks.addResearch(anvil);
        categoryAetherworks.addResearch(collectorSwitch);
        categoryAetherworks.addResearch(toolSwitch);
        categoryAetherworks.addResearch(redstone_control);
        ResearchManager.researches.add(categoryAetherworks);
    }

    public void postInit(FMLPostInitializationEvent evt) {
        initResearch();
    }

    private static ResearchSwitchCategory makeCategorySwitch(ResearchCategory targetCategory, int x, int y, ItemStack icon, int u, int v) {
        return (ResearchSwitchCategory) (new ResearchSwitchCategory(targetCategory.name + "_category", icon, (double) x, (double) y)).setTargetCategory(targetCategory).setIconBackground(ResearchManager.PAGE_ICONS, 0.09375 * (double) u, 0.09375 * (double) v);
    }
}
