package v0id.aw.common.config.tool;

import net.minecraftforge.common.config.Config;

public class AetheriumBlazingRayCategory {
    @Config.RequiresMcRestart
    @Config.Name("Ember Cost")
    @Config.Comment({"Ember used up by each shot."})
    public double cost = 50;

    @Config.RequiresMcRestart
    @Config.Name("Charge")
    @Config.Comment({"Time in ticks to fully charge."})
    public double charge = 20;

    @Config.RequiresMcRestart
    @Config.Name("Cooldown")
    @Config.Comment({"Cooldown in ticks between each shot."})
    public int cooldown = 10;

    @Config.RequiresMcRestart
    @Config.Name("Damage")
    @Config.Comment({"Damage dealt by one shot."})
    public float damage = 15F;

    @Config.RequiresMcRestart
    @Config.Name("Distance")
    @Config.Comment({"Maximum shot distance."})
    public float distance = 96.0F;

    @Config.RequiresMcRestart
    @Config.Name("Spread")
    @Config.Comment({"Maximum spread."})
    public double spread = 30;
}
