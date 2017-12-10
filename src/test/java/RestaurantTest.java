import Menu.BarItem;
import org.junit.Before;
import org.junit.Test;
import Restaurant.Restaurant;
import Menu.Menu;
import ServiceArea.Kitchen;
import ServiceArea.Ingredient;
import Patronage.Customer;
import ServiceArea.Bar;
import Menu.Dish;


import static org.junit.Assert.assertEquals;

public class RestaurantTest {
    Restaurant restaurant;
    Menu menu;
    Kitchen kitchen;
    Ingredient tomato;
    Ingredient cheese;
    Ingredient noBread;
    Ingredient bread;
    Customer customer1;
    Bar bar;
    BarItem drink;
    Dish cheeseToastie;

    @Before
    public void before(){
        menu = new Menu();
        kitchen = new Kitchen();
        bar = new Bar();
        restaurant = new Restaurant("Mario's", menu, kitchen, bar);
        tomato = new Ingredient("tomato", 1);
        noBread = new Ingredient("bread", 0);
        bread = new Ingredient("bread", 2);
        cheese = new Ingredient("cheese", 1);
        customer1 = new Customer();
        cheeseToastie = new Dish("cheeseToastie", 5);
        cheeseToastie.addIngredientToDish(bread);
        cheeseToastie.addIngredientToDish(cheese);
        drink = new BarItem("coke",1,1);
    }

    @Test
    public void canGetName() {
        assertEquals("Mario's", restaurant.getName());
    }

    @Test
    public void canGetTurnover() {
        assertEquals(0, restaurant.getTurnover(), 0.01);
    }

    @Test
    public void checkFridgeHasIngredientsToCreateDishAndItemsAreBeingUpdated() {
        customer1.addToFoodOrder(cheeseToastie);
        kitchen.addObjectToStock(cheese);
        kitchen.addObjectToStock(noBread);
        assertEquals(noBread, restaurant.checkFridgeHasIngredients(customer1).get(0));
        assertEquals(0, cheese.getQuantity());
    }
    @Test
    public void checkItemsInTheBarAreBeingUsedUp() {
        customer1.addToDrinkOrder(drink);
        bar.addToBar(drink);
        restaurant.updateTheBarStock(customer1);
        assertEquals(0, bar.checkAmount(drink));
    }

}
