package v0id.aw.common.config.tool;

import net.minecraftforge.common.config.Config;

public class AetheriumStaffCatergory {
    @Config.RequiresMcRestart
    @Config.Name("Ember Cost")
    @Config.Comment({"Ember used up by each shot."})
    public double cost = 50;

    @Config.RequiresMcRestart
    @Config.Name("Charge")
    @Config.Comment({"Time in ticks to fully charge."})
    public double charge = 60;

    @Config.RequiresMcRestart
    @Config.Name("Cooldown")
    @Config.Comment({"Cooldown in ticks between each shot."})
    public int cooldown = 1;

    @Config.RequiresMcRestart
    @Config.Name("Damage")
    @Config.Comment({"Damage dealt by one shot."})
    public float damage = 34.0F;

    @Config.RequiresMcRestart
    @Config.Name("Size")
    @Config.Comment({"Size of the projectile."})
    public float size = 17.0F;

    @Config.RequiresMcRestart
    @Config.Name("AOE Size")
    @Config.Comment({"Area of Effect on impact."})
    public float aoe = 2.125F;

    @Config.RequiresMcRestart
    @Config.Name("Lifetime")
    @Config.Comment({"Lifetime in ticks of projectile."})
    public int lifetime = 160;
}
