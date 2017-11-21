package Bar;

import Kitchen.Ingredient;
import Menu.BarItem;

import java.util.ArrayList;

public class Bar {
    ArrayList<BarItem>Drinks;

    public Bar() {
        Drinks = new ArrayList<>();
    }

//    public boolean checkThereIsIngredient(String ingredient) {
//        boolean thereIsIngredient = false;
//        for (Ingredient itemInPantry : Drinks)
//            if (itemInPantry.getName().equals(ingredient)) {
//                thereIsIngredient = true;
//            }
//        return thereIsIngredient;
//    }
    public int checkAmount(String barItemQuery) {
        for (BarItem barItem : Drinks) {
            if (barItem.getName().equals(barItemQuery)) {
                return barItem.getQuantity();
            }
        }
        return 0;
    }
}
