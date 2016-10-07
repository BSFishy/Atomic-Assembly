package atomicassembly.api.periodictable;

import liblynx.api.item.CompareUtils;
import liblynx.api.registry.Register;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.FMLLog;

public class ElementRegistery extends Register<Element> {

    @Override
    public void addDefaults() {
        addItem(new PeriodicTable.Air());
        addItem(new PeriodicTable.Dirt());
        addItem(new PeriodicTable.Gravel());
        addItem(new PeriodicTable.Sand());
        addItem(new PeriodicTable.SoulSand());
        addItem(new PeriodicTable.CobbleStone());
        addItem(new PeriodicTable.Stone());
        addItem(new PeriodicTable.NetherRack());
        addItem(new PeriodicTable.GlowStone());
    }

    @Override
    public void addItem(Element e){
        items.add(e);
    }

    public Element getElement(Element element) {
        for (Element e : getItems()) {
            if (e.equals(element)) {
                return e;
            }
        }
        return null;
    }

    public boolean containsElement(ItemStack item) {
        for (Element e : getItems()) {
            if(e.hasItem()) {
                if (CompareUtils.compareStack(e.getItem(), item, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Element getElement(ItemStack item) {
        for (Element e : getItems()) {
            if (CompareUtils.compareStack(e.getItem(), item, 0)) {
                return e;
            }
        }
        return null;
    }
}
