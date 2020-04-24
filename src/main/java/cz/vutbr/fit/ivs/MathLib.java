package cz.vutbr.fit.ivs;

/**
 * The backend class providing wrappers for mathematical operations
 * All methods are to be accessed as static, thereby it is not needed to initialise this class
 *
 * @author Ondřej Mikula, Marek Lohn, René Szotkowski
 */
public class MathLib {

    public static final double PRECISION = 0.00000001;

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
                return sqrt(a, (int) b);        //TODO better calling logic
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
     * Calculates division of a by divisor
     * @param divided divided number
     * @param divisor divisor
     * @return division of divided number by divisor if applicable
     * @throws ArithmeticException when divisor is zero
     */
    public static double divide(double divided, double divisor) throws ArithmeticException {
        return divided / divisor;
    }

    /**
     * Calculates n'th root by custom implemented algorithm
     * @param a the value to be rooted
     * @param b b'th root
     * @return -1 for negative value, else b'th root of a with precision PRECISION
     */
    public static double sqrt(double a, int b) {
        if(a < 0)
            return -1;
        if(a == 0)
            return 0;
        double temp = a;
        double sr = a / b;
        while (Math.abs(temp - sr) > PRECISION){
            temp = sr;
            sr = ((b - 1.0) * sr + a / Math.pow(sr, b - 1.0)) / b;
        };
        return sr;
    }

    /**
     * Calculates factorial for given value
     * Works only for integer parameter
     * @param a the parameter to be factorized
     * @return 1 for a <= 0, else factorial
     */
    public static double fact(double a) {
        if(a <= 0)
            return 1;
        return fact(a-1) * a;
    }

    /**
     * Calculates n'th power of base
     * Works only for integer exponent
     * @param base base
     * @param exponent exponent
     * @return powered value (= base ^ exponent)
     */
    public static double pow(double base, double exponent) {
        if (base == 0)
            return 0;
        long j = 1;
        for (long i = 0; i < exponent; ++i) {
            j *= base;
        }
        return j;
    }

    /**
     * Calculates modulo
     * @param base base value
     * @param modulator modulator
     * @return modulo of base by modulator
     */
    public static double mod(double base, double modulator) {
        return base % modulator;
    }
}
