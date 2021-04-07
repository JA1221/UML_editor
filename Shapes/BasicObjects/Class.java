package Shapes.BasicObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Class extends BasicObjects{
    private final int DefaultWidth = 80;
    private final int DefaultHeight = 120;

    public Class(int X, int Y) {
        super(X, Y);
        SetSize(DefaultWidth, DefaultHeight);
    }

    public Class(Point p) {
        super(p.x, p.y);
        SetSize(DefaultWidth, DefaultHeight);
    } 

    @Override
    public void Draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(X, Y, DefaultWidth, DefaultHeight);

        g.setColor(Color.BLACK);
        g.drawRect(X, Y, DefaultWidth, DefaultHeight / 3);
        g.drawRect(X, Y + DefaultHeight / 3, DefaultWidth, DefaultHeight / 3);
        g.drawRect(X, Y + 2 * DefaultHeight / 3, DefaultWidth, DefaultHeight / 3);

        g.drawString(shapeName, getX() + (getWidth() - shapeName.length() * 7) / 2, getY() + 25);      

        DrawPoints(g);
    }

}
