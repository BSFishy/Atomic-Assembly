package atomicassembly.container;

import atomicassembly.tile.TileSubatomicParticleExtractor;
import liblynx.api.container.ContainerBase;
import liblynx.api.container.slot.SlotOutput;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerSubatomicParticleExtractor extends ContainerBase {
    public ContainerSubatomicParticleExtractor(TileSubatomicParticleExtractor tile, EntityPlayer player) {
        super(tile, player);

        // Input slot
        addSlotToContainer(new SlotItemHandler(tile.getInput(), 0, 44, 38));

        int x = 127, y = 20;

        // Output slots
        for (int i = 0; i < 3; i++) {
            addSlotToContainer(new SlotOutput(tile.getOutput(), i, x, y));

            y += 18;
        }

        addPlayerInventory(8, 89);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int index) {

        ItemStack stack = null;

        Slot slot = getSlot(index);

        if (slot != null && slot.getHasStack()) {
            stack = slot.getStack();

            if (index < 4) {
                if (!mergeItemStack(stack, 4 + 4, inventorySlots.size(), false)) {
                    return null;
                }
            } else if (index < 4 + 4) {
                if (!mergeItemStack(stack, 4 + 4, inventorySlots.size(), false)) {
                    return null;
                }
            } else {
                if(!mergeItemStack(stack, 4, 4 + 4, false)){
                    if (!mergeItemStack(stack, 0, 1, false)) { // 0 - 3 because we can't shift click to output slot
                        return null;
                    }
                }
            }

            if (stack.stackSize == 0) {
                slot.putStack(null);
            } else {
                slot.onSlotChanged();
            }
        }

        return stack;
    }
}
