package Menu;

import Kitchen.Ingredient;
import Menu.Sellable;

import java.util.ArrayList;


public class Dish implements Sellable {
        ArrayList<Ingredient>ingredientList;
        String name;
        float price;

        public Dish(String name, float price) {
            ingredientList= new ArrayList<>();
            this.name = name;
            this.price = price;
        }

        public String getName() {return this.name; }

        public float getPrice() {
            return this.price;
        }

        public ArrayList<Ingredient> getListOfIngredients() {
            return new ArrayList<>(ingredientList);
        }

        public void addIngredientToDish(Ingredient ingredient) {
            ingredientList.add(ingredient);
        }
        public int getSizeOfIngredientList() {
            return ingredientList.size();
        }

}

