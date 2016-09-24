package atomicassembly.proxy;

import atomicassembly.AtomicAssembly;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientSideProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent e) {
        AtomicAssembly.PROXYNODEGRAPH.clientPreInit();
    }

    @Override
    public void init(FMLInitializationEvent e) {
        AtomicAssembly.PROXYNODEGRAPH.clientInit();
    }
}
