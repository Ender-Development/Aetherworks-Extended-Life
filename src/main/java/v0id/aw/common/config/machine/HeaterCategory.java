package v0id.aw.common.config.machine;

import net.minecraftforge.common.config.Config;

public class HeaterCategory {
    @Config.RequiresMcRestart
    @Config.Name("Ember Capacity")
    @Config.Comment("How much ember the heater can store")
    @Config.RangeInt(min = 1)
    public int ember_capacity = 1000;

    @Config.RequiresMcRestart
    @Config.Name("Heat per Tick")
    @Config.Comment("How much heat the heater generates per tick")
    @Config.RangeInt(min = 1)
    public int heat_per_tick = 1;

    @Config.RequiresMcRestart
    @Config.Name("Ember per Tick")
    @Config.Comment("How much ember the heater consumes per tick")
    @Config.RangeDouble(min = 0.10)
    public double ember_per_tick = 0.25;

    @Config.RequiresMcRestart
    @Config.Name("Water per Tick")
    @Config.Comment("How much water the heater consumes per tick")
    @Config.RangeInt(min = 1)
    public int water_per_tick = 1;
}
