package atomicassembly.block;

import atomicassembly.AtomicAssembly;
import atomicassembly.tile.TileSubatomicParticleExtractor;
import liblynx.api.block.BlockBase;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockSubatomicParticleExtractor extends BlockBase {
    public BlockSubatomicParticleExtractor() {
        super("subatomic_particle_extractor");
    }

    //@Override
    //public TileEntity createTileEntity(World world, IBlockState state) {
    //    return new TileSubatomicParticleExtractor();
    //}

/*    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            player.openGui(AtomicAssembly.INSTANCE, InfinityStorageGui.DISK_DRIVE, world, pos.getX(), pos.getY(), pos.getZ());
        }

        return true;
    }*/

/*    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
        ((TileSubatomicParticleExtractor) world.getTileEntity(pos)).onBreak();

        super.breakBlock(world, pos, state);
    }*/
}
