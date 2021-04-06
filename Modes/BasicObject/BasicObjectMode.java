package Modes.BasicObject;

import java.awt.event.MouseEvent;

import Modes.Mode;
import Shapes.Shape;

public class BasicObjectMode extends Mode {
    protected Shape shape;
    
    @Override
    public void mousePressed(MouseEvent e) {
        canvas.AddShape(shape);

        super.mousePressed(e);
    }
}
