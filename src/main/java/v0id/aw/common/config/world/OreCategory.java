package v0id.aw.common.config.world;

import net.minecraftforge.common.config.Config;

public class OreCategory {
    @Config.RequiresMcRestart
    @Config.Name("Aether Ore")
    @Config.Comment("Generation settings")
    public final Ore oreAether = new Ore(4, 80, 128, 4, -1, 1);

    @Config.RequiresMcRestart
    @Config.Name("Retrogen")
    @Config.Comment("Whether ore retrogen is enabled or not.")
    public boolean enableRetrogen = false;

    @Config.RequiresMcRestart
    @Config.Name("Retrogen Key")
    @Config.Comment("The key for the retrogen. Changing this will make chunks retrogenerate the ore even if it was already generated.")
    public String retrogenKey = "gen";

    public static class Ore {
        @Config.RequiresMcRestart
        @Config.Name("Tries per chunk")
        @Config.Comment("The amount of times the ore will try to generate in each chunk. Set to less than 1 to turn this into a chance to generate type of value")
        public float triesPerChunk;

        @Config.RequiresMcRestart
        @Config.Name("Minimum Y")
        @Config.Comment("Minimum Y coordinate for this ore")
        public int minHeight;

        @Config.RequiresMcRestart
        @Config.Name("Maximum Y")
        @Config.Comment("Maximum Y coordinate for this ore")
        public int maxHeight;

        @Config.RequiresMcRestart
        @Config.Name("Vein size")
        @Config.Comment("The maximum size of the vein")
        public int veinSize;

        @Config.RequiresMcRestart
        @Config.Name("Blacklist dimensions")
        @Config.Comment("The list of dimension IDs this ore is NOT allowed to generate in")
        public int[] blacklistDimensions;

        Ore(float triesPerChunk, int minHeight, int maxHeight, int veinSize, int... blacklistDimensions) {
            this.triesPerChunk = triesPerChunk;
            this.minHeight = minHeight;
            this.maxHeight = maxHeight;
            this.veinSize = veinSize;
            this.blacklistDimensions = blacklistDimensions;
        }
    }
}
