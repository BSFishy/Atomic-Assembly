package atomicassembly.tmp;

import liblynx.api.block.BlockBase;
import liblynx.api.proxyregistry.TileBlockNode;
import liblynx.api.tile.TileBase;
import net.minecraftforge.fml.common.FMLLog;

public class TestingTileBlock extends TileBlockNode {

    public TestingTileBlock(BlockBase block, TileBase tile){
        super(block, tile);
    }

    @Override
    public void commonPreInit(){
        FMLLog.info(getBlock().name + " is being pre-inited");
        super.commonPreInit();
        FMLLog.info(getBlock().name + " is being pre-inited");
    }

    @Override
    public void commonInit(){
        FMLLog.info(getBlock().name + " is being inited");
        super.commonInit();
        FMLLog.info(getBlock().name + " is being inited");
    }
}
