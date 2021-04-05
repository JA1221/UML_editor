package Associate;

import java.awt.*;

public class Port {
    protected int X, Y;
    final int SquareLength = 10;
    private boolean Visible;

    public Port() {
        this(0, 0);
    }

    public Port(int X, int Y) {
        this.X = X;
        this.Y = Y;
        Visible = false;
    }
    
    public double GetDistanceFrom(Point p) {
        return Math.sqrt(Math.pow(X - p.x, 2) + Math.pow(Y - p.y, 2));
    }

    public void Draw(Graphics g) {
        if(Visible) {
            g.fillRect(X - SquareLength / 2, Y - SquareLength / 2, SquareLength, SquareLength);
        }
    }

    public void SetLocation(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }

    public void Move(int offsetX, int offsetY) {
        X += offsetX;
        Y += offsetY;
    }
}
