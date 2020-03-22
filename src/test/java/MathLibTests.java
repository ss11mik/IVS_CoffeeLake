import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MathLibTests {

    @Test
    public void testAdd()
    {
        assertEquals(7, MathLib.add(5,2), 0);
        assertEquals(-3, MathLib.add(5,-8), 0);
        assertEquals(-3, MathLib.add(-5,2), 0);
        assertEquals(2, MathLib.add(0,2), 0);
        assertEquals(0, MathLib.add(0,0), 0);
        assertEquals(9999999, MathLib.add(7777777,2222222), 0);
    }

    @Test
    public void testSub()
    {
        assertEquals(5, MathLib.sub(10,5), 0);
        assertEquals(-2, MathLib.sub(7,9), 0);
        assertEquals(16, MathLib.sub(7,-9), 0);
        assertEquals(-16, MathLib.sub(-9,7), 0);
        assertEquals(0, MathLib.sub(0,0), 0);
        assertEquals(-9999999, MathLib.sub(-7777777,2222222), 0);
    }
}