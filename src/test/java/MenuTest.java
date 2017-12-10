import Menu.BarItem;
import ServiceArea.Ingredient;
import Menu.Dish;
import Menu.Menu;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class MenuTest {
    Menu menu;
    BarItem coke;
    Dish cheeseToastie;
    Ingredient cheese;
    Ingredient bread;
    @Before
    public void before() {
        menu = new Menu();
        coke = new BarItem("coke",1,1);
        cheeseToastie = new Dish("cheeseToastie", 5);
        cheese = new Ingredient("cheese", 1);
        bread = new Ingredient("bread", 2);
    }
    @Test
    public void canAddItemToMenu() {
        assertEquals(0, menu.getMenuSize());
        cheeseToastie.addIngredientToDish(cheese);
        cheeseToastie.addIngredientToDish(bread);
        menu.addToMenu(cheeseToastie);
        assertNotNull(menu.getMenu());
        assertEquals(1, menu.getMenuSize());
        menu.addToMenu(coke);
        assertEquals(2, menu.getMenuSize());
        menu.removeFromMenu(coke);
        menu.removeFromMenu(cheeseToastie);
        assertEquals(0, menu.getMenuSize());
    }


}
