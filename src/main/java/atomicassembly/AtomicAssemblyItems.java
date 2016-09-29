package atomicassembly;

import atomicassembly.items.ItemElectron;
import atomicassembly.items.ItemNeutron;
import atomicassembly.items.ItemProton;
import liblynx.api.proxyregistry.ItemNode;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public class AtomicAssemblyItems {

    public static ItemProton PROTON = new ItemProton();
    public static ItemNode PROTON_NODE = new ItemNode(PROTON, 0, new ModelResourceLocation("atomicassembly:proton"));

    public static ItemNeutron NEUTRON = new ItemNeutron();
    public static ItemNode NEUTRON_NODE = new ItemNode(NEUTRON, 0, new ModelResourceLocation("atomicassembly:neutron"));

    public static ItemElectron ELECTRON = new ItemElectron();
    public static ItemNode ELECTRON_NODE = new ItemNode(ELECTRON, 0, new ModelResourceLocation("atomicassembly:electron"));
}
