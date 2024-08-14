package v0id.aw.common.config.machine;

import net.minecraftforge.common.config.Config;

public class AnvilCategory {
    @Config.RequiresMcRestart
    @Config.Name("Max Mistakes")
    @Config.Comment("The maximum amount of mistakes the player can make before the item is destroyed.")
    @Config.RangeInt(min = 1)
    public int max_mistakes = 3;
}
