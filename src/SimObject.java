import java.awt.Color;

public class SimObject {
    private int x;
    private int y;
    private int xScale;
    private int yScale;
    private Color color;

    public void setX(int _x)
    {
        this.x = _x;
    }

    public int getX()
    {
        return this.x;
    }

    public void setY(int _y)
    {
        this.y = _y;
    }

    public int getY()
    {
        return this.y;
    }

    public void setXScale(int _xScale)
    {
        this.xScale = _xScale;
    }
    
    public int getXScale()
    {
        return this.xScale;
    }

    public void setYScale(int _yScale)
    {
        this.yScale = _yScale;
    }

    public int getYScale()
    {
        return this.yScale;
    }
    
    public void gameTick()
    {

    }
}
