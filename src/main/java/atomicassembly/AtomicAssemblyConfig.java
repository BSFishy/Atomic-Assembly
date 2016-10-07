package atomicassembly;

import net.minecraftforge.common.config.Configuration;

public class AtomicAssemblyConfig {

    public static int SUBATOMIC_PARTICLE_EXTRACTOR_DURATION;

    public static void init(Configuration config){
        SUBATOMIC_PARTICLE_EXTRACTOR_DURATION = config.getInt("subatomic_particle_extractor_duration", "subatomic_particle_extractor", 100, 1, Integer.MAX_VALUE, "The duration it takes, in seconds, for the Subatomic Particle Extractor to extract the particles");
    }
}
