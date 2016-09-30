package atomicassembly.container;

import atomicassembly.tile.TileSubatomicParticleExtractor;
import liblynx.api.container.ContainerBase;
import liblynx.api.container.slot.SlotOutput;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerSubatomicParticleExtractor extends ContainerBase {
    public ContainerSubatomicParticleExtractor(TileSubatomicParticleExtractor tile, EntityPlayer player) {
        super(tile, player);

        int x = 127, y = 20;

        addSlotToContainer(new SlotItemHandler(tile.getInput(), 0, 44, 38));

        for (int i = 0; i < 3; i++) {
            addSlotToContainer(new SlotOutput(tile.getOutput(), i, x, y));

            y += 18;
        }

        addPlayerInventory(8, 89);
    }
}
