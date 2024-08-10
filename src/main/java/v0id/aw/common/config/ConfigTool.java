package v0id.aw.common.config;

import net.minecraftforge.common.config.Config;
import v0id.aw.common.config.tool.ToolCategory;
import v0id.aw.lib.AWConsts;

@Config(modid = AWConsts.MODID, category = "world", name = AWConsts.CFG_FOLDER + "tool")
@Config.LangKey("cfg.aetherworks.tool")
public class ConfigTool {
    @Config.Name("Tool Material Values")
    @Config.LangKey("cfg.aetherworks.tool")
    @Config.Comment("Options about tools")
    public static final ToolCategory TOOL = new ToolCategory();
}
