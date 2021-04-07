package Modes.Line;

import Associate.Port;
import Shapes.Lines.*;

public class AssociationLineMode extends LineMode {
    
    @Override
    protected Line createLine(Port startPort, Port endPort){
        return new AssociationLine(startPort, endPort);
    }
}
