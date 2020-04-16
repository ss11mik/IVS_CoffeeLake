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


}
