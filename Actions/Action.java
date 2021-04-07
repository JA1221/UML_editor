package Actions;

import view.Canvas;

public abstract class Action {
    protected Canvas canvas = Canvas.getInstance();
    
    public abstract void actionPerformed();
}
