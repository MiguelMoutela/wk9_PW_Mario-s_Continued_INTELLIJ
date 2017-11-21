package Patronage;

import Patronage.Patronal;
import Menu.BarItem;
import Menu.Dish;
import Kitchen.Kitchen;
import Bar.Bar;

import java.util.ArrayList;

import static com.sun.tools.doclets.formats.html.markup.HtmlStyle.bar;


public class Customer implements Patronal {
        private ArrayList<Dish> foodOrder;
        private ArrayList<BarItem>drinkOrder;
        private float funds;

        public Customer() {
            this.foodOrder = new ArrayList<>();
            this.drinkOrder = new ArrayList<>();
            this.funds = funds;
        }

        public float getBill() {
            float totalBill = 0;
            for (Dish item : foodOrder) {
                totalBill += (item.getPrice()) ;
            }
            for (BarItem item : drinkOrder) {
                totalBill += (item.getPrice()) ;
            }
            return totalBill;
        }

        public float getFunds() {
            return funds;
        }

        public void setFunds(float funds) {
            this.funds = funds;
        }

        public void addToOrder(Dish item, Kitchen kitchen) {
            if (checkKitchenHasIngredients(kitchen) == true) {
                foodOrder.add(item);
            }
            else return;
        }

        public void addToDrinkOrder(BarItem item, Bar bar) {
            if (checkBarHasItem(bar) == false) {
                drinkOrder.add(item);
            }
            else return;
        }

        public void payBill(float bill) {
            this.funds -= bill;
        }

        public boolean checkKitchenHasIngredients(Kitchen kitchen) {
            boolean KitchenHasIngredients = false;
            int howManyIngredientsKitchenHas = 0;

            for (Dish item : foodOrder) {
                ArrayList<String>listOfIngredients = item.getListOfIngredients();
                for (String ingredientName : listOfIngredients) {
                    if (kitchen.checkAmount(ingredientName) != 0) {
                        howManyIngredientsKitchenHas ++;
                    }
                }
                if (howManyIngredientsKitchenHas == listOfIngredients.size()) {
                    KitchenHasIngredients = true;
                }
            }
            return KitchenHasIngredients;
        }

        public boolean checkBarHasItem(Bar bar) {
            boolean barHasItem = false;
            for (BarItem item : drinkOrder) {
                if (bar.checkAmount(item.getName()) != 0) {
                    barHasItem = true;
                }
            }
            return barHasItem;
        }
}

