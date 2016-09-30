package atomicassembly.items;

import liblynx.api.item.ItemBase;

public class ItemNeutron extends ItemBase implements ISubatomicParticle {
    public ItemNeutron() {
        super("neutron");
    }

    @Override
    public int getCharge() {
        return 0;
    }
}
