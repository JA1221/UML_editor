package Associate;

import java.awt.*;

public class Port {
    private int _x, _y;
    final int SquareLength = 8;

    public Port() {
        this(0, 0);
    }

    public Port(int X, int Y) {
        _x = X;
        _y = Y;
    }
    public Port(Point p) {
        this(p.x, p.y);
    }

    public Point getPoint() {
        return new Point(_x, _y);
    }
    
    public double getDistanceFrom(Point p) {
        return Math.sqrt(Math.pow(_x - p.x, 2) + Math.pow(_y - p.y, 2));
    }

    public void Draw(Graphics g) {
        g.fillRect(_x - SquareLength / 2, _y - SquareLength / 2, SquareLength, SquareLength);
    }

    public void SetLocation(int X, int Y) {
        _x = X;
        _y = Y;
    }

    public void SetLocation(Point p) {
        _x = p.x;
        _y = p.y;
    }

    public void Move(int offsetX, int offsetY) {
        _x += offsetX;
        _y += offsetY;
    }
}
