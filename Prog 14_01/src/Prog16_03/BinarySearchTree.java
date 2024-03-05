package Prog16_03;
import Prog16_03.Node;
import Prog16_03.Queue;
/**
 * BinarySearchTree class. Implements a binary search tree.
 *
 * @author A. Hernandez. COP4534 Algorithm Techniques
 */
public class BinarySearchTree
{
    private Node root;    //root of the BST; implemented as a dummy node.
    private int numberOfElements; //number of elements in the BST

    public BinarySearchTree()
    {
        root = new Node();        //dummy node as the root
        root.setLeftChild(null);
        root.setRightChild(null);
        root.setInfo(-1);
        numberOfElements = 0;
    }

    public boolean isEmpty()
    {
        return root.getLeftChild() == null;
    }

    public void preorder()
    {
        preorder(root.getLeftChild());
        System.out.println();
    }    
    
    public void BFS()
    {
        Queue q = new Queue();
        
        if (root.getLeftChild() != null)
        {
            q.enqueue(root.getLeftChild());
            while (!q.isEmpty())
            {
               Node p = q.getFront();
               q.dequeue();
               
               System.out.print(p.getInfo() + " ");
               if (p.getLeftChild() != null) q.enqueue(p.getLeftChild());
               if (p.getRightChild() != null) q.enqueue(p.getRightChild());
            }
            
            System.out.println();
        }
                
    }
        
    public String toString()
    {
        return toString(root.getLeftChild());
    }

    public void add(int x)
    {
        numberOfElements++;
        
        if (root.getLeftChild() == null)
        {
            Node p = new Node();
            p.setNode(x, null, null);
            root.setLeftChild(p);
        } else
            add(x, root.getLeftChild());
    }
    
    private void preorder(Node p)
    {
        if (p != null)
        {
            System.out.print(p.getInfo() + " ");
            preorder(p.getLeftChild());
            preorder(p.getRightChild());
        }
    }    
   
    private String toString(Node p)
    {
        if (p != null)
        {
            return toString(p.getLeftChild()) +
                   p.getInfo() + " " +
                   toString(p.getRightChild());
        }
        else return "";
    }

    private void add(int x, Node p)
    {
        if (x < p.getInfo())
            if (p.getLeftChild() == null)
            {
                Node q = new Node();
                q.setNode(x, null, null);
                p.setLeftChild(q);
            } else
                add(x, p.getLeftChild());
        else if (p.getRightChild() == null)
        {
            Node q = new Node();
            q.setNode(x, null, null);
            p.setRightChild(q);
        } else
            add(x, p.getRightChild());
    }    

    public int getNumberOfElements()
    {
        return numberOfElements;
    }

    /**
     * Prints all paths from the root to a leaf
     */
    public void printAllPathsFromRootToLeaves()
    {
        if (isEmpty()) return;
        
        Node[] a = new Node[getNumberOfElements()+1];
        a[0] = root.getLeftChild();
        printAllPathsFromRootToLeaves(a, 1);
    }
    
    /**
     * Recursive method.
     * 
     * @param a array with addresses of Node objects visited along this path
     * @param k number of Nodes visited along this path
     */
    private void printAllPathsFromRootToLeaves(Node[] a, int k )
    {
        Node left  = a[k-1].getLeftChild();
        Node right = a[k-1].getRightChild();

        if (left == null && right == null) //a[k-1] is a leaf, print node
            printPath(a, k);
        else
        {
            if(left != null)
            {
                a[k] = left;
                printAllPathsFromRootToLeaves(a, k+1);
            }

            if(right != null)
            {
                a[k] = right;
                printAllPathsFromRootToLeaves(a, k+1);
            }
        }
    }
    
    /**
     * Prints info in nodes along the given path.
     * 
     * @param a array that contains nodes in a path from the root to a leaf
     * @param k number of nodes in path
     */
    private void printPath(Node[] a, int k)
    {
        for(int i=0; i<k-1; i++)
        {
            System.out.print(a[i].getInfo() + " -> ");
        }
        
        System.out.println(a[k-1].getInfo());
    }
    public void improperMaxSumPathFromRootToLeaves(){
        int sum = 0;
        while(root != null){
            if(root.getLeftChild() == null){
                if(root.getRightChild() != null) {
                    sum += root.getRightChild().getInfo();
                    root = root.getRightChild();
                }else{
                    break;
                }
            }
            if(root.getRightChild() == null){
                if(root.getLeftChild() != null) {
                    sum += root.getLeftChild().getInfo();
                    root = root.getLeftChild();
                }else{
                    break;
                }
            }
            if(root.getLeftChild().getInfo() > root.getRightChild().getInfo() && (root.getRightChild() != null & root.getLeftChild() != null)){
                sum += root.getLeftChild().getInfo();
                root = root.getLeftChild();
            }else if(root.getRightChild().getInfo() > root.getLeftChild().getInfo() && (root.getRightChild() != null & root.getLeftChild() != null) ){
                sum += root.getRightChild().getInfo();
                root = root.getRightChild();
            }else{
                break;
            }
        }
        System.out.println(sum);
    }

    public void maxSumPathFromRootToLeaves(Node[] a, int k){

        Node left = a[k-1].getLeftChild();
        Node right = a[k-1].getRightChild();

        if(left == null && right == null){
            printAllPathsFromRootToLeaves(a,k);
        }else{
            if(right != null){
                a[k] = right;
                maxSumPathFromRootToLeaves(a,k+1);
            }else{
                a[k] = left;
                maxSumPathFromRootToLeaves(a, k+1);
            }
        }

    }
}
