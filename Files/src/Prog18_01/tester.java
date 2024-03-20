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
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        System.out.println(g.toString());

        System.out.println("====EDGES REMOVED====");

     //   g.removeEdge(0,1);
    //    g.removeEdge(2,3);

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


        int[] adj = {1,2,3,4};

        for(int a: adj){
            System.out.print(a+": ");
            for(int b: g.findAdjacencyVertices(a)){
                System.out.print(b + " ");
            }
            System.out.println();
        }

        // Testing BFS with Graph
        System.out.println();
        System.out.println("============");
        g.BFT(0);

        System.out.println("\n============");
        Graph dft = new Graph("Prog18_05 - graph 01.txt");


        dft.DFT(0);

        System.out.println("======================");
        System.out.println("Djikstra's algorithm test");
        System.out.println("======================");

        int vertices = dft.getVerticesNumber();
        int[] prev = new int[vertices];
        int[] dist = new int[vertices];
        int v = 0;
        dft.allShortestPath(prev,dist, v);

        for(int node: dist){
            System.out.print(node+" ");
        }

        int[] shortestPath = dft.getPath(v, 4, prev);
        System.out.println();
        for(int node: shortestPath){
            System.out.print(node+" ");
        }

        System.out.println("\n======================");
        System.out.println("Travelling salesman algorithm test");
        System.out.println("======================");
        Graph TSPSearch = new Graph();
        for(int i = 0; i<10; i++){
            //dft.addEdge(1+i, i+1);
        }
        int[] a = new int[20];


        dft.TSP_exhaustiveSearch(a);
    }
}
