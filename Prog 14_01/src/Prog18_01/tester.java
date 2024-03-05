package Prog18_01;

public class tester {
    public static void main(String[] args){
        Graph g = new Graph();

        System.out.print("    ");
        for(int i = 0; i<5; i++){
            System.out.print(i+ " ");
        }
        System.out.println();
        System.out.print("    ");
        for(int j = 0; j<5; j++){
            System.out.print("--");
        }
        System.out.println();
        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        System.out.println(g.toString());

        System.out.println("====EDGES REMOVED====");

        g.removeEdge(0,1);
        g.removeEdge(2,3);

        System.out.print("    ");
        for(int i = 0; i<5; i++){
            System.out.print(i+ " ");
        }
        System.out.println();
        System.out.print("    ");
        for(int j = 0; j<5; j++){
            System.out.print("--");
        }
        System.out.println();
        System.out.println(g.toString());

    }
}
