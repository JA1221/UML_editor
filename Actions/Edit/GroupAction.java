package Actions.Edit;

import java.util.List;

import javax.swing.JOptionPane;

import Actions.Action;
import Shapes.Shape;
import Shapes.BasicObjects.CompositionObject;

public class GroupAction extends Action {
    @Override
    public void actionPerformed() {
        List<Shape> shapes = canvas.getSelectedShapes();

        if(shapes.size() < 2) {
            JOptionPane.showMessageDialog(canvas,"請選擇多個物件Group !","警告", JOptionPane.ERROR_MESSAGE);
        }else{
            Shape groupShape = new CompositionObject(shapes); //組成新群組
            groupShape.setSelected(true);

            for(Shape shape : shapes) //將shape從List中刪除
                canvas.removeShape(shape);

            canvas.addShape(groupShape); //把群組加入List
        }
        
        canvas.repaint();
    }
}
