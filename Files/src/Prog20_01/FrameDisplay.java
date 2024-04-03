package Prog20_01;
import javax.swing.*;

public class FrameDisplay extends JFrame
{
    int WIDTH = 450;
    int HEIGHT = 450;
    
    private GraphDisplay panel;

    public FrameDisplay(int centerX, int centerY, int radius,
                        int leftX, int topY, int width, int height)
    {
        setTitle("Graph Display");
        setSize(WIDTH, HEIGHT);

        panel = new GraphDisplay(centerX, centerY, radius,
                                 leftX, topY, width, height);
        add(panel);
    }
    
    public void setCircle(int x, int y, int r)
    {
        panel.setCircle(x, y, r);
    }
}
