import Menu.Dish;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DishTest {
    Dish dish;
    @Before
    public void before() {
        dish = new Dish("fish&chips", 5);
    }
    @Test
    public void canGetName() {
        assertEquals("fish&chips", dish.getName());
    }
    @Test
    public void canGetPrice() {
        assertEquals(5, dish.getPrice(), 0.01);
    }
}
