package view.MenuComponent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

import Actions.Edit.*;
import Actions.File.*;

public class MenuBar extends JMenuBar{
    private JMenu FileMenu, EditMenu;
    private ActionMenuItem Exit;
    private ActionMenuItem Group, Ungroup, Rename;
    
    public MenuBar() {
        super();

        // FileMenu = new JMenu("File");
        EditMenu = new JMenu("Edit");

        // Exit = new ActionMenuItem("Exit", new ExitAction());
        Group = new ActionMenuItem("Group", new GroupAction());
        Ungroup = new ActionMenuItem("Ungroup", new UngroupAction());
        Rename = new ActionMenuItem("Rename", new RenameAction());

        // FileMenu.add(Exit);
        EditMenu.add(Group);
        EditMenu.add(Ungroup);
        EditMenu.add(Rename);

        // add(FileMenu);
        add(EditMenu);
    }
    
}
