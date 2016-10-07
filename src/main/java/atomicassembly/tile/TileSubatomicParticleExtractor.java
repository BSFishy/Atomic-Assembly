package atomicassembly.tile;

import atomicassembly.AtomicAssembly;
import atomicassembly.AtomicAssemblyConfig;
import atomicassembly.AtomicAssemblyItems;
import atomicassembly.api.periodictable.Element;
import atomicassembly.items.ISubatomicParticle;
import liblynx.api.inventory.IItemValidator;
import liblynx.api.inventory.ItemHandlerBasic;
import liblynx.api.item.CompareUtils;
import liblynx.api.tile.TileBase;
import liblynx.api.tile.data.ITileDataProducer;
import liblynx.api.tile.data.TileDataParameter;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.CombinedInvWrapper;

public class TileSubatomicParticleExtractor extends TileBase {

    public static final TileDataParameter<Integer> DURATION = new TileDataParameter<>(DataSerializers.VARINT, 0, new ITileDataProducer<Integer, TileEntity>() {
        @Override
        public Integer getValue(TileEntity tileEntity) {
            return AtomicAssemblyConfig.SUBATOMIC_PARTICLE_EXTRACTOR_DURATION * 20;
        }
    });

    public static final TileDataParameter<Integer> PROGRESS = new TileDataParameter<>(DataSerializers.VARINT, 0, new ITileDataProducer<Integer, TileSubatomicParticleExtractor>() {
        @Override
        public Integer getValue(TileSubatomicParticleExtractor tile) {
            return tile.progress;
        }
    });

    public static final TileDataParameter<Boolean> WORKING = new TileDataParameter<>(DataSerializers.BOOLEAN, false, new ITileDataProducer<Boolean, TileSubatomicParticleExtractor>() {
        @Override
        public Boolean getValue(TileSubatomicParticleExtractor tileEntity) {
            return tileEntity.working;
        }
    });

    private static final String NBT_WORKING = "Working";
    private static final String NBT_PROGRESS = "Progress";

    //private ItemStack[] items = new ItemStack[4];
    private ItemHandlerBasic input = new ItemHandlerBasic(1, this, (IItemValidator) itemStack -> true);
    private ItemHandlerBasic output = new ItemHandlerBasic(3, this, (IItemValidator) itemStack -> itemStack.getItem() instanceof ISubatomicParticle);

    private Element processing;

    private boolean working = false;
    private int progress = 0;

    @Override
    public void update() {
        if(worldObj.isRemote) {
            if (input.getStackInSlot(0) == null) {
                stop();
            } else {
                ItemStack item = input.getStackInSlot(0);
                if (!AtomicAssembly.ELEMENTREGISTRY.containsElement(item)) {
                    stop();
                } else if (processing == null || !CompareUtils.compareStack(item, processing.getItem(), 0)) {
                    processing = AtomicAssembly.ELEMENTREGISTRY.getElement(item);
                    progress = 0;
                    working = true;

                    markDirty();
                } else if (working) {
                    progress += 1;

                    //FMLLog.info(DURATION.getValue() + " " + PROGRESS.getValue() + " " + WORKING.getValue());

                    if (progress >= getDuration()) {
                        if (output.getStackInSlot(0) != null) {
                            output.getStackInSlot(0).stackSize += processing.getProtons();
                        } else if (output.getStackInSlot(0) == null) {
                            output.setStackInSlot(0, new ItemStack(AtomicAssemblyItems.PROTON, processing.getProtons()));
                        }

                        if (output.getStackInSlot(1) != null) {
                            output.getStackInSlot(1).stackSize += processing.getNeutrons();
                        } else if (output.getStackInSlot(1) == null) {
                            output.setStackInSlot(1, new ItemStack(AtomicAssemblyItems.NEUTRON, processing.getNeutrons()));
                        }

                        if (output.getStackInSlot(2) != null) {
                            output.getStackInSlot(2).stackSize += processing.getElectrons();
                        } else if (output.getStackInSlot(2) == null) {
                            output.setStackInSlot(2, new ItemStack(AtomicAssemblyItems.ELECTRON, processing.getElectrons()));
                        }

                        input.extractItem(0, 1, false);

                        processing = null;
                        progress = 0;

                        markDirty();
                    }
                }
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

    public int getDuration(){
        return AtomicAssemblyConfig.SUBATOMIC_PARTICLE_EXTRACTOR_DURATION * 20;
    }

    public int getProgress(){
        return progress;
    }

    public boolean isWorking(){
        return working;
    }

    @Override
    public IItemHandler getDrops(){
        return new CombinedInvWrapper(input, output);
    }
}
