package Shapes.BasicObjects;

import Associate.Port;
import Shapes.Shape;
import java.awt.Graphics;

public abstract class BasicObjects extends Shape{
    private final int PortNumber = 4;
    protected Port[] Ports;

    public BasicObjects(){
        super();
        createPorts();
    }

    public BasicObjects(int X, int Y) {
        super(X, Y);
        createPorts();
    }

    @Override
    public void SetSize(int width, int height) {
        super.SetSize(width, height);
        
        Ports[0].SetLocation(X + width / 2, Y); // Up
        Ports[1].SetLocation(X + width, Y + height / 2); // Right
        Ports[2].SetLocation(X + width / 2, Y + height); // Down
        Ports[3].SetLocation(X , Y + height / 2); // Left
    }

    @Override
    public void SetLocation(int x, int y) {
        super.SetLocation(x, y);

        int offsetX = x - X;
        int offsetY = y - Y;

        for (int i = 0; i < Ports.length; i++) 
            Ports[i].Move(offsetX, offsetY);
    }

    private void createPorts(){
        Ports = new Port[PortNumber];
        for (int i = 0; i < PortNumber; i++)
            Ports[i] = new Port();
    }

    protected void DrawPoints(Graphics g){
        for(Port p : Ports){
            p.Draw(g);
        }
    }
}
