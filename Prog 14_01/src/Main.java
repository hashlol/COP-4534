public class Main {
    public static void main(String[] args) {
        Prog14_01 prog = new Prog14_01();


        int[] ab = new int[10];
        System.out.println("-------------------------------------");
        prog.fillArray(ab);
        prog.printArray(ab);
        int ran = 2;
        int a = prog.locateRightEnc(ab,2);
        int b = prog.locateLeftEnc(ab, 2);

        int ac = a-b;
        System.out.println(ac);


        System.out.println("--------------------------------------");





    }

    }
