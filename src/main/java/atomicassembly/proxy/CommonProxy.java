package atomicassembly.proxy;

import atomicassembly.AtomicAssembly;
import atomicassembly.AtomicAssemblyBlocks;
import atomicassembly.block.BlockSubatomicParticleExtractor;
import atomicassembly.tile.TileSubatomicParticleExtractor;
import atomicassembly.tmp.TestingTileBlock;
import com.sun.jna.platform.unix.X11;
import liblynx.api.proxyregistry.TileBlockNode;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy extends liblynx.api.proxy.CommonProxy {
    public void preInit(FMLPreInitializationEvent e) {
        AtomicAssembly.initProxyNodeGraph();
        AtomicAssembly.PROXYNODEGRAPH.addBlock(new TestingTileBlock(AtomicAssemblyBlocks.SUBATOMIC_PATICLE_EXTRACTOR, new TileSubatomicParticleExtractor()));

        AtomicAssembly.PROXYNODEGRAPH.commonPreInit();
        FMLLog.info("CommonProxy called Kappa");
    }

    public void init(FMLInitializationEvent e) {
        AtomicAssembly.PROXYNODEGRAPH.commmonInit();
    }

    public void postInit(FMLPostInitializationEvent e) {

    }
}
