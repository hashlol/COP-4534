package Prog18_01;

public interface GraphInterface
{
    public void addEdge(int v, int w);
    public void removeEdge(int v, int w);
    public int[] findAdjacencyVertices(int v);
    public String toString();
}