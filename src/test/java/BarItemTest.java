import Bar.BarItem;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BarItemTest {
    BarItem barItem;

    @Before
    public void before() {
        barItem = new BarItem("thatDrink", 5,6);
    }

    @Test
    public void canGetNameToLowerCase() {
        assertEquals("thatdrink", barItem.getName());
    }

    @Test
    public void canGetPrice() {
        assertEquals(5, barItem.getPrice(), 0.01);
    }
    @Test
    public void canGetQuantity() {assertEquals(6,barItem.getQuantity());}
}