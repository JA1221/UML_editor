import javax.swing.*;
import java.awt.*;
import view.MenuBar;

public class UMLEditor extends JFrame{
    private MenuBar menuBar = new MenuBar();

    public UMLEditor() {
        initComponents();
        this.setJMenuBar(menuBar);
    }

    private void initComponents() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("UML editor");
        this.setSize(700,500);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        UMLEditor myUML_editor = new UMLEditor();
    }
}