public class MathLib {

    public static double add (double a, double b) {
        return a + b;
    }

    public static double sub(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) throws ArithmeticException {
        return a / b;
    }

    public static double sqrt(double a, double b) {
        //TODO use of Java Math permitted?
        return 0;
    }

    public static long fact(long a) {
        if(a <= 0)
            return 1;
        return fact(a-1) * a;
    }

    public static long pow(long a, long b) {
        if (a == 0)
            return 0;
        long j = 1;
        for (long i = 0; i < b; ++i) {
            j *= a;
        }
        return j;
    }

    public static double mod(double a, double b) {
        return a % b;
    }
}
