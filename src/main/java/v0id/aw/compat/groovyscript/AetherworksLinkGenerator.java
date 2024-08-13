package v0id.aw.compat.groovyscript;

import com.cleanroommc.groovyscript.documentation.linkgenerator.BasicLinkGenerator;
import v0id.aw.lib.AWConsts;

public class AetherworksLinkGenerator extends BasicLinkGenerator {
    @Override
    public String id() {
        return AWConsts.MODID;
    }
    @Override
    protected String domain() {
        return "https://github.com/Ender-Development/Aetherworks-Extended-Life";
    }
}
