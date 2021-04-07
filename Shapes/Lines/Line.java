package Shapes.Lines;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Point;
import java.awt.geom.AffineTransform;

import Associate.Port;

public class Line {
    private Port _startPort, _endPort;
    protected Point _startPoint, _endPoint;
    protected double angle;

    public Line(Port startPort, Port endPort) {
        _startPort = startPort;
        _endPort = endPort;
        updateLocation();
    }

    public void draw(Graphics g) {
        updateLocation();
        g.drawLine(_startPoint.x, _startPoint.y, _endPoint.x, _endPoint.y);
    }
    
    private void updateLocation() {
        _startPoint = _startPort.getPoint();
        _endPoint = _endPort.getPoint();
        
        double diffX = _endPoint.getX() - _startPoint.getX();
        double diffY = _endPoint.getY() - _startPoint.getY();

        angle = Math.atan2(-diffY, diffX);
    }

    protected void drawFillHead(Graphics g, int x[], int y[], int num){
        Graphics2D g2d = (Graphics2D)g;
        AffineTransform old = g2d.getTransform();

        g2d.translate(_endPoint.x, _endPoint.y);
        g2d.rotate(2*Math.PI - angle);
        g2d.setColor(Color.WHITE);
        g2d.fillPolygon(x, y, x.length);
        g2d.setColor(Color.BLACK);
        g2d.drawPolygon(x, y, x.length);

        g2d.setTransform(old);
    }

    protected void drawLineHead(Graphics g, int x[], int y[], int num){
        Graphics2D g2d = (Graphics2D)g;
        AffineTransform old = g2d.getTransform();

        g2d.translate(_endPoint.x, _endPoint.y);
        g2d.rotate(2*Math.PI - angle);
        g2d.drawPolyline(x, y, x.length);

        g2d.setTransform(old);
    }
}
