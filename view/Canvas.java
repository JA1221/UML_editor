package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import Modes.Mode;
import Shapes.Shape;
import Shapes.Lines.Line;

public class Canvas extends JPanel {
    private static Canvas _canvas;
    private List<Line> _lines;
    private List<Shape> _shapes;
    private Mode _mode;
    
    public Canvas() {
        _shapes = new ArrayList<Shape>();
        _lines = new ArrayList<Line>();
        InitializeMouseEvents();
    }

    public static Canvas getInstance() {
        if(_canvas == null)
            _canvas = new Canvas();

        return _canvas;
    }

    public List<Shape> addShape(Shape shape){
        _shapes.add(shape);

        return _shapes;
    }

    public void removeShape(Shape shape){
        _shapes.remove(shape);
    }

    public List<Shape> GetShapes(){
        return _shapes;
    }

    public List<Shape> getSelectedShapes() {
        List<Shape> selectedShapes = new ArrayList<Shape>();

        for(Shape shape : _shapes) {
            if(shape.isSelected())
                selectedShapes.add(shape);
        }

        return selectedShapes;
    }

    public List<Line> addLine(Line line) {
        _lines.add(line);

        return _lines;
    }

    public void removeLine(Line line) {
        _lines.remove(line);
    }

    public List<Line> getLines() {
        return _lines;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.LIGHT_GRAY);
        
        for(Shape shape : _shapes)
            shape.draw(g);

        for(Line line : _lines)
            line.draw(g);
    }
    
    public void setMode(Mode mode){
        _mode = mode;
    }

    public void deselectAll() {
        for(Shape shape : _shapes)
            shape.setSelected(false);
        repaint();
    }

    private void InitializeMouseEvents() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                if(_mode != null){
                    _mode.mousePressed(e);
                    repaint();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e){
                if(_mode != null){
                    _mode.mouseReleased(e);
                    repaint();
                }
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e){
                if(_mode != null){
                    _mode.mouseDragged(e);
                    repaint();
                }
            }
        });
    }
}
