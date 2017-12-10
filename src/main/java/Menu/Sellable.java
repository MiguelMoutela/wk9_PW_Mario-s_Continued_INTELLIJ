package Menu;

import ServiceArea.Ingredient;

import java.util.ArrayList;

public interface Sellable {
    float getPrice();
    ArrayList<Ingredient> getListOfIngredients();
//    int getQuantity();
    String getName();
//    void setQuantity(int amount);
}
