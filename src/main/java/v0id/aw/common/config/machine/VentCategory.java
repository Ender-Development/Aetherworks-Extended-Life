package v0id.aw.common.config.machine;

import net.minecraftforge.common.config.Config;

public class VentCategory {
    @Config.RequiresMcRestart
    @Config.Name("Heat per Tick")
    @Config.Comment("How much heat the Heat Vent dissipates per tick")
    @Config.RangeDouble(min = 0.01)
    public double heat_per_tick = 0.5;
}
