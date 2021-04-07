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
            
            endPort = new Port(e.getPoint());  //mouse's location
            line = createLine(startPort, endPort);
            canvas.addLine(line);
        }

        super.mousePressed(e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(startShape != null)
            endPort.SetLocation(e.getPoint()); //follow mouse

        super.mouseDragged(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Shape endShape = getPressedShape(e.getPoint());
        canvas.removeLine(line); //remove temp line

        if(startShape == null| endShape == null) //no shape
            return;

        if(!startShape.equals(endShape)){ //start & end shapes isn't equals
            endPort = endShape.getNearestPort(e.getPoint()); 
            canvas.addLine(createLine(startPort, endPort)); //create Line
        }

        super.mouseReleased(e);
    }
    
    //Override can be replaced with another line(subclass)
    protected Line createLine(Port startPort, Port endPort) {
        return new Line(startPort, endPort);
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
