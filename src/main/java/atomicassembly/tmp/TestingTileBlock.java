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
        super.commonPreInit();
        FMLLog.info(getBlock().name + " is being pre-inited");
    }

    @Override
    public void commonInit(){
        super.commonInit();
        FMLLog.info(getBlock().name + " is being inited");
    }
}
