package v0id.aw.common.config.machine;

import net.minecraftforge.common.config.Config;

public class CollectorCategory {
    @Config.RequiresMcRestart
    @Config.Name("Start Time")
    @Config.Comment("At what time the collector starts working")
    @Config.RangeInt(min = 0, max = 24000)
    public int start_time = 15000;

    @Config.RequiresMcRestart
    @Config.Name("End Time")
    @Config.Comment("At what time the collector stops working")
    @Config.RangeInt(min = 0, max = 24000)
    public int stop_time = 21000;

    @Config.RequiresMcRestart
    @Config.Name("Aether Generated")
    @Config.Comment("How much aether is generated per operation")
    @Config.RangeInt(min = 1, max = 1000)
    public int aether_generated = 10;

    @Config.RequiresMcRestart
    @Config.Name("Seconds between operations")
    @Config.Comment("How many seconds between each operation")
    @Config.RangeInt(min = 1)
    public int seconds_between_operations = 3;
}
