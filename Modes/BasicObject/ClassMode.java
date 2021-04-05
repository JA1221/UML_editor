package Modes.BasicObject;

import java.awt.event.MouseEvent;

import Shapes.BasicObjects.Class;

public class ClassMode extends BasicObjectMode{
    
    @Override
    public void mousePressed(MouseEvent e){
        shape = new Class(e.getPoint());
        System.out.println("add Class!");
        
        super.mousePressed(e);
    }
}
