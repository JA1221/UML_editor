package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Modes.Mode;

public class ModeButton extends JButton {
    private Mode _mode;
    
    protected ModeButton(Mode mode) {
        _mode = mode;
        setSize(50, 50);

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Canvas.getInstance().setMode(mode);
                System.out.println("SetMode:" + _mode);
            }
        });
    }
}
