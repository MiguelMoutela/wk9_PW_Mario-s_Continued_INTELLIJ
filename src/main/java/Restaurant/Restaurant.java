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
        ArrayList<Ingredient>copyOfPantry = kitchen.getCopyOfPantry();
        ArrayList<Dish>order = customer.getFoodOrder();
        for (Dish dish : order) {
            for (Ingredient ingredient : dish.getListOfIngredients()) {
                for (Ingredient itemInStock : copyOfPantry) {
                    if (ingredient.getName().equals(itemInStock.getName())) {
                        if (ingredient.getQuantity() < itemInStock.getQuantity()) {
                            itemInStock.reduceQuantity(ingredient.getQuantity());
                        }
                        else ingredientsThatComposeDishesToBeRemoved.add(ingredient);
                    }
                    return null;
                }
            }
        }
        return ingredientsThatComposeDishesToBeRemoved;
    }


    public void updateTheFoodStockAndTheMenu(Patronal customer, Menu menu) {

        ArrayList<Dish> order = customer.getFoodOrder();
        ArrayList<Ingredient> compirator = checkFridgeHasIngredients(customer);

        for (Dish dish : order) {
            for (Ingredient ingredient : dish.getListOfIngredients()) {
                if (compirator.contains(ingredient) == true) {
                    menu.removeFromMenu(dish);
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
            }
            else {
                bar.decreaseQuantity(barItem, amountInStock);
                customer.amendDrinkOrder(barItem, amountInStock);
            }
            if (amountInStock - amountOrdered == 0) {
                menu.removeFromMenu(item);
            }
        }
    }

    public String getName() {
        return this.name;
    }

    public float getTurnover() {
        return this.turnover;
    }
}
