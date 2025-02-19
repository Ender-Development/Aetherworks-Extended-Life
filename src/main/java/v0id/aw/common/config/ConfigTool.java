package v0id.aw.common.config;

import net.minecraftforge.common.config.Config;
import v0id.aw.common.config.tool.AetheriumAshenArmorCategory;
import v0id.aw.common.config.tool.AetheriumBlazingRayCategory;
import v0id.aw.common.config.tool.AetheriumStaffCatergory;
import v0id.aw.common.config.tool.ToolCategory;
import v0id.aw.lib.AWConsts;

@Config(modid = AWConsts.MODID, category = "world", name = AWConsts.CFG_FOLDER + "tool")
@Config.LangKey("cfg.aetherworks.tool")
public class ConfigTool {
    @Config.Name("Tool Material Values")
    @Config.LangKey("cfg.aetherworks.tool.toolmaterial")
    @Config.Comment("Options about tools")
    public static final ToolCategory TOOL = new ToolCategory();

    @Config.Name("Aetherium Blazing Ray")
    @Config.LangKey("cfg.aetherworks.tool.aetheriumblazingray")
    @Config.Comment("Options about the Aetherium Blazing Ray")
    public static final AetheriumBlazingRayCategory AETHERIUM_BLAZING_RAY = new AetheriumBlazingRayCategory();

    @Config.Name("Aetherium Staff")
    @Config.LangKey("cfg.aetherworks.tool.aetheriumstaff")
    @Config.Comment("Options about the Aetherium Staff")
    public static final AetheriumStaffCatergory AETHERIUM_STAFF = new AetheriumStaffCatergory();

    @Config.Name("Aetherium Ashen Armor")
    @Config.LangKey("cfg.aetherworks.tool.aetheriumashenarmor")
    @Config.Comment("Options about the Aetherium Ashen Armor")
    public static final AetheriumAshenArmorCategory AETHERIUM_ASHEN_ARMOR = new AetheriumAshenArmorCategory();
}
