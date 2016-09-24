package atomicassembly.tmp;

import liblynx.api.proxyregistry.RegistryNodeGraph;
import net.minecraftforge.fml.common.FMLLog;

public class TestingNodeGraph extends RegistryNodeGraph {

    @Override
    public void commonPreInit(){
        super.commonPreInit();
        FMLLog.info("Common pre init was called");
    }
}
