package atomicassembly.proxy;

import atomicassembly.AtomicAssembly;
import atomicassembly.AtomicAssemblyBlocks;
import atomicassembly.AtomicAssemblyItems;
import atomicassembly.tile.TileSubatomicParticleExtractor;
import liblynx.api.proxyregistry.ItemNode;
import liblynx.api.proxyregistry.TileBlockNode;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy extends liblynx.api.proxy.CommonProxy {

    //@Override
    public void preInit(FMLPreInitializationEvent e) {
        AtomicAssembly.initProxyNodeGraph();
        // BLOCKS
        AtomicAssembly.PROXYNODEGRAPH.addBlock(AtomicAssemblyBlocks.SUBATOMIC_PARTICLE_EXTRACTOR_NODE);

        // ITEMS
        AtomicAssembly.PROXYNODEGRAPH.addItem(AtomicAssemblyItems.PROTON_NODE);
        AtomicAssembly.PROXYNODEGRAPH.addItem(AtomicAssemblyItems.NEUTRON_NODE);
        AtomicAssembly.PROXYNODEGRAPH.addItem(AtomicAssemblyItems.ELECTRON_NODE);

        AtomicAssembly.PROXYNODEGRAPH.commonPreInit();
    }

    //@Override
    public void init(FMLInitializationEvent e) {
        AtomicAssembly.initProxyNodeGraph();
        AtomicAssembly.PROXYNODEGRAPH.commmonInit();
    }

    public void postInit(FMLPostInitializationEvent e) {

    }
}
