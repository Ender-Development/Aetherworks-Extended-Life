package v0id.aw.common.config;

import net.minecraftforge.common.config.Config;
import v0id.aw.common.config.world.OreCategory;
import v0id.aw.lib.AWConsts;

@Config(modid = AWConsts.MODID, category = "world", name = AWConsts.CFG_FOLDER + "world")
@Config.LangKey("cfg.aetherworks.world")
public class ConfigWorld {

    @Config.Name("Ore Generation")
    @Config.LangKey("cfg.aetherworks.world.ore")
    @Config.Comment("Options about the ore generation")
    public static final OreCategory ORE = new OreCategory();
}
