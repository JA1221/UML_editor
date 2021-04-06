package Modes;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.List;

import Shapes.Shape;
import Shapes.BasicObjects.SelectedArea;

public class SelectMode extends Mode{
    private Point _pressedPoint, _currentPoint;
    private Shape _shape;
    private boolean _selectFlag = false;

    @Override
    public void mousePressed(MouseEvent e) {
        _pressedPoint = e.getPoint();
        _currentPoint = new Point(_pressedPoint);
        _shape = getPressedShape(e.getPoint());

        if(_shape == null){ // �I�ŰϡA�i���
            _shape = new SelectedArea(e.getX(), e.getY());
            canvas.AddShape(_shape);
            _selectFlag = true;
        }

        super.mousePressed(e);
    };

    @Override
    public void mouseDragged(MouseEvent e) {
        if(_selectFlag){ // ���b���
            updateSelectedArea(_shape);
        }else{ // ����shape
            _shape.Move(e.getX() - _currentPoint.x, e.getY() - _currentPoint.y);
        }

        _currentPoint = e.getPoint();

        super.mouseDragged(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(_selectFlag){ //��粒
            canvas.removeShape(_shape);
            _selectFlag = false;
            _shape = null;           
        }else{ //���ʧ�

        }

        super.mouseReleased(e);
    };

    private Shape getPressedShape(Point p) {
        List<Shape> shapes = canvas.GetShapes();

        for(int i = shapes.size() - 1; i >= 0; i--) {
            if(shapes.get(i).IsInside(p))
                return shapes.get(i);
        }

        return null;
    }

    private void updateSelectedArea(Shape selectedArea) {
        int x1 = (int)_pressedPoint.getX();
        int y1 = (int)_pressedPoint.getY();
        int x2 = (int)_currentPoint.getX();
        int y2 = (int)_currentPoint.getY();

        selectedArea.SetLocation(Math.min(x1, x2), Math.min(y1, y2));
        selectedArea.SetSize(Math.abs(x1 - x2), Math.abs(y1 - y2));
    }
}
