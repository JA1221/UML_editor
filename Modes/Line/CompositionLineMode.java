package Modes.Line;

import Associate.Port;
import Shapes.Lines.*;

public class CompositionLineMode extends LineMode {
    
    @Override
    protected Line createLine(Port startPort, Port endPort){
        return new CompositionLine(startPort, endPort);
    }
}
