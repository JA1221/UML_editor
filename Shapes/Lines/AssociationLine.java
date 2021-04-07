package Shapes.Lines;

import java.awt.Graphics;

import Associate.Port;

public class AssociationLine extends Line {
    private int _headX[] = {-10, 0, -10};
    private int _headY[] = {10, 0, -10};

    public AssociationLine(Port startPort, Port endPort) {
        super(startPort, endPort);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        drawLineHead(g, _headX, _headY, _headX.length);
    }
}
