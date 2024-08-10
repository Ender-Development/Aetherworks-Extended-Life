package v0id.aw.common.config.tool;

import net.minecraftforge.common.config.Config;

public class ToolCategory {
    @Config.Name("Aetherium")
    @Config.LangKey("cfg.aetherworks.tool.aetherium")
    @Config.Comment("Options for the Aetherium Tools")
    public final Tool AETHERIUM = new Tool(7, 3888, 12, 5, 10);

    public static class Tool {
        @Config.RequiresMcRestart
        @Config.Name("Harvest Level")
        @Config.Comment("The harvest level of this material.")
        public int harvestLevel;

        @Config.RequiresMcRestart
        @Config.Name("Base Durability")
        @Config.Comment("The base durability of this material.")
        public int durability;

        @Config.RequiresMcRestart
        @Config.Name("Base Efficiency")
        @Config.Comment("The base efficiency of this material.")
        public float efficiency;

        @Config.RequiresMcRestart
        @Config.Name("Base Damage")
        @Config.Comment("The base damage of this material.")
        public float damage;

        @Config.RequiresMcRestart
        @Config.Name("Enchantability")
        @Config.Comment("The enchantability of this material.")
        public int enchantability;

        private Tool(int harvestLevel, int durability, float efficiency, float damage, int enchantability) {
            this.harvestLevel = harvestLevel;
            this.durability = durability;
            this.efficiency = efficiency;
            this.damage = damage;
            this.enchantability = enchantability;
        }
    }
}
