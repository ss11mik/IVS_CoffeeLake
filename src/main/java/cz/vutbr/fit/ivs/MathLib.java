package cz.vutbr.fit.ivs;

/**
 * The backend class providing wrappers for mathematical operations
 * All methods are to be accessed as static, thereby it is not needed to initialise this class
 *
 * @author Ondřej Mikula, Marek Lohn, René Szotkowski
 */
public class MathLib {

    /**
     * Router method, which calls method specified by operation param
     * @param a first operand
     * @param b second operand, redundant in some cases
     * @param operation the operation to be made, one of constants from {@link cz.vutbr.fit.ivs.Operations}
     * @return the result of requested operation
     */
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
                return sqrt(a);
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

    /**
     * Adds a to b
     * @param a first number
     * @param b second number
     * @return a + b
     */
    public static double add (double a, double b) {
        return a + b;
    }

    /**
     * Substracts b from a
     * @param a first number
     * @param b second number
     * @return a - b
     */
    public static double sub(double a, double b) {
        return a - b;
    }

    /**
     * Calculates multiplication of two numbers
     * @param a first number
     * @param b second number
     * @return a times b
     */
    public static double multiply(double a, double b) {
        return a * b;
    }

    /**
     * Calculates division of a by b
     * @param a divided number
     * @param b divisor
     * @return division of a by b if applicable
     * @throws ArithmeticException when divisor is zero
     */
    public static double divide(double a, double b) throws ArithmeticException {
        return a / b;
    }

    /**
     * Calculates square root by custom implemented algorithm
     * @param a the value to be rooted
     * @return square root
     */
    public static double sqrt(double a) {
        if(a <= 0)
            return 0;
        double temp;
        double sr = a / 2;
        do {
            temp = sr;
            sr = (temp + (a / temp)) / 2;
        }while((temp - sr) != 0);
        return sr;
    }

    /**
     * Calculates factorial for given value
     * @param a the parameter to be factorized
     * @return 1 for a <= 0, else factorial
     */
    public static long fact(long a) {
        if(a <= 0)
            return 1;
        return fact(a-1) * a;
    }

    /**
     * Calculates b'th power of a
     * @param a base
     * @param b exponent
     * @return powered value
     */
    public static long pow(long a, long b) {
        if (a == 0)
            return 0;
        long j = 1;
        for (long i = 0; i < b; ++i) {
            j *= a;
        }
        return j;
    }

    /**
     * Calculates modulo
     * @param a base value
     * @param b modulator
     * @return modulo of a by b
     */
    public static double mod(double a, double b) {
        return a % b;
    }
}
