package atomicassembly;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;

@Mod(modid = AtomicAssembly.ID, version = AtomicAssembly.VERSION, dependencies = AtomicAssembly.DEPENDENCIES, guiFactory = AtomicAssembly.GUI_FACTORY)
public class AtomicAssembly {

    public static final String ID = "${modid}";
    public static final String VERSION = "${version}";
    public static final String DEPENDENCIES = "required-after:Forge@[12.18.1.2088,);required-after:mcmultipart@[1.2.1,);";
    public static final String GUI_FACTORY = "";

    @Instance
    public static AtomicAssembly INSTANCE;


}
