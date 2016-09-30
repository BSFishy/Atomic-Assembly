package atomicassembly.items;

import liblynx.api.item.ItemBase;

public class ItemProton extends ItemBase implements ISubatomicParticle {
    public ItemProton() {
        super("proton");
    }

    @Override
    public int getCharge() {
        return 1;
    }
}
