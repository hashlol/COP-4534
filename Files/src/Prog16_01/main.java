package Prog16_01;
import Prog16_01.BinarySearchTree;
import Prog16_01.Node;
import Prog16_01.Queue;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.Random;

public class main {
    public static void main(String[] args){
        BinarySearchTree a = new BinarySearchTree();
        BinarySearchTree b = new BinarySearchTree();

        Random ran = new Random();

        for(int i = 0; i<10; i++){
          //  a.add(ran.nextInt(0,50));
            a.add(i);
           // b.add(ran.nextInt(0,50));
        }

        long start = System.currentTimeMillis();
        a.BFS();
      //  System.out.println(a.toString());
        long end = System.currentTimeMillis();
        System.out.println("BFS Time was: " + (end-start));

        long s2 = System.nanoTime();

    }
}
