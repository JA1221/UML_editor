package Shapes.BasicObjects;

import java.awt.Point;
import java.util.ArrayList;

import Associate.Port;
import Shapes.Shape;
import java.awt.Graphics;

public abstract class BasicObjects extends Shape{
    private final int portNumber = 4;

    public BasicObjects(){
        this(0, 0);
    }

    public BasicObjects(int X, int Y) {
        super(X, Y);
        ports = new ArrayList<Port>();
        createPorts();
    }

    @Override
    public void setSize(int width, int height) {
        super.setSize(width, height);
        
        ports.get(0).SetLocation(X + width / 2, Y); // Up
        ports.get(1).SetLocation(X + width, Y + height / 2); // Right
        ports.get(2).SetLocation(X + width / 2, Y + height); // Down
        ports.get(3).SetLocation(X , Y + height / 2); // Left
    }

    @Override
    public void setLocation(int x, int y) {
        super.setLocation(x, y);

        int offsetX = x - X;
        int offsetY = y - Y;

        for (int i = 0; i < ports.size(); i++) 
            ports.get(i).move(offsetX, offsetY);
    }

    @Override
    public void move(int offsetX, int offsetY) {
        super.move(offsetX, offsetY);

        for (int i = 0; i < ports.size(); i++) 
            ports.get(i).move(offsetX, offsetY);
    }

    private void createPorts(){
        for (int i = 0; i < portNumber; i++)
            ports.add(new Port());
    }

    protected void drawPoints(Graphics g){
        if(isSelected()){
           for(Port p : ports)
            p.draw(g);
        }
    }

    @Override
    public Port getNearestPort(Point p){
        Port nearestPoint = ports.get(0);
        double nearestDistance = nearestPoint.getDistanceFrom(p);

        for(Port port : ports){
            if(port.getDistanceFrom(p) < nearestDistance) {
                nearestPoint = port;
                nearestDistance = port.getDistanceFrom(p);
            }
        }

        return nearestPoint;
    }
}
