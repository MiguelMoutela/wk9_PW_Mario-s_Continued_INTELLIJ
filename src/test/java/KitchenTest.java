import org.junit.Before;
import org.junit.Test;

import Kitchen.Kitchen;
import Kitchen.Ingredient;


import static org.junit.Assert.assertEquals;


public class KitchenTest {
    Kitchen kitchen;
    Ingredient ingredient1;
    Ingredient ingredient2;

    @Before
    public void before() {
        kitchen = new Kitchen();
        ingredient1 = new Ingredient("potato", 5);
        ingredient2 = new Ingredient("cream", 6);
    }
    @Test
    public void canAddAndRemoveFromStockAndGetSize() {
        assertEquals(0, kitchen.getSize());
        kitchen.addObjectToStock(ingredient1);
        assertEquals(1, kitchen.getSize());
        kitchen.removeObjectFromStock(ingredient1);
        assertEquals(0, kitchen.getSize());
    }
    @Test
    public void canReturnACopyOfThePantry() {
        assertEquals(0, kitchen.getSize());
        kitchen.addObjectToStock(ingredient1);
        assertEquals(1, kitchen.getSize());
    }
}
