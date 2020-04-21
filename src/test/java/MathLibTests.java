import cz.vutbr.fit.ivs.MathLib;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MathLibTests {

    private static double TESTS_PRECISION = 0.00000001;

    @Test
    public void testAdd() {
        assertEquals(7, MathLib.add(5,2), 0);
        assertEquals(-3, MathLib.add(5,-8), 0);
        assertEquals(-3, MathLib.add(-5,2), 0);
        assertEquals(2, MathLib.add(0,2), 0);
        assertEquals(0, MathLib.add(0,0), 0);
        assertEquals(9999999, MathLib.add(7777777,2222222), 0);

        assertEquals(1.1, MathLib.add(1, 0.1), TESTS_PRECISION);
        assertEquals(1.9, MathLib.add(1.8, 0.1), TESTS_PRECISION);
        assertEquals(2.3, MathLib.add(0, 2.3), TESTS_PRECISION);
    }

    @Test
    public void testSub() {
        assertEquals(5, MathLib.sub(10,5), 0);
        assertEquals(-2, MathLib.sub(7,9), 0);
        assertEquals(16, MathLib.sub(7,-9), 0);
        assertEquals(-16, MathLib.sub(-9,7), 0);
        assertEquals(0, MathLib.sub(0,0), 0);
        assertEquals(-9999999, MathLib.sub(-7777777,2222222), 0);

        assertEquals(-2.3, MathLib.sub(0, 2.3), TESTS_PRECISION);
        assertEquals(2.3, MathLib.sub(0, -2.3), TESTS_PRECISION);
        assertEquals(-12.3, MathLib.sub(-10, 2.3), TESTS_PRECISION);
    }

    @Test
    public void testMultiply() {
        assertEquals(50, MathLib.multiply(10,5), 0);
        assertEquals(-50, MathLib.multiply(-10,5), 0);
        assertEquals(-50, MathLib.multiply(10,-5), 0);
        assertEquals(50, MathLib.multiply(-10,-5), 0);

        assertEquals(0, MathLib.multiply(10,0), 0);
        assertEquals(0, MathLib.multiply(-10,0), 0);
        assertEquals(0, MathLib.multiply(0,0), 0);
        assertEquals(0, MathLib.multiply(0.4,0), 0);
        assertEquals(0, MathLib.multiply(69156541.785745,0), 0);

        assertEquals(0.01, MathLib.multiply(0.1,0.1), TESTS_PRECISION);
        assertEquals(1.0989, MathLib.multiply(1.1,0.999), TESTS_PRECISION);
        assertEquals(399.6, MathLib.multiply(400,0.999), TESTS_PRECISION);
        assertEquals(172839.160494, MathLib.multiply(222.222,777.777), TESTS_PRECISION);
        assertEquals(-172839.160494, MathLib.multiply(-222.222,777.777), TESTS_PRECISION);
    }

    @Test
    public void testDivide() {
        assertEquals(2, MathLib.divide(10,5), 0);
        assertEquals(-2, MathLib.divide(-10,5), 0);
        assertEquals(-2, MathLib.divide(10,-5), 0);
        assertEquals(2, MathLib.divide(-10,-5), 0);

        assertEquals(0, MathLib.divide(0,5), 0);
        assertEquals(0, MathLib.divide(0,-5), 0);

        assertEquals(1, MathLib.divide(0.1,0.1), 0);
        assertEquals(1.1011011011, MathLib.divide(1.1,0.999), TESTS_PRECISION);
        assertEquals(64, MathLib.divide(65536,1024), 0);
        assertEquals(0.285714285714, MathLib.divide(222.222,777.777), TESTS_PRECISION);
        assertEquals(-0.285714285714, MathLib.divide(-222.222,777.777), TESTS_PRECISION);


        assertEquals(Double.POSITIVE_INFINITY, MathLib.divide(1,0), 0);
        assertEquals(Double.NEGATIVE_INFINITY, MathLib.divide(-10,0), 0);
        assertEquals(Double.NaN, MathLib.divide(0,0), 0);
    }

    @Test
    public void testFact() {
        assertEquals(120, MathLib.fact(5));
        assertEquals(1, MathLib.fact(0));
        assertEquals(1, MathLib.fact(1));
        assertEquals(1, MathLib.fact(-1));
        assertEquals(479001600, MathLib.fact(12));
    }

    @Test
    public void testSqrt() {
        assertEquals(1, MathLib.sqrt(1), 0);
        assertEquals(0, MathLib.sqrt(0), 0);
        assertEquals(10, MathLib.sqrt(100), 0);
        assertEquals(0, MathLib.sqrt(-1), 0);
        assertEquals(0, MathLib.sqrt(-999), 0);
        assertEquals(8, MathLib.sqrt(64), 0);
        assertEquals(1.41421356, MathLib.sqrt(2), TESTS_PRECISION);
        assertEquals(351.3630601, MathLib.sqrt(123456), 0.00000001);
    }

    @Test
    public void testPow() {
        assertEquals(1, MathLib.pow(1, 0));
        assertEquals(1, MathLib.pow(888, 0));
        assertEquals(1, MathLib.pow(1, 888));
        assertEquals(256, MathLib.pow(2, 8));
        assertEquals(65536, MathLib.pow(2, 16));
        assertEquals(0, MathLib.pow(0, 4096));
        assertEquals(0, MathLib.pow(0, 0));
    }

    @Test
    public void testMod() {
        assertEquals(1, MathLib.mod(1, 8), 0);
        assertEquals(1, MathLib.mod(9, 8), 0);
        assertEquals(0, MathLib.mod(64, 32), 0);

        assertEquals(0.1, MathLib.mod(1.1, 1), TESTS_PRECISION);
        assertEquals(0, MathLib.mod(64.64, 32.32), TESTS_PRECISION);

        assertEquals(0, MathLib.mod(64, -32), 0);
        assertEquals(0, MathLib.mod(-64, 32), 0);
        assertEquals(0, MathLib.mod(-64, -32), 0);

        assertEquals(Double.NaN, MathLib.mod(1, 0), 0);
        assertEquals(Double.NaN, MathLib.mod(0, 0), 0);
        assertEquals(Double.NaN, MathLib.mod(-1, 0), 0);
    }
}
