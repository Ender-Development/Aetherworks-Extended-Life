package v0id.aw.compat.groovyscript;

import com.cleanroommc.groovyscript.compat.mods.GroovyPropertyContainer;

public class GSContainer extends GroovyPropertyContainer {
    public final Anvil anvil = new Anvil();
    public final MetalFormer metalFormer = new MetalFormer();

    public GSContainer() {
        // addProperty(anvil);
        addProperty(metalFormer);
    }
}
