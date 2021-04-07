package Actions.Edit;

import javax.swing.JOptionPane;

import Actions.Action;
import Shapes.Shape;

public class RenameAction extends Action {
    @Override
    public void actionPerformed() {
        String newName;
        newName = JOptionPane.showInputDialog("New name :");

        if(newName != null) {
            for(Shape shape : canvas.getSelectedShapes()) {
                shape.setShapeName(newName);
            }

            canvas.repaint();
        }
        
    }
}
