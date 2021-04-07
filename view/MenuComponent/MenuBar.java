package view.MenuComponent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar{
    private JMenu FileMenu, EditMenu;
    private JMenuItem Exit;
    private JMenuItem Group, Ungroup, Rename;
    
    public MenuBar() {
        super();
        FileMenu = new JMenu("File");
        EditMenu = new JMenu("Edit");

        Exit = new JMenuItem("Exit");
        Group = new JMenuItem("Group");
        Ungroup = new JMenuItem("Ungroup");
        Rename = new JMenuItem("Rename");

        FileMenu.add(Exit);
        EditMenu.add(Group);
        EditMenu.add(Ungroup);
        EditMenu.add(Rename);

        add(FileMenu);
        add(EditMenu);
    }
    
}
