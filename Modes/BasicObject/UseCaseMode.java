package Modes.BasicObject;

import java.awt.event.MouseEvent;

import Shapes.BasicObjects.UseCase;

public class UseCaseMode extends BasicObjectMode{
    
    @Override
    public void mousePressed(MouseEvent e) {
        shape = new UseCase(e.getPoint());
        System.out.println("add UseCase!");

        super.mousePressed(e);
    }
}
