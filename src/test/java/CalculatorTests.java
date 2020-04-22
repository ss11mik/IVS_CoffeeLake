import cz.vutbr.fit.ivs.Calculator;
import cz.vutbr.fit.ivs.MathLib;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTests {

    private static double TESTS_PRECISION = 0.00000001;

    @Test
    public void testConstructor() {
        Calculator calculator = new Calculator();
    }

    @Test
    public void testInserting() {
        Calculator calculator = new Calculator();

        for (int i = 8; i > 0; i--)
            calculator.add(String.valueOf(i));

        assertEquals(calculator.getValue(), 12345678, TESTS_PRECISION);
   }

    @Test
    public void test2Operations1() {
        Calculator calculator = new Calculator();

        calculator.add("2");
        calculator.add("+");
        calculator.add("3");
        calculator.add("*");
        calculator.add("2");

        assertEquals(calculator.getValue(), 10);
    }

    @Test
    public void test2Operations2() {
        Calculator calculator = new Calculator();

        calculator.add("10");
        calculator.add("/");
        calculator.add("2");
        calculator.add("+");
        calculator.add("3");

        assertEquals(calculator.getValue(), 8);
    }

    @Test
    public void test2Operations3() {
        Calculator calculator = new Calculator();

        calculator.add("10");
        calculator.add("*");
        calculator.add("2");
        calculator.add("+");
        calculator.add("10");

        assertEquals(calculator.getValue(), 30);
    }

    @Test
    public void test2Operations4() {
        Calculator calculator = new Calculator();

        calculator.add("10");
        calculator.add("^");
        calculator.add("2");
        calculator.add("*");
        calculator.add("10");

        assertEquals(calculator.getValue(), 1000);
    }

    @Test
    public void test2Operations4() {
        Calculator calculator = new Calculator();

        calculator.add("10");
        calculator.add("^");
        calculator.add("2");
        calculator.add("*");
        calculator.add("10");

        assertEquals(calculator.getValue(), 1000);
    }

    @Test
    public void test3Operations() {
        Calculator calculator = new Calculator();

        calculator.add("1");
        calculator.add("*");
        calculator.add("10");
        calculator.add("+");
        calculator.add("2");
        calculator.add("/");
        calculator.add("2");

        assertEquals(calculator.getValue(), 6);
    }
}
