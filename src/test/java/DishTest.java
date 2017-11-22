import Kitchen.Ingredient;
import Menu.Dish;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class DishTest {
    Dish dish;
    Ingredient fish;
    Ingredient chips;

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
    @Test
    public void canAddToAndGetListOfIngredients() {
        assertEquals(0, dish.getSizeOfIngredientList());
        fish = new Ingredient("haddock",1);
        chips = new Ingredient("potato", 1);
        dish.addIngredientToDish(fish);
        dish.addIngredientToDish(chips);
        assertEquals(2,dish.getSizeOfIngredientList());
    }
}
