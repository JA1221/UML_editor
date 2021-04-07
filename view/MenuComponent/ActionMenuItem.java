package view.MenuComponent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import Actions.Action;

public class ActionMenuItem extends JMenuItem {

    protected ActionMenuItem(String menuName, Action action) {
        super(menuName);

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action.actionPerformed();
                System.out.println("Action:" + action);
            }
        });
    }

    protected ActionMenuItem(Action action) {
        this("", action);
    }
}
