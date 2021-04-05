package Shapes.BasicObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class UseCase extends BasicObjects{
    private final int DefaultWidth = 100;
    private final int DefaultHeight = 60;

    public UseCase(int X, int Y) {
        super(X, Y);
        SetSize(X, Y);
    }

    public UseCase(Point p) {
        super(p.x, p.y);
        SetSize(p.x, p.y);
    }

    @Override
    public void Draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(X, Y, DefaultWidth, DefaultHeight);

        g.setColor(Color.BLACK);
        g.drawOval(X, Y, DefaultWidth, DefaultHeight);
    }
}
