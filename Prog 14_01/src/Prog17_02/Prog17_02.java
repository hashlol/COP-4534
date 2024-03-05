package Prog17_02;

public class Prog17_02 {
    public static void main(String[] args){
        new Prog17_02();
    }

    public Prog17_02(){
        int TOTAL = 10;
        int spaces = TOTAL;

        for(int n = 0; n<=TOTAL; n++){
            for(int i = spaces; i> 0; i--){
                System.out.print(" ");
            }

            for(int k = 0; k<=n; k++){
                System.out.print(" "+binomialCoefficient(n,k) + " ");
            }
            System.out.println();
            spaces--;
        }
    }

    public long binomialCoefficient(int n, int k){
        if(n<k) return 0;
        else
            if (n==k) return 1;
        else{
            long[][] coef = new long[n+1][n+1];

            for(int i = 0; i<=n; i++){
                coef[i][0] = 1;
                coef[i][i] = 1;
            }
            for(int i =2; i<=n; i++){
                for(int j = 1; j<=k; j++){
                    coef[i][j] = coef[i-1][j-1]+coef[i-1][j];
                }
            }
            return coef[n][k];
            }

    }
}
