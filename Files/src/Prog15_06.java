import java.math.BigInteger;
import java.util.Random;

public class Prog15_06 {
    // Randomized
    BigInteger ZERO = BigInteger.ZERO;
    BigInteger ONE = BigInteger.ONE;
    BigInteger TWO = BigInteger.TWO;
    Random rangen = new Random();
    public Prog15_06(){
        isProbablyPrime(40,80807);
    }
    public static void main(String[] args){
        new Prog15_06();
    }

    public  boolean isProbablyPrime(int n, int iterations){
        if(n <=1) return false;
        if (n==2) return true;

        for(int i = 0; i<iterations; i++){
          int a =  2+rangen.nextInt(n-2);
          if((Math.pow(a, n-1) % n) != 1){
              System.out.println(a);
              return false;
            }
        }
        return true;
    }
}
