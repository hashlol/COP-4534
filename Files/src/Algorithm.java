
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
/**
 * Algorithms-related utilities. COP-4534.
 *
 * @author Prof. Antonio Hernandez
 */
public class Algorithm
{
    public static void main(String[] arg){
        Algorithm alg = new Algorithm();
        int[] c = new int[1000];


        fillArrayNormalDistribution(c);
        printArray(c);
        //quicksort(c, 0, c.length-1);
        System.out.println("--------");
        printArray(c);
        System.out.println("-------------------------------");

        fillArrayWithOsAnd1s(c, 2);
        printArray(c);
     //   quicksort(c, 0, c.length-1);
        System.out.println("--------");
        printArray(c);
        System.out.println("-------------------------------");

        fillArrayUniformDistribution(c);
        printArray(c);
     //   quicksort(c, 0, c.length-1);
        System.out.println("--------");
        printArray(c);
    }
    private static Random rnd = new Random();
    /**
     * Recursive quickSort algorithm. Deterministic.
     */
    public static void quickSort(int[] list)
    {
        randomQuickSort(list, 0, list.length - 1);
    }
    private static void randomQuickSort(int[] list, int begin, int end)
    {
        int temp;
        int pivot = randomizedFindPivotLocation(begin, end);
// swap list[pivot] and list[end]
        temp = list[pivot];
        list[pivot] = list[end];
        list[end] = temp;
        pivot = end;
//find correct location of pivot
        int i = begin,
                j = end - 1;
        boolean iterationCompleted = false;
        while (!iterationCompleted)
        {
            while (list[i] < list[pivot])
                i++;
            while ((j >= 0) && (list[pivot] < list[j]))
                j--;
            if (i < j)
            {
//swap list[i] and list[j]
                temp = list[i];
                list[i] = list[j];
                list[j] = temp;
                i++;
                j--;
            } else
                iterationCompleted = true;
        }
//swap list[i] and list[pivot]
        temp = list[i];
        list[i] = list[pivot];
        list[pivot] = temp;
//sort sublists recursively
        if (begin < i - 1) randomQuickSort(list, begin, i - 1);
        if (i + 1 < end) randomQuickSort(list, i + 1, end);
    }
    /*
     * Computes the pivot for quicksort
     */
    private static int randomizedFindPivotLocation(int b, int e)
    {

        return b;
    }
    /**
     * Fills input array with random integers in [0, list.length] using a
     * uniform distribution.
     */
    public static void fillArrayUniformDistribution(int[] list)
    {
        for(int i=0; i<list.length; i++)
        {
            list[i] = rnd.nextInt(list.length);
        }
    }
    /**
     * Fills input array with random integers in [-infty, +infty] using a
     * normal distribution.
     */
    public static void fillArrayNormalDistribution(int[] list)
    {
        for(int i=0; i<list.length; i++)
        {
            list[i] = (int)Math.round(rnd.nextGaussian()*10);
        }
    }
    public static void printArray(int[] list)
    {
        for(int i=0; i<list.length; i++)
        {
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }
    /**
     * Fills input array with integers in [0, 1] with approximately x% of 0's.
     */
    public static void fillArrayWithOsAnd1s(int[] list, int x)
    {
        for(int i=0; i<list.length; i++)
        {
            if (rnd.nextInt(100) <= x)
                list[i] = 0;
            else
                list[i] = 1;
        }
    }
    /**
     * Randomly rearrange the input array.
     */
    public static void shuffleArray(int[] list)
    {
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i:list)
        {
            temp.add(i);
        }
        Collections.shuffle(temp);
        for(int i=0; i<list.length; i++)
        {
            list[i] = temp.get(i);
        }
    }
}
