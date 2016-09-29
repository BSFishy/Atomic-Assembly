package atomicassembly;

import atomicassembly.block.BlockSubatomicParticleExtractor;
import atomicassembly.tile.TileSubatomicParticleExtractor;
import liblynx.api.proxyregistry.TileBlockNode;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public class AtomicAssemblyBlocks {

    public static BlockSubatomicParticleExtractor SUBATOMIC_PARTICLE_EXTRACTOR = new BlockSubatomicParticleExtractor();
    public static TileBlockNode SUBATOMIC_PARTICLE_EXTRACTOR_NODE = new TileBlockNode(SUBATOMIC_PARTICLE_EXTRACTOR, new TileSubatomicParticleExtractor(), 0, new ModelResourceLocation("atomicassembly:subatomic_particle_extractor", "inventory"));

}
