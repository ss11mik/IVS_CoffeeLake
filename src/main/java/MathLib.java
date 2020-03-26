public class MathLib {

    public static double calculate (double a, double b, int operation) {
        switch (operation) {
            case Operations.ADD:
                return add(a, b);
            case Operations.SUB:
                return sub(a, b);
            case Operations.MUL:
                return multiply(a, b);
            case Operations.DIV:
                return divide(a, b);
            case Operations.SQRT:
                return sqrt(a, b);
            case Operations.FACT:
                return fact((long) b);
            case Operations.POW:
                return pow((long) a, (long) b);
            case Operations.MOD:
                return mod(a, b);
            default:
                return b;
        }
    }

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
