package Shapes.Lines;

import java.awt.Graphics;
import java.awt.Point;

import Associate.Port;

public class Line {
    private Port _startPort, _endPort;
    private Point _startPoint, _endPoint;

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
    }
}
