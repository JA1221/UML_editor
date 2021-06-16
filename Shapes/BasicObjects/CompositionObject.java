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
    public boolean isInside(Point p) {
        for(Shape shape : shapes) {
            if(shape.isInside(p))
                return true;
        }

        return false;
    }

    @Override
    public void setLocation(int x, int y) {
        super.setLocation(x, y);

        int offsetX = x - X;
        int offsetY = y - Y;

        for(Shape shape : shapes)
            shape.move(offsetX, offsetY);
    }

    @Override
    public void move(int offsetX, int offsetY) {
        super.move(offsetX, offsetY);

        for(Shape shape : shapes)
            shape.move(offsetX, offsetY);
    }

    @Override
    public void setSelected(boolean isSelected) {
        super.setSelected(isSelected);

        for(Shape shape : shapes)
            shape.setSelected(isSelected);
    }

    @Override
    protected void drawPoints(Graphics g) {}

    @Override
    public void draw(Graphics g) {
        for(Shape shape : shapes) {
            shape.draw(g);
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

            super.setLocation(left, top);
            setSize(right - left, bottom - top);
        }        
    }
}
