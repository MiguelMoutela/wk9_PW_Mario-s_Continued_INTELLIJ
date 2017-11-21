package Kitchen;

import java.util.ArrayList;

public class Kitchen {
    ArrayList<Ingredient>Pantry;

    public Kitchen() {}

    public boolean checkThereIsIngredient(String ingredient) {
        boolean thereIsIngredient = false;
        for (Ingredient itemInPantry : Pantry)
            if (itemInPantry.getName().equals(ingredient)) {
                thereIsIngredient = true;
            }
        return thereIsIngredient;
    }
    public int checkAmount(String name) {
        for (Ingredient itemInPantry : Pantry) {
            if (itemInPantry.getName().equals(name)) {
                return itemInPantry.getQuantity();
            }
        }
        return 0;
    }
}
