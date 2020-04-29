import cz.vutbr.fit.ivs.Calculator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTests {

    private static double TESTS_PRECISION = 0.00000001;
    Calculator calculator;

    @Before
    public void before() {
        calculator = new Calculator();
    }


    @Test
    public void testSequence() {
        calculator.reset();
        calculator.add("2");
        calculator.add("+");
        calculator.add("1");
        calculator.calculateAndSetText();
        calculator.resetMemory();
        assertEquals(3, calculator.getValue(), TESTS_PRECISION);

        calculator.add("+");
        calculator.add("1");
        calculator.calculateAndSetText();
        calculator.resetMemory();
        assertEquals(4, calculator.getValue(), TESTS_PRECISION);

        calculator.add("-");
        calculator.add("3");
        calculator.calculateAndSetText();
        calculator.resetMemory();
        assertEquals(1, calculator.getValue(), TESTS_PRECISION);

        calculator.add("*");
        calculator.add("1");
        calculator.add("0");
        calculator.calculateAndSetText();
        calculator.resetMemory();
        assertEquals(10, calculator.getValue(), TESTS_PRECISION);
    }

    @Test
    public void testInserting() {
        calculator.reset();
        for (int i = 8; i > 0; i--)
            calculator.add(String.valueOf(i));

        assertEquals(87654321, calculator.getValue(), TESTS_PRECISION);

        calculator.add("+");
        assertEquals(0, calculator.getValue(), TESTS_PRECISION);

        calculator.add("1");
        calculator.calculateAndSetText();
        calculator.resetMemory();
        assertEquals(87654322, calculator.getValue(), TESTS_PRECISION);

        calculator.add("-");
        assertEquals(0, calculator.getValue(), TESTS_PRECISION);

        calculator.add("1");
        calculator.add("0");
        calculator.calculateAndSetText();
        calculator.resetMemory();
        assertEquals(87654312, calculator.getValue(), TESTS_PRECISION);
    }

    @Test
    public void test2Operations1() {
        calculator.add("2");
        calculator.add("+");
        calculator.add("3");
        calculator.add("*");
        calculator.add("2");
        calculator.add("=");

        assertEquals(10, calculator.getValue(), TESTS_PRECISION);
    }

    @Test
    public void test2Operations2() {
        calculator.add("10");
        calculator.add("/");
        calculator.add("2");
        calculator.add("+");
        calculator.add("3");
        calculator.add("=");

        assertEquals(8, calculator.getValue(), TESTS_PRECISION);
    }

    @Test
    public void test2Operations3() {
        calculator.add("10");
        calculator.add("*");
        calculator.add("2");
        calculator.add("+");
        calculator.add("10");
        calculator.add("=");

        assertEquals(30, calculator.getValue(), TESTS_PRECISION);
    }

    @Test
    public void test2Operations4() {
        calculator.add("10");
        calculator.add("^");
        calculator.add("2");
        calculator.add("*");
        calculator.add("10");
        calculator.add("=");

        assertEquals(1000, calculator.getValue(), TESTS_PRECISION);
    }

    @Test
    public void test3Operations() {
        calculator.add("1");
        calculator.add("*");
        calculator.add("10");
        calculator.add("+");
        calculator.add("2");
        calculator.add("/");
        calculator.add("2");
        calculator.add("=");

        assertEquals(6, calculator.getValue(), TESTS_PRECISION);
    }
}
