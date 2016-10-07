package atomicassembly;

import atomicassembly.api.periodictable.ElementRegistery;
import atomicassembly.proxy.CommonProxy;
import liblynx.api.ModBase;
import liblynx.api.ModRegistry;
import liblynx.api.proxyregistry.RegistryNodeGraph;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = AtomicAssembly.ID, version = AtomicAssembly.VERSION, dependencies = AtomicAssembly.DEPENDENCIES, guiFactory = AtomicAssembly.GUI_FACTORY)
public class AtomicAssembly extends ModBase {

    public static final String ID = "atomicassembly";
    public static final String VERSION = "0.1";
    public static final String DEPENDENCIES = "required-after:Forge@[12.18.1.2094,);required-after:liblynx;";
    public static final String GUI_FACTORY = "";

    @Instance
    public static AtomicAssembly INSTANCE;
    public static RegistryNodeGraph PROXYNODEGRAPH;

    @SidedProxy(clientSide = "atomicassembly.proxy.ClientSideProxy", serverSide = "atomicassembly.proxy.ServerSideProxy")
    public static CommonProxy PROXY;

    public static Configuration CONFIG;

    public static ElementRegistery ELEMENTREGISTRY = new ElementRegistery();

    @Override
    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        ModRegistry.setMODID(ID);
        ModRegistry.setMOD(INSTANCE);
        ModRegistry.setPROXY(PROXY);

        CONFIG = new Configuration(e.getSuggestedConfigurationFile());
        AtomicAssemblyConfig.init(CONFIG);

        if(CONFIG.hasChanged())
            CONFIG.save();

        ELEMENTREGISTRY.addDefaults();

        PROXY.preInit(e);
    }

    @Override
    @EventHandler
    public void init(FMLInitializationEvent e) {
        PROXY.init(e);
    }

    @Override
    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        PROXY.postInit(e);
    }

    public static void initProxyNodeGraph(){
        if(PROXYNODEGRAPH == null)
            PROXYNODEGRAPH = new RegistryNodeGraph();
    }
}
