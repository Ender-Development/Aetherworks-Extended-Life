package v0id.aw.common.config;

import net.minecraftforge.common.config.Config;
import v0id.aw.common.config.machine.*;
import v0id.aw.lib.AWConsts;

@Config(modid = AWConsts.MODID, category = "world", name = AWConsts.CFG_FOLDER + "machine")
@Config.LangKey("cfg.aetherworks.machine")
public class ConfigMachine {

    @Config.Name("Anvil")
    @Config.LangKey("cfg.aetherworks.machine.anvil")
    @Config.Comment("Options about the Anvil")
    public static final AnvilCategory ANVIL = new AnvilCategory();

    @Config.Name("Forge")
    @Config.LangKey("cfg.aetherworks.machine.forge")
    @Config.Comment("Options about the Forge")
    public static final ForgeCategory FORGE = new ForgeCategory();

    @Config.Name("Heater")
    @Config.LangKey("cfg.aetherworks.machine.heater")
    @Config.Comment("Options about the Heater")
    public static final HeaterCategory HEATER = new HeaterCategory();

    @Config.Name("Cooler")
    @Config.LangKey("cfg.aetherworks.machine.cooler")
    @Config.Comment("Options about the Cooler")
    public static final CoolerCategory COOLER = new CoolerCategory();

    @Config.Name("Heat Vent")
    @Config.LangKey("cfg.aetherworks.machine.vent")
    @Config.Comment("Options about the Heat Vent")
    public static final VentCategory HEAT_VENT = new VentCategory();

    @Config.Name("Aether Collector")
    @Config.LangKey("cfg.aetherworks.machine.collector")
    @Config.Comment("Options about the Aether Collector")
    public static final CollectorCategory AETHER_COLLECTOR = new CollectorCategory();
}
