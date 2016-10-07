package atomicassembly.api.periodictable;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.FMLLog;

import java.util.Objects;

public abstract class Element {

    // LOCATION
    public int period;
    public int family;

    // SETUP
    public int number;
    public String atomicName;
    public String fullName;
    public int mass;
    public boolean stableElement;

    // EXTRA INFORMATION
    public int valenceElectrons;
    public int electrons;
    public int protons;
    public int neutrons;
    public ItemStack item;

    public Element() {}

    public Element(int number){
        this.number      = number;
    }

    public Element(int number, String atomicName){
        this.number         = number;
        this.atomicName     = atomicName;
    }

    public Element(int number, String atomicName, String fullName){
        this.number         = number;
        this.atomicName     = atomicName;
        this.fullName       = fullName;
    }

    public Element(int number, String atomicName, String fullName, int mass){
        this.number         = number;
        this.atomicName     = atomicName;
        this.fullName       = fullName;
        this.mass           = mass;
    }

    public Element(int number, String atomicName, String fullName, int mass, boolean stableElement){
        this.number            = number;
        this.atomicName        = atomicName;
        this.fullName          = fullName;
        this.mass              = mass;
        this.stableElement     = stableElement;

        if(stableElement)
            setupExtraInformation();
    }

    public Element(int number, String atomicName, String fullName, int mass, boolean stableElement, ItemStack item){
        this.number            = number;
        this.atomicName        = atomicName;
        this.fullName          = fullName;
        this.mass              = mass;
        this.stableElement     = stableElement;

        this.item              = item;

        if(stableElement) {
            setupExtraInformation();
        }
    }

    public void setupExtraInformation(){
        if(stableElement){
            this.protons              = number;
            this.electrons            = number;
            this.neutrons             = mass - number;

            //this.period = getPeriod(electrons);
            setupPeriodAndGroup();
        }else{
            throw new IllegalStateException("This is not a stable element, meaning that it cannot find the extra information.");
        }
    }

    private void setupPeriodAndGroup(){
        int i = 1, tmpElectrons = electrons;
        while (true){
            int maxElectrons = (i ^ 2) * 2;
            if(tmpElectrons < maxElectrons){
                this.period = i;
                this.valenceElectrons = tmpElectrons;
                this.family = ((i == 2) ? 6 : this.valenceElectrons);
                break;
            } else {
                tmpElectrons -= maxElectrons;
            }

            i++;
        }
    }

    public int getPeriod(){
        return period;
    }

    public void setPeriod(int period){
        this.period     = period;
    }

    public int getFamily(){
        return family;
    }

    public void setFamily(int family){
        this.family     = family;
    }

    public int getAtomicNumber(){
        return number;
    }

    public void setAtomicNumber(int number){
        this.number     = number;
    }

    public String getAtomicName() {
        return atomicName;
    }

    public void setAtomicName(String atomicName){
        this.atomicName = atomicName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName){
        this.fullName = fullName;
    }

    public int getMass(){
        return mass;
    }

    public void setMass(int mass){
        this.mass = mass;
    }

    public boolean getStableValue(){
        return stableElement;
    }

    public void setStableValue(boolean stableElement){
        this.stableElement = stableElement;
    }

    public int getValenceElectrons() {
        return valenceElectrons;
    }

    public void setValenceElectrons(int valenceElectrons){
        this.valenceElectrons = valenceElectrons;
    }

    public int getElectrons(){
        return electrons;
    }

    public void setElectrons(int electrons){
        this.electrons = electrons;
    }

    public int getProtons(){
        return protons;
    }

    public void setProtons(int protons){
        this.protons = protons;
    }

    public int getNeutrons(){
        return neutrons;
    }

    public void setNeutrons(int neutrons){
        this.neutrons = neutrons;
    }

    public ItemStack getItem(){
        return item;
    }

    public void setItem(ItemStack item){
        this.item = item;
    }

    public boolean hasItem(){
        return item != null;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Element){
            Element e = (Element) obj;
            if(e.getPeriod() == period && e.getFamily() == family && e.getAtomicNumber() == number && Objects.equals(e.getAtomicName(), atomicName) && Objects.equals(e.getFullName(), fullName) && e.getMass() == mass && e.getStableValue() == stableElement && e.getValenceElectrons() == valenceElectrons && e.getElectrons() == electrons && e.getProtons() == protons && e.getNeutrons() == neutrons && e.getItem() == item){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        return "period=" + getPeriod() + ",family=" + getFamily() + ",atomicNumber=" + number + ",atomicName=" + getAtomicName() + ",fullName=" + getFullName() + ",mass=" + getMass() + ",stableValue=" + getStableValue() + ",valenceElectrons=" + getValenceElectrons() + ",electrons=" + getElectrons() + ",protons=" + getProtons() + ",neutrons=" + getNeutrons() + ",item=" + getItem().toString();
    }
}
