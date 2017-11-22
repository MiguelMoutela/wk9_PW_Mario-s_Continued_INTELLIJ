package Kitchen;

import java.util.ArrayList;

public class Kitchen {
    private ArrayList<Ingredient> pantry;

    public Kitchen() {
        pantry = new ArrayList<>();
    }

    public int getSize() {
        return pantry.size();
    }

    public void addObjectToStock(Ingredient ingredient) {
        pantry.add(ingredient);
    }

    public void removeObjectFromStock(Ingredient ingredient) {
        pantry.remove(ingredient);
    }

    public ArrayList<Ingredient> getCopyOfPantry() {
        return new ArrayList<>(pantry);
    }

//    public boolean checkThereIsIngredient(Ingredient ingredient) {
//        boolean thereIsIngredient = false;
//        for (Ingredient itemInPantry : Pantry)
//            if (itemInPantry == ingredient) {
//                thereIsIngredient = true;
//            }
//        return thereIsIngredient;
//    }

//    public boolean check(ArrayList<Ingredient> ingredients) {
//
//    }

//    public int checkAmount(String name) {
//        for (Ingredient itemInPantry : Pantry) {
//            if (itemInPantry.getName().equals(name)) {
//                return itemInPantry.getQuantity();
//            }
//        }
//        return 0;
//    }
}
