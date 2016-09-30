package atomicassembly.items;

import liblynx.api.item.ItemBase;

public class ItemElectron extends ItemBase implements ISubatomicParticle {
    public ItemElectron() {
        super("electron");
    }

    @Override
    public int getCharge() {
        return -1;
    }
}
