package atomicassembly.tile;

import liblynx.api.inventory.IItemValidator;
import liblynx.api.inventory.ItemHandlerBasic;
import liblynx.api.tile.TileBase;
import net.minecraft.nbt.NBTTagCompound;

public class TileSubatomicParticleExtractor extends TileBase {

    //private ItemStack[] items = new ItemStack[4];
    private ItemHandlerBasic input = new ItemHandlerBasic(1, this, (IItemValidator) itemStack -> true);
    private ItemHandlerBasic output = new ItemHandlerBasic(3, this, (IItemValidator) itemStack -> true);

/*    public void onBreak(){
        //Arrays.stream(items).filter(i -> i != null && i.hasTagCompound()).forEach(i -> i.writeToNBT(i.getTagCompound()));
    }*/

    @Override
    public NBTTagCompound write(NBTTagCompound tag) {
        super.write(tag);

        writeItems(input, 0, tag);

        writeItems(output, 1, tag);

        return tag;
    }

    @Override
    public void read(NBTTagCompound tag) {
        super.read(tag);

        readItems(input, 0 ,tag);

        readItems(output, 1, tag);
    }
}
