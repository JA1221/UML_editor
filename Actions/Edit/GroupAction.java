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
            JOptionPane.showMessageDialog(canvas,"�п�ܦh�Ӫ���Group !","ĵ�i", JOptionPane.ERROR_MESSAGE);
        }else{
            Shape groupShape = new CompositionObject(shapes); //�զ��s�s��
            groupShape.setSelected(true);

            for(Shape shape : shapes) //�Nshape�qList���R��
                canvas.removeShape(shape);

            canvas.addShape(groupShape); //��s�ե[�JList
        }
        
        canvas.repaint();
    }
}
