package Modes.Line;

import Associate.Port;
import Shapes.Lines.*;

public class GeneralizationLineMode extends LineMode {
    
    @Override
    protected Line createLine(Port startPort, Port endPort){
        return new GeneralizationLine(startPort, endPort);
    }
}
