import javax.swing.*;
import java.awt.*;
import view.MenuBar;
import view.ToolBar;

public class UMLEditor extends JFrame{
    private MenuBar menuBar = new MenuBar();
    private ToolBar toolbar = new ToolBar();

    public UMLEditor() {
        initComponents();
        this.setJMenuBar(menuBar);
        this.getContentPane().add(toolbar, BorderLayout.WEST);
    }

    private void initComponents() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("UML editor");
        this.setSize(800,650);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        UMLEditor myUML_editor = new UMLEditor();
    }
}