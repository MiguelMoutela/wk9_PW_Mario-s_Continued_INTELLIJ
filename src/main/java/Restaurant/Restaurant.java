package Restaurant;

import Menu.Menu;
import ServiceArea.Kitchen;
import Patronage.Patronal;
import Menu.Sellable;
import ServiceArea.Ingredient;
import ServiceArea.Bar;

import java.util.ArrayList;

public class Restaurant {
    private String name;
    private float turnover;
    private Table[] tables;
    private Menu menu;
    private ArrayList<Storable> stores;
    private Kitchen kitchen;
    private Bar bar;

    public Restaurant(String name, Menu menu, Kitchen kitchen, Bar bar) {
        this.name = name;
        this.turnover = 0;
        this.tables = new Table[5];
        this.menu = menu;
        this.stores = new ArrayList();
        this.kitchen = kitchen;
        this.bar = bar;
    }

    public void addToTurnover(Table table) {
        turnover += table.getTableTotal();
    }

    public ArrayList<Ingredient> getCopyOfStock(){
        ArrayList<Ingredient> copyOfStock = new ArrayList<>();
        for (Storable fridge : this.stores) {
            copyOfStock.addAll(fridge.getCopyOfStock());
        }
        return copyOfStock;
    }

    public ArrayList<Ingredient> checkFridgeHasIngredients(Patronal customer) {
        ArrayList<Ingredient> ingredientsThatComposeMenuItemsToBeRemoved = new ArrayList<Ingredient>();
        ArrayList<Ingredient> copyOfStock = getCopyOfStock();
        ArrayList<Sellable> order = customer.getOrder();
            for (Sellable item : order) {
                for (Ingredient ingredient : item.getListOfIngredients()) {
                    for (Ingredient itemInStock : copyOfStock) {
                        if (ingredient.getName().equals(itemInStock.getName())) {
                            if (ingredient.getQuantity() <= itemInStock.getQuantity()) {
                                itemInStock.reduceQuantity(ingredient.getQuantity());
                            } else {
                                ingredientsThatComposeMenuItemsToBeRemoved.add(itemInStock);
                            }
                        }
                    }
                }
            }
        return ingredientsThatComposeMenuItemsToBeRemoved;
    }


    public void updateTheMenu(Patronal customer, Menu menu) {

        ArrayList<Sellable> order = customer.getOrder();
        ArrayList<Ingredient> comparator = checkFridgeHasIngredients(customer);

            for (Sellable item : order) {
                for (Ingredient ingredient : item.getListOfIngredients()) {
                    if (comparator.contains(ingredient)) {
                        menu.removeFromMenu(item);
                    }
                    else if (!comparator.contains(ingredient)) {
                        updateTheStock(customer);
                    }
                }
            }
        }


    public void updateTheStock(Patronal customer) {
        ArrayList<Sellable> order = customer.getOrder();
        for (Storable fridge : stores) {
            for (Sellable menuItem : order) {
                ArrayList<Ingredient> composition = new ArrayList<>(menuItem.getListOfIngredients());
                for (Ingredient ingredient : composition) {
                    int amountInStock = fridge.checkAmount(ingredient);
                    int amountOrdered = ingredient.getQuantity();

                    if (amountInStock >= amountOrdered) {
                        fridge.decreaseQuantity(ingredient, amountOrdered);
                    }
                }
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
