package v0id.aw.common.config.machine;

import net.minecraftforge.common.config.Config;

public class CoolerCategory {
    @Config.RequiresMcRestart
    @Config.Name("Ember Capacity")
    @Config.Comment("How much ember the cooler can store")
    @Config.RangeInt(min = 1)
    public int ember_capacity = 1000;

    @Config.RequiresMcRestart
    @Config.Name("Heat per Activation")
    @Config.Comment("How much heat the cooler removes per activation")
    @Config.RangeInt(min = 1)
    public int heat_per_activation = 500;

    @Config.RequiresMcRestart
    @Config.Name("Ember per Activation")
    @Config.Comment("How much ember the cooler consumes per activation")
    @Config.RangeInt(min = 1)
    public int ember_per_activation = 1000;

    @Config.RequiresMcRestart
    @Config.Name("Cooldown between Activation")
    @Config.Comment("How many ticks the cooler has to wait between activations")
    @Config.RangeInt(min = 1)
    public int cooldown_between_activation = 2400;
}
