import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Prog14_01 {
    Random ran = new Random();
    private int count = 0;
    private ArrayList<Integer> a;
    private int loc;

    public Prog14_01() {
        a = new ArrayList<>();

        int[] list = new int[10];
        fillArray(list);
        printArray(list);
        Arrays.sort(list);
        printArray(list);
        printIteration(a);

        int x = ran.nextInt(10);
        System.out.println(x + " is in the array t or f " + binarySearch(list, x));
        System.out.println("count is: " + count);
        printIteration(a);

        System.out.println("-------");
        System.out.println("Left side " + locateLeftEnc(list, x));
        System.out.println("Right side " + locateRightEnc(list, x));
    }

    public void fillArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ran.nextInt(0, 10);
        }
    }

    public void printArray(int[] lst) {
        for (int a : lst) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public void printIteration(ArrayList<Integer> a) {
        System.out.print("Iteration: ");
        for (int aa : a) {
            System.out.print(aa + " ");
        }
        System.out.println();
    }

    public boolean binarySearch(int[] list, int x) {
        return binarySearch(list, 0, list.length - 1, x);
    }

    private boolean binarySearch(int[] list, int first, int last, int x) {
        boolean found;
        if (first > last) found = false;
        else {
            int mid = (first + last) / 2;
            if (list[mid] == x) found = true;
            else {
                if (x < list[mid]) {
                    this.count++;
                    this.a.add(mid - 1);
                    found = binarySearch(list, first, mid - 1, x);
                } else {
                    this.count++;
                    this.a.add(mid + 1);
                    found = binarySearch(list, mid + 1, last, x);
                }
            }
        }
        return found;
    }


    public int locateLeftEnc(int[] list, int x) {
        return locateLeftEnc(list, 0, list.length - 1, x);
    }

    private int locateLeftEnc(int[] list, int first, int last, int x) {
        this.loc = 0;

        if (first > last) this.loc = first;
        else {
            int mid = (first + last) / 2;
            if (x <= list[mid]) {
                this.loc = locateLeftEnc(list, first, mid - 1, x);
            } else {
                this.loc = locateLeftEnc(list, mid + 1, last, x);
            }
        }
        return this.loc;
    }

    public int locateRightEnc(int[] list, int x) {
        return locateRightEnc(list, 0, list.length - 1, x);
    }

    private int locateRightEnc(int[] list, int first, int last, int x) {
        this.loc = 0;

        if (first > last) this.loc = first;
        else {
            int mid = (first + last) / 2;
            if (x >= list[mid]) {
                this.loc = locateRightEnc(list, mid + 1, last, x);
            } else {
                this.loc = locateRightEnc(list, first, mid - 1, x);
            }
        }
        return this.loc;
    }


}