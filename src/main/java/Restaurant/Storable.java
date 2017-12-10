package Restaurant;

import ServiceArea.Ingredient;

import java.util.ArrayList;

public interface Storable {
    int checkAmount(Ingredient item);
    void decreaseQuantity(Ingredient item, int amount);
    ArrayList<Ingredient> getCopyOfStock();
}
