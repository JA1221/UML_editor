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

        if(_shape == null){ // 點空區，開始圈選
            canvas.deselectAll(); //取消所有選取
            _shape = new SelectedArea(e.getX(), e.getY());
            canvas.addShape(_shape);
            _selectFlag = true;
        }else{ //有shape & 沒被選過
            if(!_shape.isSelected())
                singleSelection(_shape);
        }

        super.mousePressed(e);
    };

    @Override
    public void mouseDragged(MouseEvent e) {
        if(_selectFlag){ // 正在圈選
            updateSelectedArea(_shape);
        }else{ // 移動shape
            for(Shape shape : canvas.GetShapes()) {
                if(shape.isSelected())
                    shape.Move(e.getX() - _currentPoint.x, e.getY() - _currentPoint.y);
            }
        }

        _currentPoint = e.getPoint();
        super.mouseDragged(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(_selectFlag){ //圈選完
            canvas.removeShape(_shape); //移除圈選圖案
            canvas.deselectAll(); //重設shapes的isSelected
            multiSelection(_shape); //將圈選的shapes設定狀態      
        }

        _selectFlag = false;
        _shape = null;  

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

    private void multiSelection(Shape area) {
        List<Shape> shapes = canvas.GetShapes();
        int shapeCount = shapes.size();

        for(int i = 0; i < shapeCount; i++) {
            Point p1 = new Point(shapes.get(i).getX(), shapes.get(i).getY());
            Point p2 = new Point(shapes.get(i).getX() + shapes.get(i).getWidth(), shapes.get(i).getY() + shapes.get(i).getHeight());

            //shape左上右下都在selectedArea內
            if(area.IsInside(p1) & area.IsInside(p2)){
                selected(shapes.get(i--));
                shapeCount--;
            }
        }
    }

    private void singleSelection(Shape shape) {
        canvas.deselectAll();
        selected(shape);
    }

    private void selected(Shape shape) {
        canvas.removeShape(shape);
        canvas.addShape(shape);
        shape.setSelected(true);
    }
}
