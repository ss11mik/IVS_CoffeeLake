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
        calculator.add("2");
        calculator.add("+");
        calculator.add("1");
        assertEquals(calculator.getValue(), 3, TESTS_PRECISION);

        calculator.add("1");
        calculator.calculateAndSetText();
        assertEquals(calculator.getValue(), 12345679, TESTS_PRECISION);

        calculator.add("-");
        assertEquals(calculator.getValue(), 0, TESTS_PRECISION);

        calculator.add("1");
        calculator.add("0");
        calculator.calculateAndSetText();
        assertEquals(calculator.getValue(), 12345669, TESTS_PRECISION);
    }

    @Test
    public void testInserting() {

        for (int i = 8; i > 0; i--)
            calculator.add(String.valueOf(i));

        assertEquals(calculator.getValue(), 12345678, TESTS_PRECISION);

        calculator.add("+");
        assertEquals(calculator.getValue(), 0, TESTS_PRECISION);

        calculator.add("1");
        calculator.calculateAndSetText();
        assertEquals(calculator.getValue(), 12345679, TESTS_PRECISION);

        calculator.add("-");
        assertEquals(calculator.getValue(), 0, TESTS_PRECISION);

        calculator.add("1");
        calculator.add("0");
        calculator.calculateAndSetText();
        assertEquals(calculator.getValue(), 12345669, TESTS_PRECISION);
   }

    @Test
    public void test2Operations1() {
        calculator.add("2");
        calculator.add("+");
        calculator.add("3");
        calculator.add("*");
        calculator.add("2");
        calculator.add("=");

        assertEquals(calculator.getValue(), 10, TESTS_PRECISION);
    }

    @Test
    public void test2Operations2() {
        calculator.add("10");
        calculator.add("/");
        calculator.add("2");
        calculator.add("+");
        calculator.add("3");
        calculator.add("=");

        assertEquals(calculator.getValue(), 8, TESTS_PRECISION);
    }

    @Test
    public void test2Operations3() {
        calculator.add("10");
        calculator.add("*");
        calculator.add("2");
        calculator.add("+");
        calculator.add("10");
        calculator.add("=");

        assertEquals(calculator.getValue(), 30, TESTS_PRECISION);
    }

    @Test
    public void test2Operations4() {
        calculator.add("10");
        calculator.add("^");
        calculator.add("2");
        calculator.add("*");
        calculator.add("10");
        calculator.add("=");

        assertEquals(calculator.getValue(), 1000, TESTS_PRECISION);
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

        assertEquals(calculator.getValue(), 6, TESTS_PRECISION);
    }
}
