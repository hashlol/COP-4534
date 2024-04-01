package Prog18_01;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Implements a Graph. Uses an adjacency matrix to represent the graph.
 * 
 * @author Prof. Antonio Hernandez
 */
public class Graph implements GraphInterface
{
    Random ran = new Random();
    public int verticesNumber;
    private int[][] matrix; //adjacency matrix
    
    public Graph()
    {
        verticesNumber = 5;
        matrix = new int[verticesNumber][verticesNumber];
    }
    
    public Graph(int n)
    {
        verticesNumber = n;
        matrix = new int[verticesNumber][verticesNumber];
    }
    /**
     * Instantiates a graph and initializes it with info from a text file.
     *
     * @param filename text file with graph info
     */
    public Graph(String filename)
    {
        File input = new File(filename);

        Scanner in = null;
        try
        {
            in = new Scanner(input);
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found!");
            System.exit(0);
        }

        while (in.hasNextLine())
        {
            verticesNumber = in.nextInt();
            matrix = new int[verticesNumber][verticesNumber];

            for(int i=0; i<verticesNumber; i++)
            {
                for(int j=0; j<verticesNumber; j++)
                {
                    matrix[i][j] = in.nextInt();
                }
            }
        }

        in.close();
    }
        public void createCompleteGraph() {
            if (matrix == null || verticesNumber <= 0) {
                System.out.println("Graph not properly initialized. Cannot create complete graph.");
                return;
            }

            for (int i = 0; i < verticesNumber; i++) {
                for (int j = 0; j < verticesNumber; j++) {
                    if (i != j) {
                        addEdge(i, j);
                    }
                }
            }
        }

    public void addEdge(int v, int w)
    {
        matrix[v][w] = 1;
        matrix[w][v] = 1;
    }
    
    public void removeEdge(int v, int w)
    {
        matrix[v][w] = 0;
        matrix[w][v] = 0;        
    }

    public int getVerticesNumber(){
        return verticesNumber;
    }
    
    /**
     * Finds vertices adjacent to a given vertex.
     * 
     * @param v given vertex
     * @return list of vertices adjacent to v stored in an array;
     *          size of array = number of adjacent vertices
     */
    public int[] findAdjacencyVertices(int v)
    {
        int[] vert = new int[verticesNumber];
        int total = 0;
        
        for (int i=0; i<verticesNumber; i++)
        {
            if (matrix[v][i] != 0)
            {
                vert[total] = i;
                total++;
            }
        }
        
        return Arrays.copyOf(vert, total);        
    }
    
    public String toString()
    {
        String s = "";
        
        for (int i=0; i<verticesNumber; i++)
        {
            s += i;
            s+=" | ";
            for (int j=0; j<verticesNumber; j++)
            {
                s += matrix[i][j] + " ";
            }
            s += "\n";
        }
        
        return s;
    }

    public void DFT(int v){
        boolean[] visited = new boolean[verticesNumber];

        for(int i = 0; i<verticesNumber; i++){
            visited[i] = false;
        }
        recursiveDFT(v, visited);

        for(int u = 0; u<verticesNumber; u++){
            if(!visited[u]) recursiveDFT(u, visited);
        }
        System.out.println();
    }

    private void recursiveDFT(int v, boolean[] visited){
        visited[v] = true;
        System.out.print(v+" ");

        int[] adj = findAdjacencyVertices(v);

        for(int u: adj){
            if(!visited[u]) recursiveDFT(u, visited);
        }
    }

    public void BFT(int v){
        boolean[] visited = new boolean[verticesNumber];

        for(int i = 0; i< verticesNumber; i++){
            visited[i] = false;
        }
        Queue vertexQueue = new Queue();

        vertexQueue.enqueue(v);

        visited[v] = true;

        while(!vertexQueue.isEmpty()){
            int w = vertexQueue.getFront();
            System.out.print(w+" ");
            vertexQueue.dequeue();

            int[] adj = findAdjacencyVertices(w);

            for(int u: adj){
                if(!visited[u]){
                    vertexQueue.enqueue(u);
                    visited[u] = true;
                }
            }
        }
    }



