import org.junit.Before;
import org.junit.Test;
import ServiceArea.Ingredient;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    Ingredient ingredient;

    @Before
    public void before() {
        ingredient = new Ingredient("carrot",5);
    }
    @Test
    public void canGetName() {
        assertEquals("carrot", ingredient.getName());
    }
    @Test
    public void canGetQuantity() { assertEquals(5, ingredient.getQuantity()); }
    @Test
    public void canSetQuantity() {
        assertEquals(5, ingredient.getQuantity());
        ingredient.setQuantity(25);
        assertEquals(25, ingredient.getQuantity());
    }
    @Test
    public void canReduceQuantityByAGivenAmount() {
        assertEquals(5, ingredient.getQuantity());
        ingredient.reduceQuantity(2);
        assertEquals(3, ingredient.getQuantity());
    }
}

