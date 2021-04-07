package Shapes.Lines;

import java.awt.Graphics;

import Associate.Port;

public class GeneralizationLine extends Line {
    private int _headX[] = {0, -8, -8};
    private int _headY[] = {0, 8, -8};
    
    public GeneralizationLine(Port startPort, Port endPort) {
        super(startPort, endPort);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        drawFillHead(g, _headX, _headY, _headX.length);
    }
}
