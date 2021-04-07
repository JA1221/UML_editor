package Shapes.Lines;

import java.awt.Graphics;

import Associate.Port;

public class CompositionLine extends Line {
    private int _headX[] = {0, -8, -16, -8};
    private int _headY[] = {0, 8, 0, -8};

    public CompositionLine(Port startPort, Port endPort) {
        super(startPort, endPort);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        drawFillHead(g, _headX, _headY, _headX.length);
    }
}
