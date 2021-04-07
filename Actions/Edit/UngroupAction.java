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
            JOptionPane.showMessageDialog(canvas,"請只選擇1個物件解除group !","警告", JOptionPane.ERROR_MESSAGE);
        }else{
            for(Shape shape : selectedShapes.get(0).getShapes()) {
                canvas.addShape(shape);
                shape.setSelected(false);
            }

            canvas.removeShape(selectedShapes.get(0));
            System.out.println("UnGroup");
        } 
        canvas.repaint();    
    }
}
