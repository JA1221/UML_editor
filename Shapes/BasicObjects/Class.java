package Shapes.BasicObjects;

import java.awt.Graphics;
import java.awt.Point;

public class Class extends BasicObjects{
    private final int DefaultWidth = 80;
    private final int DefaultHeight = 130;

    public Class(int X, int Y) {
        super(X, Y);
        SetSize(X, Y);
    }

    public Class(Point p) {
        super(p.x, p.y);
        SetSize(p.x, p.y);
    } 

    @Override
    public void Draw(Graphics g) {
        g.drawRect(X, Y, DefaultWidth, DefaultHeight / 3);
        g.drawRect(X, Y + DefaultHeight / 3, DefaultWidth, DefaultHeight / 3);
        g.drawRect(X, Y + 2 * DefaultHeight / 3, DefaultWidth, DefaultHeight / 3);

        DrawPoints(g);
    }

}
