package Restaurant;

import Menu.Menu;
import Kitchen.Kitchen;
import Patronage.Customer;
import Patronage.Patronal;
import Menu.Dish;
import Kitchen.Ingredient;
import Bar.BarItem;
import Bar.Bar;

import java.util.ArrayList;

public class Restaurant {
    private String name;
    private float turnover;
    private Table[] tables;
    private Menu menu;
//    private ArrayList<Storable> stores;
    private Kitchen kitchen;
    private BarItem barItem;
    private Bar bar;

    public Restaurant(String name, Menu menu) {
        this.name = name;
        this.turnover = 0;
        this.tables = new Table[5];
        this.menu = menu;
//        this.stores = new ArrayList();
        this.kitchen = new Kitchen();

    }
    public void addToTurnOver(Table table) {
        turnover += table.getTableTotal();
    }

    public ArrayList<Ingredient> checkFridgeHasIngredients (Patronal customer) {
        ArrayList<Ingredient>ingredientsThatComposeDishesToBeRemoved = new ArrayList<Ingredient>();
        ArrayList<Dish>order = customer.getFoodOrder();
        for (Dish dish : order) {
            for (Ingredient ingredient : dish.getListOfIngredients()) {
                if (ingredient.getQuantity() == 1) {
                    ingredientsThatComposeDishesToBeRemoved.add(ingredient);
                }
            }
        }
        return ingredientsThatComposeDishesToBeRemoved;
    }

    public void updateTheFoodStockAndTheMenu(Patronal customer, Menu menu) {

        ArrayList<Dish> order = customer.getFoodOrder();
        ArrayList<Ingredient> comparator = checkFridgeHasIngredients(customer);

        for (Dish dish : order) {
            for (Ingredient ingredient : dish.getListOfIngredients()) {
                if (comparator.contains(ingredient) == true) {
                    menu.removeFromMenu(dish);
                }
                else {
                    ingredient.setQuantity(ingredient.getQuantity() - 1);
                }
            }
        }
    }

    public void updateTheBarStock(Customer customer) {
        ArrayList<BarItem>order = customer.getDrinksOrder();
        for (BarItem item : order) {
            int amountInStock = bar.checkAmount(item);
            int amountOrdered = item.getQuantity();

            if (amountInStock > amountOrdered) {
                bar.decreaseQuantity(barItem, amountInStock - amountOrdered);

                if (amountInStock - amountOrdered == 0) {
                    menu.removeFromMenu(item);
                }
            }
        }
    }
}
