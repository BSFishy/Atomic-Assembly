package atomicassembly.gui;

import atomicassembly.container.ContainerSubatomicParticleExtractor;
import atomicassembly.tile.TileSubatomicParticleExtractor;
import liblynx.api.gui.GuiBase;

public class GuiSubatomicParticleExtractor extends GuiBase {
    private TileSubatomicParticleExtractor tile;

    public GuiSubatomicParticleExtractor(ContainerSubatomicParticleExtractor container, TileSubatomicParticleExtractor tile) {
        super(container, 176, 171);

        this.tile = tile;
    }

    @Override
    public void init(int i, int i1) {

    }

    @Override
    public void update(int i, int i1) {

    }

    @Override
    public void drawBackground(int x, int y, int mouseX, int mouseY) {
        bindTexture("gui/subatomic_particle_extractor.png");

        drawTexture(x, y, 0, 0, width, height);

        if(tile.isWorking()){
            drawTexture(x + 83, y + 38, 179, 0, 22, getProgressScaled(15));
        }
    }

    @Override
    public void drawForeground(int mouseX, int mouseY) {
        drawString(7, 7, t("gui.atomicassembly:subatomic_particle_extractor"));
        drawString(7, 77, t("container.inventory"));

        if(inBounds(83, 38, 22, 15, mouseX, mouseY) && tile.isWorking()) {
            drawTooltip(mouseX, mouseY, getProgressScaled(100) + "%");
        }
    }

    private int getProgressScaled(int scale){
        float progress = tile.getProgress();
        float duration = tile.getDuration();

        if (progress > duration){
            return scale;
        }

        return (int) (progress / duration * (float) scale);
    }
}
