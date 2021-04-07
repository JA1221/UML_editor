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
    public void SetSize(int width, int height) {
        super.SetSize(width, height);
        
        ports.get(0).SetLocation(X + width / 2, Y); // Up
        ports.get(1).SetLocation(X + width, Y + height / 2); // Right
        ports.get(2).SetLocation(X + width / 2, Y + height); // Down
        ports.get(3).SetLocation(X , Y + height / 2); // Left
    }

    @Override
    public void SetLocation(int x, int y) {
        super.SetLocation(x, y);

        int offsetX = x - X;
        int offsetY = y - Y;

        for (int i = 0; i < ports.size(); i++) 
            ports.get(i).Move(offsetX, offsetY);
    }

    @Override
    public void Move(int offsetX, int offsetY) {
        super.Move(offsetX, offsetY);

        for (int i = 0; i < ports.size(); i++) 
            ports.get(i).Move(offsetX, offsetY);
    }

    private void createPorts(){
        for (int i = 0; i < portNumber; i++)
            ports.add(new Port());
    }

    protected void DrawPoints(Graphics g){
        if(isSelected()){
           for(Port p : ports)
            p.Draw(g);
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
