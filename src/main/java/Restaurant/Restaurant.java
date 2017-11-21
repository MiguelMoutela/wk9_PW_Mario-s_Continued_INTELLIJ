package Restaurant;

import Menu.Menu;
import Kitchen.Kitchen;
import Bar.Bar;
import Patronage.Patronal;
import Menu.Dish;
import Kitchen.Ingredient;
import Menu.BarItem;

import java.util.ArrayList;

public class Restaurant {
    private String name;
    private float turnover;
    private Table[] tables;
    private Menu menu;
    private ArrayList<Storable> stores;
    private Kitchen kitchen;
    private Bar bar;


    public Restaurant(String name, Menu menu) {
        this.name = name;
        this.turnover = 0;
        this.tables = new Table[5];
        this.menu = menu;
        this.stores = new ArrayList();
        this.kitchen = new Kitchen();
    }
    public void addToTurnOver(Table table) {
        turnover += table.getTableTotal();
    }

    public boolean checkFridgeHasIngredients (Patronal customer) {
        boolean isEverythingStock = true;
        ArrayList<Dish>order = customer.getFoodOrder();
        for (Dish dish : order) {
            for (Ingredient ingredient : dish.getListOfIngredients()) {
                if (ingredient.getQuantity() == 0) {
                    return !isEverythingStock;
                }
            }
        }
        return isEverythingStock;
    }
    public boolean checkBarHasIngredients (Patronal customer) {
        boolean isEverythingInStock = true;
        ArrayList<BarItem>order = customer.getDrinksOrder();
        for (BarItem barItem : order) {
            if (barItem.getQuantity() == 0) {
                return !isEverythingInStock;
            }
        }
        return isEverythingInStock;
    }
}
