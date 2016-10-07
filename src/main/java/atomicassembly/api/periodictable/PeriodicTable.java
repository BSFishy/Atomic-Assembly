package atomicassembly.api.periodictable;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class PeriodicTable {

    // Ae
    public static class Air extends Element {
        public Air(){
            super(1, "Ae", "Air", 2, true);
        }
    }

    // Lu
    public static class Dirt extends Element {
        public Dirt(){
            super(2, "Lu", "Dirt", 4, true, new ItemStack(Blocks.DIRT));
        }
    }

    // ION of Dirt
    // Gl
    public static class Gravel extends Element {
        public Gravel(){
            super(2, "Gl", "Gravel", 4, false, new ItemStack(Blocks.GRAVEL));
            setPeriod(new Dirt().getPeriod());
            setFamily(new Dirt().getFamily());
            this.protons              = number;

            // ION of CobbleStone
            this.electrons            = number + 1;
            this.neutrons             = mass - number;
        }
    }

    // ION of Sand
    // Ha
    public static class Sand extends Element {
        public Sand(){
            super(2, "Ha", "Sand", 5, false, new ItemStack(Blocks.SAND));
            setPeriod(new Gravel().getPeriod());
            setFamily(new Gravel().getFamily());
            this.protons              = number;

            // ION of CobbleStone
            this.electrons            = number + 2;
            this.neutrons             = mass - number;
        }
    }

    // ION of Sand
    // An
    public static class SoulSand extends Element {
        public SoulSand(){
            super(2, "", "SoulSand", 6, false, new ItemStack(Blocks.SOUL_SAND));
            setPeriod(new Sand().getPeriod());
            setFamily(new Sand().getFamily());
            this.protons              = number;

            // ION of CobbleStone
            this.electrons            = number + 3;
            this.neutrons             = mass - number;
        }
    }

    // Lt
    public static class CobbleStone extends Element {
        public CobbleStone(){
            super(3, "Lt", "Cobblestone", 6, true, new ItemStack(Blocks.COBBLESTONE));
        }
    }

    // ION of CobbleStone
    // Lp
    public static class Stone extends Element {
        public Stone(){
            super(3, "Lp", "Stone", 7, false, new ItemStack(Blocks.STONE));
            setPeriod(new CobbleStone().getPeriod());
            setFamily(new CobbleStone().getFamily());
            this.protons              = number;

            this.electrons            = number + 1;
            this.neutrons             = mass - number;
        }
    }

    // ION of Stone
    // Ne
    public static class NetherRack extends Element {
        public NetherRack(){
            super(3, "Ne", "NetherRack", 8, false, new ItemStack(Blocks.NETHERRACK));
            setPeriod(new CobbleStone().getPeriod());
            setFamily(new CobbleStone().getFamily());
            this.protons              = number;

            this.electrons            = number + 2;
            this.neutrons             = mass - number;
        }
    }

    // ION of NetherRack
    // Lm
    public static class GlowStone extends Element {
        public GlowStone(){
            super(3, "Lm", "GlowStone", 9, false, new ItemStack(Blocks.GLOWSTONE));
            setPeriod(new CobbleStone().getPeriod());
            setFamily(new CobbleStone().getFamily());
            this.protons              = number;

            this.electrons            = number + 3;
            this.neutrons             = mass - number;
        }
    }
}
