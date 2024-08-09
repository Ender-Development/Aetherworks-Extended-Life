package v0id.aw.common.config.machine;

import net.minecraftforge.common.config.Config;

public class ForgeCategory {
    @Config.RequiresMcRestart
    @Config.Name("Ember Capacity")
    @Config.Comment("How much ember the forge can store")
    @Config.RangeInt(min = 1)
    public int ember_capacity = 5000;

    @Config.RequiresMcRestart
    @Config.Name("Heat Capacity")
    @Config.Comment("How much heat the forge can store")
    @Config.RangeInt(min = 3000)
    public int heat_capacity = 3000;

    @Config.RequiresMcRestart
    @Config.Name("Old Redstone Behavior")
    @Config.Comment("If true, the forge will emit a redstone signal equal to it's light value index")
    public boolean old_redstone_behavior = false;
}
