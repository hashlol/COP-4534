package Prog21_01;

public class Prog21_01 {
    public static void main(String[] args){
        new Prog21_01();
    }
    double tolerance = 0.0001;

    public Prog21_01(){
        System.out.printf("Tolerance = %f\n", tolerance);
        System.out.println("sqrt(2) = " + squareRoot(2));
        System.out.println("sqrt_M(2) = " + Math.sqrt(2));

    }

    public double squareRoot(double x){
        double a = 0;
        double b = x;
        double sqrt;

        do{
            sqrt = (a+b)/2;
            if (sqrt*sqrt < x) a=sqrt;
            else b = sqrt;
        }while( (b-a) > tolerance);
        return sqrt;
    }
}
