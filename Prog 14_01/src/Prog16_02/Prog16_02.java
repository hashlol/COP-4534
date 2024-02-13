package Prog16_02;

import java.util.ArrayList;

public class Prog16_02 {
    int count = 0;
    public static void main(String[] args){
        new Prog16_02();
    }

    public Prog16_02(){
        int n = 8;
        printPermutation(n);
    }

    public void printPermutation(int n){
        int[] a = new int[n];
        printPermutation(a,0);
    }

    public void printPermutation(int[] a, int k){
        if(k == a.length){
            printArray(a);
        }else{
            ArrayList<Integer> sk = constructCandidateSet(a,k);
            for(int s: sk){
                a[k] =s;
                printPermutation(a, k+1);
            }
        }
    }
    private ArrayList<Integer> constructCandidateSet(int[] a, int k){
        ArrayList<Integer> candidates = new ArrayList<>();
        boolean[] b = new boolean[a.length];
        for(int i = 0; i<k;i++){
            b[a[i]] = true;
        }
        for(int i = 0; i<a.length;i++){
            if(!b[i]) candidates.add(i);
        }
        return candidates;
    }

    private void printArray(int[] a){
        System.out.printf("%4d: ", ++count);
        for(int v: a){
            System.out.print(v+ " ");
        }
        System.out.println();
    }
}