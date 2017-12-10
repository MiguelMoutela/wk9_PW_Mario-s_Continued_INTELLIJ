package Menu;

import ServiceArea.Ingredient;

import java.util.ArrayList;

public class BarItem implements Sellable {
        private String name;
        private float price;
        private int quantity;
        private ArrayList<Ingredient>ingredientList;



    public BarItem(String name, float price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
            this.ingredientList = new ArrayList<>();
        }

        public float getPrice() {
            return this.price;
        }

        public int getQuantity() { return this.quantity; }

        public void setQuantity(int quantity) { this.quantity = quantity; }

        public void reduceQuantity(int amount) { this.quantity -= amount; }

        public String getName() {
            return this.name;
        }

        public ArrayList<Ingredient> getListOfIngredients() {
        return new ArrayList<>(ingredientList);
    }

        public void addIngredientToDrink(Ingredient ingredient) {
        ingredientList.add(ingredient);
    }

        public void RemoveIngredientFromDrink(Ingredient ingredient) {ingredientList.remove(ingredient);}

        public int getSizeOfIngredientList() {
        return ingredientList.size();
    }
}
