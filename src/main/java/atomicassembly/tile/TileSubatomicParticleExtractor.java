package atomicassembly.tile;

import atomicassembly.AtomicAssemblyConfig;
import atomicassembly.AtomicAssemblyItems;
import atomicassembly.items.ISubatomicParticle;
import liblynx.api.inventory.IItemValidator;
import liblynx.api.inventory.ItemHandlerBasic;
import liblynx.api.item.CompareUtils;
import liblynx.api.tile.TileBase;
import liblynx.api.tile.data.ITileDataProducer;
import liblynx.api.tile.data.TileDataParameter;
import net.minecraft.block.BlockSand;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.CombinedInvWrapper;

public class TileSubatomicParticleExtractor extends TileBase {

    public static final TileDataParameter<Integer> DURATION = new TileDataParameter<>(DataSerializers.VARINT, 0, tileEntity -> AtomicAssemblyConfig.SUBATOMIC_PARTICLE_EXTRACTOR_DURATION);

    public static final TileDataParameter<Integer> PROGRESS = new TileDataParameter<>(DataSerializers.VARINT, 0, new ITileDataProducer<Integer, TileSubatomicParticleExtractor>() {
        @Override
        public Integer getValue(TileSubatomicParticleExtractor tile) {
            return tile.progress;
        }
    });

    private static final String NBT_WORKING = "Working";
    private static final String NBT_PROGRESS = "Progress";

    //private ItemStack[] items = new ItemStack[4];
    private ItemHandlerBasic input = new ItemHandlerBasic(1, this, (IItemValidator) itemStack -> true);
    private ItemHandlerBasic output = new ItemHandlerBasic(3, this, (IItemValidator) itemStack -> itemStack.getItem() instanceof ISubatomicParticle);

    private boolean working = false;
    private int progress = 0;

    @Override
    public void update() {
        boolean wasWorking = working;

        if(input.getStackInSlot(0) == null){
            stop();
        }else{
            ItemStack compare = new ItemStack(new ItemBlock(new BlockSand()), input.getStackInSlot(0).stackSize);
            //FMLLog.info(input.getStackInSlot(0).toString() + " " + compare.toString());
            //FMLLog.info(input.getStackInSlot(0).toString() + " " + compare);
            //if(input.getStackInSlot(0).isItemEqual(compare)){
            if(CompareUtils.compareStackNoQuantity(input.getStackInSlot(0), compare)){
                output.setStackInSlot(0, new ItemStack(AtomicAssemblyItems.PROTON, 32));
                input.setStackInSlot(0, null);
            }
        }
    }

    public void stop() {
        progress = 0;
        working = false;

        markDirty();
    }

/*    public void onBreak(){
        //Arrays.stream(items).filter(i -> i != null && i.hasTagCompound()).forEach(i -> i.writeToNBT(i.getTagCompound()));
    }*/

    @Override
    public NBTTagCompound write(NBTTagCompound tag) {
        super.write(tag);

        writeItems(input, 0, tag);
        writeItems(output, 1, tag);

        tag.setBoolean(NBT_WORKING, working);
        tag.setInteger(NBT_PROGRESS, progress);

        return tag;
    }

    @Override
    public void read(NBTTagCompound tag) {
        super.read(tag);

        readItems(input, 0 ,tag);
        readItems(output, 1, tag);

        if(tag.hasKey(NBT_WORKING)){
            working = tag.getBoolean(NBT_WORKING);
        }
        if(tag.hasKey(NBT_PROGRESS)){
            progress = tag.getInteger(NBT_PROGRESS);
        }
    }

    public ItemHandlerBasic getInput() {
        return input;
    }

    public ItemHandlerBasic getOutput() {
        return output;
    }

    public boolean isWorking(){
        return working;
    }

    @Override
    public IItemHandler getDrops(){
        return new CombinedInvWrapper(input, output);
    }
}
