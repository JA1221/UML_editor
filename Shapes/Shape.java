package Shapes;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import Associate.Port;

public abstract class Shape {
    protected int X, Y;
    protected String shapeName;

    private int _width, _height;
    private boolean _isSelected = false;
    protected List<Port> ports;
    protected List<Shape> shapes;

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
        shapeName = "";
        shapes = new ArrayList<Shape>();
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

    public int getWidth() {
        return _width;
    }

    public int getHeight() {
        return _height;
    }

    public int getX(){
        return X;
    }

    public int getY(){
        return Y;
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    public void setSelected(boolean isSelected) {
        _isSelected = isSelected;
    }

    public boolean isSelected() {
        return _isSelected;
    }

    public void setShapeName(String name) {
        shapeName = name;
    }

    public abstract Port getNearestPort(Point p);

    public abstract void Draw(Graphics g);
}