    private int minDistance(boolean[] visited, int[] distance){
        int index = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<verticesNumber; i++){
            if(!visited[i]){
                if(distance[i] <= min){
                    min = distance[i];
                    index = i;
                }
            }
        }
        return index;
    }

    // DIJKSTRAS ALGORITHM
    public void allShortestPath(int[] p, int[] d, int v){
        boolean[] visited = new boolean[verticesNumber];

        for(int i = 0; i<verticesNumber; i++){
            visited[i] = false;
            p[i] = -1;
            d[i] = Integer.MAX_VALUE;
        }
        d[v] = 0;

        for(int i = 0; i<verticesNumber; i++){
            int w = minDistance(visited, d);
            visited[w] = true;

            int[] adj = findAdjacencyVertices(w);
            for(int u: adj){
                if(!visited[u]){
                    if(d[w] + matrix[w][u] < d[u]){
                        d[u] = d[w]+matrix[w][u];
                        p[u] = w;
                    }
                }
            }
        }
    }

    public int[] getPath(int s, int t, int p[]){
        int[] shortestPath = new int[p.length];
        int current = t;
        int total = 0;
        while(current != s){
            shortestPath[total] = current;
            current = p[current];
            total++;
        }
        shortestPath[total++] = s;
        shortestPath = Arrays.copyOf(shortestPath, total);

        for(int i = 0; i< total/2; i++){
            int temp = shortestPath[i];
            shortestPath[i] = shortestPath[total-1-i];
            shortestPath[total-1-i] = temp;
        }
        return shortestPath;
    }

    public int TSP_exhaustiveSearch(int[] shortestRoute){
        for(int i = 0; i<verticesNumber; i++) {
            shortestRoute[i] = i;
      }
        int[] a = new int[verticesNumber];

        TSP_exhaustiveSearch(shortestRoute,a,0);
      return totalDistance(shortestRoute);
    }

    int totalDistance(int[] a){
        int n = verticesNumber;

        int totalWeight = 0;
        for(int i = 0; i<n; i++){
            int weight = matrix[a[i]][a[(i+1)%n]];
            totalWeight+=weight;
        }
        return totalWeight;
    }

    private void TSP_exhaustiveSearch(int[] shortestRotue, int[] a, int k){
        if (k==a.length){
            if(totalDistance(a) < totalDistance(shortestRotue)){
                System.arraycopy(a, 0, shortestRotue, 0, verticesNumber);
            }
            System.out.println(totalDistance(a)+" ");
            printArray(a);
        }else{
            ArrayList<Integer> Sk = constructCandidateSet(a,k);
            for(int s: Sk){
                a[k] = s;
                TSP_exhaustiveSearch(shortestRotue, a,k+1);
            }
        }
    }

    private ArrayList<Integer> constructCandidateSet(int[] a, int k){
        ArrayList<Integer> candidates = new ArrayList<>();
        boolean[] b = new boolean[a.length];

        for(int i = 0; i<k; i++){
            b[a[i]] = true;
        }
        for(int i = 0; i<k; i++){
            if(!b[i]) candidates.add(i);
        }
        return candidates;
    }


    public int TSP_randomSampling(int[] shortestRoute){
        int numberOfSamples = 10;
        int bestDistance = Integer.MAX_VALUE;
        for(int i = 0; i<numberOfSamples; i++){
            int[] a = new int[verticesNumber];
            randomPermutation(a);
            int currentDistance = totalDistance(a);

            if(currentDistance < bestDistance){
                bestDistance = currentDistance;
                System.out.println("Best distance:"+ bestDistance);
                System.arraycopy(a,0,shortestRoute,0,verticesNumber);
            }
        }
        return bestDistance;
    }
    // Prog 19_02
    public void randomPermutation(int[] a){
        for(int i = 0; i<a.length; i++) {
            a[i] = i;
        }
        for(int i = a.length-1; i>0; i--){
            int randomLoc = ran.nextInt(i+1);

            if(randomLoc != i){
                int temp = a[i];
                a[i] = a[randomLoc];
                a[randomLoc] = temp;
        }
        }
    }

    //Prog 19_05
    public int TSP_localSearch(int[] shortestRoute){
        int bestDistance;

        int[] a = new int[verticesNumber];
        randomPermutation(a);
        System.out.println(Arrays.toString(a));

        System.arraycopy(a,0,shortestRoute,0,verticesNumber);
        bestDistance = totalDistance(shortestRoute);

        boolean betterSolutionFound;

        do {
            betterSolutionFound = false;
            Prog19_04PermutationNeighborhood pn = new Prog19_04PermutationNeighborhood(shortestRoute);
            while (pn.hasNext()) {
                a = pn.next();
                int currentDistance = totalDistance(a);
                if (currentDistance < bestDistance) {
                    System.arraycopy(a, 0, shortestRoute, 0, verticesNumber);
                    bestDistance = currentDistance;
                    betterSolutionFound = true;
                }
            }
        }while (betterSolutionFound) ;
        return bestDistance;
        }

    private void printArray(int[] a){
        for(int v: a){
            System.out.print(v+" ");
        }
        System.out.println();
    }

}