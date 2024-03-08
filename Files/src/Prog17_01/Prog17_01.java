package Prog17_01;

public class Prog17_01 {
    public static void main(String[] args){
        new Prog17_01();
    }

    private final int MAX_N = 90;
    private final int UNKNOWN = -1;
    private long[] fib = new long[MAX_N + 1];
    public Prog17_01(){
        fib[0] = 0;
        fib[1] = 1;

        for(int i = 2; i<= MAX_N; i++){
            fib[i] = UNKNOWN;
        }

        for(int i = 0; i<80; i++){
            System.out.println("Fib("+i+") = "+fibonacci(i));
        }


    }

    private long fibonacci(int n){
        if(fib[n] == UNKNOWN){
            fib[n] = fibonacci(n-1) + fibonacci(n-2);
        }
        return fib[n];
    }

    public long fiboacci_constant_memory(int n){
        if (n<=1) return n;

        long f0 = 0;
        long f1 = 1;
        long f2 = f1+f0;

        for(int i =3; i<=n; i++){
            f0 = f1;
            f1=f2;
           //
        }
        return 10;
    }
}

