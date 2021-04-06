package Modes;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.List;

import Shapes.Shape;

public class SelectMode extends Mode{
    private Point _pressedPoint, _currentPoint;
    private Shape _shape;

    @Override
    public void mousePressed(MouseEvent e) {
        _pressedPoint = e.getPoint();
        _currentPoint = new Point(_pressedPoint);
        _shape = GetPressedShape(e.getPoint());

        super.mousePressed(e);
    };

    @Override
    public void mouseDragged(MouseEvent e) {
        if(_shape != null){
            _shape.Move(e.getX() - _currentPoint.x, e.getY() - _currentPoint.y);
            _currentPoint = e.getPoint();
        }
    }

    private Shape GetPressedShape(Point p) {
        List<Shape> shapes = canvas.GetShapes();

        for(int i = shapes.size() - 1; i >= 0; i--) {
            if(shapes.get(i).IsInside(p))
                return shapes.get(i);
        }

        return null;
    }
}
