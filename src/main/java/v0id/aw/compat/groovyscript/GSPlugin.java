package v0id.aw.compat.groovyscript;

import com.cleanroommc.groovyscript.api.GroovyBlacklist;
import com.cleanroommc.groovyscript.api.GroovyPlugin;
import com.cleanroommc.groovyscript.compat.mods.GroovyContainer;
import com.cleanroommc.groovyscript.compat.mods.GroovyPropertyContainer;
import com.cleanroommc.groovyscript.documentation.linkgenerator.LinkGeneratorHooks;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import groovyjarjarantlr4.v4.runtime.misc.Nullable;
import v0id.aw.lib.AWConsts;

public class GSPlugin implements GroovyPlugin {

    @GroovyBlacklist
    public static GSContainer instance;

    @Override
    public @Nullable GroovyPropertyContainer createGroovyPropertyContainer() {
        GSPlugin.instance = new GSContainer();
        return GSPlugin.instance;
    }

    @Override
    public @NotNull String getModId() {
        return AWConsts.MODID;
    }

    @Override
    public @NotNull String getContainerName() {
        return AWConsts.MODNAME;
    }

    @Override
    public void onCompatLoaded(GroovyContainer<?> container) {
        LinkGeneratorHooks.registerLinkGenerator(new AetherworksLinkGenerator());
    }
}
