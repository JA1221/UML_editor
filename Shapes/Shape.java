package Shapes;

import java.awt.Graphics;
import java.awt.Point;

public abstract class Shape {
    protected int X, Y;

    private int _width, _height;
    private boolean _isSelected = false;
    private int _depth = 0;

    public Shape(){
        this(0, 0, 0, 0);
    }

    public Shape(int X, int Y) {
        this(X, Y, 0, 0);
    }

    public Shape(int X, int Y, int Width, int Height) {
        this.X = X;
        this.Y = Y;
        _width = Width;
        _height = Height;
        _isSelected = false;
    }

    public void SetSize(int Width, int Height) {
        _width = Width;
        _height = Height;
    }

    public void SetLocation(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }

    public void Move(int offsetX, int offsetY) {
        X += offsetX;
        Y += offsetY;
    }
   
    public boolean IsInside(Point p) {
        int x = p.x;
        int y = p.y;

        return (x > X) & (x < X + _width) & (y > Y) && (y < Y + _height);
    }

    public abstract void Draw(Graphics g);
}
