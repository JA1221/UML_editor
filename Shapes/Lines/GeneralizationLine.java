package Shapes.Lines;

import java.awt.Graphics;

import Associate.Port;

public class GeneralizationLine extends Line {
    
    public GeneralizationLine(Port startPort, Port endPort) {
        super(startPort, endPort);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);

    }
}
