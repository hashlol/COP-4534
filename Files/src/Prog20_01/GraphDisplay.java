package Prog20_01;
import javax.swing.*;
import java.awt.*;

public class GraphDisplay extends JPanel
{
    private int centerX;
    private int centerY;
    private int radius;
    private int leftX;
    private int topY;
    private int width;
    private int height;
    
    /**
     * Parameterized constructor.
     */
    public GraphDisplay(int centerX, int centerY, int radius,
                        int leftX, int topY, int width, int height)
    {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.leftX = leftX;
        this.topY = topY;
        this.width = width;
        this.height = height;
    }
    
    /**
     * Circle mutator.
     */
    public void setCircle(int x, int y, int r)
    {
        this.centerX = x;
        this.centerY = y;
        this.radius = r;
    }
    
    /**
     * Paints this panel; the system invokes it every time
     * it deems necessary to redraw the panel.
     */
    public void paint(Graphics g)
    {        
        super.paint(g); //clears window
        
        //draw ellipse
        g.setColor(Color.ORANGE);
        g.fillOval(centerX-radius, centerY-radius, 2*radius, 2*radius);
        g.setColor(Color.BLACK);
        g.drawOval(centerX-radius, centerY-radius, 2*radius, 2*radius);
        
        //draw line segment
        g.drawRect(leftX, topY, width, height);
        g.setColor(Color.DARK_GRAY);
        g.fillRect(leftX, topY, width, height);
    }
}
