package Actions.Edit;

import java.util.List;

import javax.swing.JOptionPane;

import Actions.Action;
import Shapes.Shape;

public class UngroupAction extends Action {
    @Override
    public void actionPerformed() {
        List<Shape> selectedShapes = canvas.getSelectedShapes();
        
        if(selectedShapes.size() != 1){
            JOptionPane.showMessageDialog(canvas,"�Хu���1�Ӫ���Ѱ�group !","ĵ�i", JOptionPane.ERROR_MESSAGE);
        }else{
            List<Shape> shapes = selectedShapes.get(0).getShapes();

            if(shapes.size() == 0) {
                JOptionPane.showMessageDialog(canvas,"�ݿ��composite���� !","ĵ�i", JOptionPane.ERROR_MESSAGE);
            }else{
                for(Shape shape : shapes) {
                    canvas.addShape(shape);
                    shape.setSelected(false);
                }
                canvas.removeShape(selectedShapes.get(0));
                System.out.println("UnGroup");
            }            
        } 
        canvas.repaint();    
    }
}
