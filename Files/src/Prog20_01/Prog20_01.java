package Prog20_01;

import java.util.*;
import javax.swing.*;

public class Prog20_01 {
    public static void main(String[] args){
        new Prog20_01();
    }
    public Prog20_01() {
        int centerX = 100;
        int centerY = 100;
        int radius = 20;

        int leftX = 50;
        int topY = 300;
        int width = 200;
        int height = 50;

        FrameDisplay frame = new FrameDisplay(centerX, centerY, radius, leftX, topY, width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        delay(1000);
        double startDist = distance(centerX, centerY, centerX, topY);
        for (int i = 0; i < 5; i++) {
            while (distance(centerX, centerY, centerX, topY) > radius) {
                delay(1);

                frame.setCircle(centerX, centerY, radius);
                frame.repaint();


                centerY++;
            }

            while (distance(centerX, centerY, centerX, topY) < startDist) {
                delay(1);
                frame.setCircle(centerX, centerY, radius);
                frame.repaint();

                centerY--;

            }
            startDist-=50;
        }
    }

        public double distance(int x0, int y0, int x1, int y1){
            return Math.sqrt(Math.pow(x0-x1, 2) + Math.pow(y0-y1,2));
        }

        public void delay(int ms){
            try{
                Thread.sleep(ms);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

}
