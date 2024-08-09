package v0id.aw.lib;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.EnumHelper;
import teamroots.embers.Embers;

/**
 * Created by V0idWa1k3r on 31-May-17.
 */
public class AWConsts
{
    public static final String MODID = "aetherworks";
    public static final String MODNAME = "Aetherworks";
    public static final String CFG_FOLDER = Embers.CFG_ADDONS_FOLDER + "aetherworks/";
    public static final String deps = "required-after:embers@[1.23,);before:crafttweaker";

    public static final String clientProxy = "v0id.aw.client.AWClient";
    public static final String serverProxy = "v0id.aw.server.AWServer";

    public static final String blockAetherOreID = "aether_ore";
    public static final ResourceLocation blockAetherOre = new ResourceLocation(MODID, blockAetherOreID);
    public static final String blockAetherPrismControllerMatrixID = "aether_prism_controller_matrix";
    public static final ResourceLocation blockAetherPrismControllerMatrix = new ResourceLocation(MODID, blockAetherPrismControllerMatrixID);
    public static final String blockMoonlightAmplifierID = "moonlight_amplifier";
    public static final ResourceLocation blockMoonlightAmplifier = new ResourceLocation(MODID, blockMoonlightAmplifierID);
    public static final String blockPrismID = "prism";
    public static final ResourceLocation blockPrism = new ResourceLocation(MODID, blockPrismID);
    public static final String blockPrismSupportID = "prism_support";
    public static final ResourceLocation blockPrismSupport = new ResourceLocation(MODID, blockPrismSupportID);
    public static final String blockImpureAetheriumGasID = "impure_aetherium_gas";
    public static final ResourceLocation blockImpureAetheriumGas = new ResourceLocation(MODID, blockImpureAetheriumGasID);
    public static final String blockAetheriumGasID = "aetherium_gas";
    public static final ResourceLocation blockAetheriumGas = new ResourceLocation(MODID, blockAetheriumGasID);
    public static final String blockForgeID = "forge_structure";
    public static final ResourceLocation blockForge = new ResourceLocation(MODID, blockForgeID);
    public static final String blockAetherID = "block_aether";
    public static final ResourceLocation blockAether = new ResourceLocation(MODID, blockAetherID);
    public static final String blockComponentID = "forge_component";
    public static final ResourceLocation blockComponent = new ResourceLocation(MODID, blockComponentID);
    public static final String blockHeatDialID = "heat_dial";
    public static final ResourceLocation blockHeatDial = new ResourceLocation(MODID, blockHeatDialID);

    public static final String fluidImpureAetherium = "aetherworks.impure_aetherium_gas";
    public static final String fluidAetherium = "aetherworks.aetherium_gas";
    public static final ResourceLocation fluidAetheriumGasLoc = new ResourceLocation(MODID, "blocks/aether_gas");

    public static final String itemResourceID = "item_resource";
    public static final ResourceLocation itemResource = new ResourceLocation(MODID, itemResourceID);
    public static final String itemPickaxeAetherID = "item_pickaxe_aether";
    public static final ResourceLocation itemPickaxeAether = new ResourceLocation(MODID, itemPickaxeAetherID);
    public static final String itemPickaxeEmberID = "item_pickaxe_ember";
    public static final ResourceLocation itemPickaxeEmber = new ResourceLocation(MODID, itemPickaxeEmberID);
    private static final String itemPickaxeID = "item_pickaxe";
    public static final ResourceLocation itemPickaxe = new ResourceLocation(MODID, itemPickaxeID);
    public static final String itemGeodeID = "item_geode";
    public static final ResourceLocation itemGeode = new ResourceLocation(MODID, itemGeodeID);
    public static final String itemAxePrismarineID = "item_axe_prismarine";
    public static final ResourceLocation itemAxePrismarine = new ResourceLocation(MODID, itemAxePrismarineID);
    public static final String itemAxeEnderID = "item_axe_ender";
    public static final ResourceLocation itemAxeEnder = new ResourceLocation(MODID, itemAxeEnderID);
    private static final String itemAxeID = "item_axe";
    public static final ResourceLocation itemAxe = new ResourceLocation(MODID, itemAxeID);
    public static final String itemShovelRedstoneID = "item_shovel_redstone";
    public static final ResourceLocation itemShovelRedstone = new ResourceLocation(MODID, itemShovelRedstoneID);
    public static final String itemShovelSlimeID = "item_shovel_slime";
    public static final ResourceLocation itemShovelSlime = new ResourceLocation(MODID, itemShovelSlimeID);
    private static final String itemShovelID = "item_shovel";
    public static final ResourceLocation itemShovel = new ResourceLocation(MODID, itemShovelID);
    public static final String itemPotionGemID = "item_potion_gem";
    public static final ResourceLocation itemPotionGem = new ResourceLocation(MODID, itemPotionGemID);
    public static final String itemCrownID = "item_crown";
    public static final ResourceLocation itemCrown = new ResourceLocation(MODID, itemCrownID);
    public static final String itemCrossbowQuartzID = "item_crossbow_quartz";
    public static final ResourceLocation itemCrossbowQuartz = new ResourceLocation(MODID, itemCrossbowQuartzID);
    public static final String itemCrossbowMagmaID = "item_crossbow_magma";
    public static final ResourceLocation itemCrossbowMagma = new ResourceLocation(MODID, itemCrossbowMagmaID);

    public static final String recipePotionGemID = "recipe_potion_gem";
    public static final ResourceLocation recipePotionGem = new ResourceLocation(MODID, itemPotionGemID);
    public static final String recipeCrownID = "recipe_crown";
    public static final ResourceLocation recipeCrown = new ResourceLocation(MODID, recipeCrownID);

    public static final String entityAWArrowID = "entity_arrow";
    public static final ResourceLocation entityAWArrow = new ResourceLocation(MODID, entityAWArrowID);
    public static final String entityAWMagmaID = "entity_magma";
    public static final ResourceLocation entityAWMagma = new ResourceLocation(MODID, entityAWMagmaID);

    public static final ResourceLocation metalFormerUI = new ResourceLocation(MODID, "textures/compat/jei/ui_metal_former.png");
    public static final String catIDMetalFormer = "aetherworks.metal_former";
    public static final ResourceLocation anvilUI = new ResourceLocation(MODID, "textures/compat/jei/ui_anvil.png");
    public static final String catIDAnvil = "aetherworks.anvil";
    public static final ResourceLocation shovelUI = new ResourceLocation(MODID, "textures/ui/shovel_overlays.png");

    public static final Item.ToolMaterial AETHERIUM = EnumHelper.addToolMaterial("AETHERIUM", 7, 3888, 12, 5, 10);
}
