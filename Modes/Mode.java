package Modes;

import java.awt.event.MouseEvent;

import view.Canvas;

public class Mode {
    protected Canvas canvas = Canvas.getInstance();
    
    public void mousePressed(MouseEvent e) {};
    public void mouseReleased(MouseEvent e) {};
    public void mouseDragged(MouseEvent e) {};
}
