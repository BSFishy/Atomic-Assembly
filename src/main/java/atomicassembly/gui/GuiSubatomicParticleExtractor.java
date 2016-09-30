package atomicassembly.gui;

import atomicassembly.container.ContainerSubatomicParticleExtractor;
import atomicassembly.tile.TileSubatomicParticleExtractor;
import liblynx.api.gui.GuiBase;

public class GuiSubatomicParticleExtractor extends GuiBase {
    public GuiSubatomicParticleExtractor(ContainerSubatomicParticleExtractor container, TileSubatomicParticleExtractor tile) {
        super(container, 211, 171);
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
    }

    @Override
    public void drawForeground(int i, int i1) {

    }
}
