package Prog18_03;

import javax.swing.*;
import java.awt.*;

/**
 * Defines a panel the drawings will be made in.
 * 
 * @author Prof. Antonio Hernandez
 */
public class GraphDisplay extends JPanel
{
    /**
     * Paints the graph example.
     * 
     * @param g graphics context
     */
    public void paint(Graphics g)
    {        
        int leftX = 100;
        int topY = 100;
        int width = 50;
        int height = 50;
        int labelX = 17;
        int labelY = 31;
        int gridWidth = 150;
        
        //draw vertex 1
        g.setColor(Color.ORANGE);
        g.fillOval(leftX, topY, width, height);
        g.setColor(Color.BLACK);
        g.drawOval(leftX, topY, width, height);
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
        g.drawString("1", leftX+labelX, topY+labelY);

        //draw vertex 2
        g.setColor(Color.ORANGE);
        g.fillOval(leftX+gridWidth, topY, width, height);
        g.setColor(Color.BLACK);
        g.drawOval(leftX+gridWidth, topY, width, height);
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
        g.drawString("2", leftX+gridWidth+labelX, topY+labelY);


        g.setColor(Color.ORANGE);
        g.fillOval(leftX+gridWidth, topY+topY, width, height);
        g.setColor(Color.BLACK);
        g.drawOval(leftX+gridWidth, topY+topY, width, height);
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
        g.drawString("3", leftX+gridWidth+labelX, topY+labelY+topY);

        //draw edge (1 to 2)
        g.setColor(Color.BLACK);
        g.drawLine(leftX+width, topY+height/2, leftX+gridWidth, topY+height/2);


        // draw edge to (1 to 3)
    //    g.drawLine(leftX+width, topY+height/2, leftX+gridWidth, (topY+height/2)+topY);


        //improper way
        g.drawLine(leftX+width/2, topY+height/2, leftX+gridWidth+width/2, topY+gridWidth+height/2);

    }
}
