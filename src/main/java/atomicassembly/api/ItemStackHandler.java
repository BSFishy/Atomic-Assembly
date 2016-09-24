package atomicassembly.api;

import liblynx.api.inventory.IItemValidator;
import liblynx.api.inventory.ItemHandlerBasic;
import net.minecraft.tileentity.TileEntity;

public class ItemStackHandler extends ItemHandlerBasic {
    public ItemStackHandler(int size, TileEntity tile, IItemValidator... validators) {
        super(size, tile, validators);
    }
}
