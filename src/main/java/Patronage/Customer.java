package Patronage;

import Bar.BarItem;
import Menu.Dish;

import java.util.ArrayList;

public class Customer implements Patronal {
        private ArrayList<Dish> foodOrder;
        private ArrayList<BarItem> drinkOrder;
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

        public void addToOrder(Dish item) {
                foodOrder.add(item);
        }

        public void addToDrinkOrder(BarItem item) {
                drinkOrder.add(item);
        }

        public void payBill(float bill) {
            this.funds -= bill;
        }

        public ArrayList<Dish> getFoodOrder() {
            return new ArrayList<>(foodOrder);
        }

        public ArrayList<BarItem> getDrinksOrder() {
            return new ArrayList<>(drinkOrder);
        }
}

