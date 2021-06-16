package Shapes.BasicObjects;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;

public class SelectedArea extends BasicObjects{
    public SelectedArea(int x, int y) {
        super(x, y);
        setSize(getWidth(), getHeight());
    }

    public SelectedArea(Point p) {
        this(p.x, p.y);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(new Color(255, 255, 255, 50));
        g.fillRect(X, Y, getWidth(), getHeight());
        g.setColor(Color.BLACK);
        g.drawRect(X, Y, getWidth(), getHeight());
    }
}
