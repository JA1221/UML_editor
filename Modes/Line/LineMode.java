package Modes.Line;

import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.Point;

import Associate.Port;
import Modes.Mode;
import Shapes.Shape;
import Shapes.Lines.Line;

public class LineMode extends Mode {
    protected Port startPort, endPort;
    protected Shape startShape;
    protected Line line;

    protected LineMode() {
        startPort = null;
        endPort = null;        
        startShape = null;
        line = null;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        startShape = getPressedShape(e.getPoint());
        if(startShape != null) {
            startPort = startShape.getNearestPort(e.getPoint());
        }

        super.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Shape endShape = getPressedShape(e.getPoint());

        if(startShape == null| endShape == null) return;

        if(!startShape.equals(endShape)){
            endPort = endShape.getNearestPort(e.getPoint());
            canvas.addLine(new Line(startPort, endPort));
        }

        super.mouseReleased(e);
    }


    private Shape getPressedShape(Point p) {
        List<Shape> shapes = canvas.GetShapes();

        for(int i = shapes.size() - 1; i >= 0; i--) {
            if(shapes.get(i).IsInside(p))
                return shapes.get(i);
        }

        return null;
    }
}
