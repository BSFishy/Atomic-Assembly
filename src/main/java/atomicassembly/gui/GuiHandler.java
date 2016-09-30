package atomicassembly.gui;

import atomicassembly.AtomicAssemblyGui;
import atomicassembly.container.ContainerSubatomicParticleExtractor;
import atomicassembly.tile.TileSubatomicParticleExtractor;
import liblynx.api.gui.GuiBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

    public static Container getContainer(int id, EntityPlayer player, TileEntity tile) {
        switch (id) {
            case AtomicAssemblyGui.SUBATOMIC_PARTICLE_EXTRACTOR:
                return new ContainerSubatomicParticleExtractor((TileSubatomicParticleExtractor) tile, player);
            default:
                return null;
        }
    }

    public static GuiBase getGui(int id, EntityPlayer player, TileEntity tile){
        switch (id) {
            case AtomicAssemblyGui.SUBATOMIC_PARTICLE_EXTRACTOR:
                return new GuiSubatomicParticleExtractor((ContainerSubatomicParticleExtractor) getContainer(id, player, tile), (TileSubatomicParticleExtractor) tile);
            default:
                return null;
        }
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return getContainer(ID, player, world.getTileEntity(new BlockPos(x, y, z)));
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return getGui(ID, player, world.getTileEntity(new BlockPos(x, y, z)));
    }
}
