package v0id.aw.common.config;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import v0id.aw.lib.AWConsts;

@Mod.EventBusSubscriber(modid = AWConsts.MODID)
public class ConfigMain {

    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(AWConsts.MODID)) {
            ConfigManager.sync(AWConsts.MODID, Config.Type.INSTANCE);
        }
    }
}
