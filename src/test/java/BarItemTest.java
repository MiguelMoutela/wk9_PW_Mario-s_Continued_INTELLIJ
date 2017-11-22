import Bar.BarItem;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BarItemTest {
    BarItem coke;

    @Before
    public void before() {
        coke = new BarItem(5,1);
    }
    @Test
    public void canGetPrice() {
        assertEquals(5, coke.getPrice(), 0.01);
    }
    @Test
    public void canGetQuantity() {assertEquals(1,coke.getQuantity());}
    @Test
    public void canSetQuantity() {
        coke.setQuantity(10);
        assertEquals(10, coke.getQuantity());
    }
}