package view;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JToolBar;

public class ToolBar extends JToolBar {
    private List<Button> buttonList = new ArrayList<Button>();
    private String bottonName[] = {"select", "associationLine","generalizationLine", "compositionLine", "class", "useCase"};
    
    public ToolBar() {
        this.setOrientation(VERTICAL);
        this.setFloatable(false);

        for(String name : bottonName){
            Button button = new Button();

            button.setSize(50, 50);
            button.setIcon(new ImageIcon(getClass().getResource("images/" + name + ".png")));
            // System.out.println(getClass());
            button.setToolTipText(name);

            buttonList.add(button);
            this.add(button);
        }
    }
}
