import org.junit.Before;
import org.junit.Test;
import Restaurant.Restaurant;
import Menu.Menu;

import static org.junit.Assert.assertEquals;

public class RestaurantTest {
    Restaurant restaurant;
    Menu menu;

    @Before
    public void before(){
        menu = new Menu();
        restaurant = new Restaurant("Mario's",menu);
    }
    @Test
    public void canGetName() {
        assertEquals("Mario's", restaurant.getName());
    }
    @Test
    public void canGetTurnover() {
        assertEquals(0, restaurant.getTurnover(), 0.01);
    }
}
