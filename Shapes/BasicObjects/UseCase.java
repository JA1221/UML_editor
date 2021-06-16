package Shapes.BasicObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class UseCase extends BasicObjects{
    private final int DefaultWidth = 100;
    private final int DefaultHeight = 60;

    public UseCase(int X, int Y) {
        super(X, Y);
        setSize(DefaultWidth, DefaultHeight);
    }

    public UseCase(Point p) {
        super(p.x, p.y);
        setSize(DefaultWidth, DefaultHeight);
    }

    @Override
    public boolean isInside(Point p) {
        return isInOval(p, new Point(getX() + DefaultWidth / 2, getY() + DefaultHeight / 2));
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(X, Y, DefaultWidth, DefaultHeight);

        g.setColor(Color.BLACK);
        g.drawOval(X, Y, DefaultWidth, DefaultHeight);

        g.drawString(shapeName, getX() + (getWidth() - shapeName.length() * 7) / 2, getY() + getHeight() / 2 + 5);

        drawPoints(g);
    }

    private boolean isInOval(Point point, Point centerPoint) {
        double v = Math.pow(centerPoint.x - point.x, 2) / Math.pow(DefaultWidth / 2, 2) + Math.pow(centerPoint.y - point.y, 2) / Math.pow(DefaultHeight / 2, 2);
        return v < 1;
    }
}
