package v0id.aw.common.config.tool;

import net.minecraftforge.common.config.Config;

public class AetheriumAshenArmorCategory {
    @Config.RequiresMcRestart
    @Config.Name("Aetherium Crown as Bauble")
    @Config.Comment({
            "Controls if the Aetherium Crown is converted to a bauble.",
            "True value allows crown to be equipped in the head bauble slot.",
            "False value leaves the crown unmodified."
    })
    public boolean aetheriumCrownAsBauble = true;

    @Config.RequiresMcRestart
    @Config.Name("Aetherium Armor Recipes")
    @Config.Comment({
            "Enable this to turn on the stamper recipes for the aetherium armor."
    })
    public boolean aetheriumArmorRecipes = true;

    @Config.RequiresMcRestart
    @Config.Name("Aetherium Gas Cost")
    @Config.Comment({
            "Controls how much aetherium gas must be in the stamper base and will be consumed to complete the recipe."
    })
    @Config.RangeInt(min = 0)
    public int aetheriumGasCost = 750;

    @Config.RequiresMcRestart
    @Config.Name("Render Crown Bauble")
    @Config.Comment({
            "Not currently in use. If you know someone who's good at rendering and wants to help, send them my way. :)"
    })
    public boolean renderCrownBauble = false;
}
