package Shapes.BasicObjects;

import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import Associate.Port;
import Shapes.Shape;

public class CompositionObject extends BasicObjects {

    public CompositionObject() {
        shapes = new ArrayList<Shape>();
    }

    public CompositionObject(List<Shape> shapes) {
        this.shapes = shapes;
        updateBorderSize();
    }

    @Override
    public Port getNearestPort(Point p) {
        return null;
    }

    @Override
    public boolean IsInside(Point p) {
        for(Shape shape : shapes) {
            if(shape.IsInside(p))
                return true;
        }

        return false;
    }

    @Override
    public void SetLocation(int x, int y) {
        super.SetLocation(x, y);

        int offsetX = x - X;
        int offsetY = y - Y;

        for(Shape shape : shapes)
            shape.Move(offsetX, offsetY);
    }

    @Override
    public void Move(int offsetX, int offsetY) {
        super.Move(offsetX, offsetY);

        for(Shape shape : shapes)
            shape.Move(offsetX, offsetY);
    }

    @Override
    public void setSelected(boolean isSelected) {
        super.setSelected(isSelected);

        for(Shape shape : shapes)
            shape.setSelected(isSelected);
    }

    @Override
    protected void DrawPoints(Graphics g) {}

    @Override
    public void Draw(Graphics g) {
        for(Shape shape : shapes) {
            shape.Draw(g);
        }

        if(isSelected()){
            g.setColor(new Color(255, 255, 255, 50));
            g.fillRect(X, Y, getWidth(), getHeight());
            g.setColor(Color.BLACK);
            g.drawRect(X, Y, getWidth(), getHeight());
        }
        
    }

    private void updateBorderSize() {
        if(shapes.size() > 0) {
            int top = Integer.MAX_VALUE;
            int bottom = Integer.MIN_VALUE;
            int left = Integer.MAX_VALUE;
            int right = Integer.MIN_VALUE;
            

            for(Shape shape : shapes) {
                top = Math.min(top, shape.getY());
                bottom = Math.max(bottom, shape.getY() + shape.getHeight());
                left = Math.min(left, shape.getX());
                right = Math.max(right, shape.getX() + shape.getWidth());
            }

            super.SetLocation(left, top);
            SetSize(right - left, bottom - top);
        }        
    }
}
