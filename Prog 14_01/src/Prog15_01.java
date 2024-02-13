import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Prog15_01 {
    Random rnd = new Random();

    public static void main(String[] args){
        new Prog15_01();
    }

    public Prog15_01() {
        int[] list = new int[20];

        fillArrayUniformDistribution(list);
        Arrays.sort(list);
        printArray(list);


    }
    public void printArray(int[] list){
        for(int l: list){
            System.out.print(l+" ");
        }
        System.out.println();
    }
    public void fillArrayUniformDistribution(int[] list){
        for(int i = 0; i<list.length; i++){
            list[i] = rnd.nextInt(100);
        }
    }
}
