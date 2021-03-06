import javax.swing.*;
import java.awt.*;
import view.MenuComponent.MenuBar;
import view.ToolBarComponent.*;
import view.Canvas;

public class UMLEditor extends JFrame{
    private MenuBar menuBar = new MenuBar();
    private ToolBar toolbar = new ToolBar();
    private Canvas canvas = Canvas.getInstance();

    public UMLEditor() {
        this.setJMenuBar(menuBar);
        this.getContentPane().add(toolbar, BorderLayout.WEST);
        this.getContentPane().add(canvas, BorderLayout.CENTER);

        initComponents();
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