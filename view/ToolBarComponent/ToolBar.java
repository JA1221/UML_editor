package view.ToolBarComponent;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JToolBar;

import Modes.*;
import Modes.Line.*;
import Modes.BasicObject.*;

public class ToolBar extends JToolBar {
    private List<ModeButton> _buttonList = new ArrayList<ModeButton>();
    private String _modeNames[] = {"select", "associationLine","generalizationLine", "compositionLine", "class", "useCase"};
    private Mode _modes[] = {new SelectMode(), new AssociationLineMode(), new GeneralizationLineMode(), new CompositionLineMode(), new ClassMode(), new UseCaseMode()};

    public ToolBar() {
        this.setOrientation(VERTICAL);
        this.setFloatable(false);

        for(int i = 0; i < _modes.length; i++){
            ModeButton button = new ModeButton(_modes[i]);

            button.setIcon(new ImageIcon(getClass().getResource("ButtonIcon/" + _modeNames[i] + ".png")));
            button.setToolTipText(_modeNames[i]);
            button.setSize(50, 50);

            _buttonList.add(button);
            this.add(button);
        }
    }
}
