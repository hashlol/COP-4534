package Prog16_04;

import Prog16_03.BinarySearchTree;
import Prog16_03.Node;
import java.util.Random;

public class Prog16_04 {

    public static void main(String[] args){
        Random ran = new Random();
        BinarySearchTree a = new BinarySearchTree();
        for(int i = 0; i<10; i++){
            a.add(ran.nextInt(0,50));
        }
        a.printAllPathsFromRootToLeaves();
    //    a.improperMaxSumPathFromRootToLeaves();
        Node[] b = new Node[a.getNumberOfElements()];
        a.maxSumPathFromRootToLeaves(b,5);
    }

}
