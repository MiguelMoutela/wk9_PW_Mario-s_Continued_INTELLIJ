package ServiceArea;

import Restaurant.Storable;

import java.util.ArrayList;

public class Kitchen implements Storable {
    private ArrayList<Ingredient> pantry;

    public Kitchen() {
        pantry = new ArrayList<>();
    }

    public int getSize() {
        return this.pantry.size();
    }

    public void addObjectToStock(Ingredient ingredient) {
        this.pantry.add(ingredient);
    }

    public void removeObjectFromStock(Ingredient ingredient) {
        this.pantry.remove(ingredient);
    }

    public ArrayList<Ingredient> getCopyOfStock() {
        return new ArrayList<>(this.pantry);
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
    public void decreaseQuantity(Ingredient ingredient, int amount) {
        for (Ingredient item : this.pantry) {
            if (item.getName().equals(ingredient.getName())) {
                item.reduceQuantity(amount);
                return;
            }
        }
    }

    public int checkAmount(Ingredient item) {
        String name = item.getName();
        for (Ingredient itemInPantry : this.pantry) {
            if (itemInPantry.getName().equals(name)) {
                return itemInPantry.getQuantity();
            }
        }
        return 0;
    }
}
