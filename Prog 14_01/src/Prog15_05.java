import java.math.BigInteger;

public class Prog15_05 {
    BigInteger ZERO = BigInteger.ZERO;
    BigInteger ONE = BigInteger.ONE;
    BigInteger TWO = BigInteger.TWO;

    public static void main(String[] args) {
        new Prog15_05();
    }
    // Deterministic
    public Prog15_05() {
        BigInteger n;
        BigInteger FIRST = new BigInteger("10000000000000819");
        BigInteger LAST = new BigInteger("170141183460469231731687303715884105727");

        for (n = FIRST; n.compareTo(LAST) <= 0; n = n.add(ONE)) {
            if (isPrime(n)) {
                System.out.println(n);
            }
        }
    }

    public boolean isPrime(BigInteger n) {
        BigInteger s = n.sqrt();

        if (n.compareTo(ONE) <= 0) return false;

        BigInteger i;

        for (i = TWO; i.compareTo(s) <= 0; i = i.add(ONE)) {
            if (n.mod(i).compareTo(ZERO) == 0) {
                return false;
            }
        }
        return true;
    }
}