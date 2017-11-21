package Patronage;

import Bar.BarItem;
import Menu.Dish;

import java.util.ArrayList;


public class Regular implements Patronal {
        private ArrayList<Dish> foodOrder;
        private ArrayList<BarItem>drinkOrder;
        private float funds;
        private float discount;

        public Regular() {
            this.funds = 0;
            this.foodOrder = new ArrayList<>();
            this.drinkOrder = new ArrayList<>();
            this.discount = 0.1f;
        }

        public float getBill() {
            float totalBill = 0;
            for (Dish item : foodOrder) {
                totalBill += (item.getPrice()*(1-this.discount)) ;
            }
            for (BarItem item : drinkOrder) {
                totalBill += (item.getPrice()*(1-this.discount)) ;
            }
            return totalBill;
        }

        public void setFunds(float funds) {
            this.funds = funds;
        }

        public float getFunds() {
            return funds;
        }

        public void payBill(float bill) {
            this.funds -= bill;
        }

        public void addToOrder(Dish item) {
                foodOrder.add(item);

        }
        public void addToDrinkOrder(BarItem item) {
                drinkOrder.add(item);
        }

    public ArrayList<Dish> getFoodOrder() {
        return new ArrayList<>(foodOrder);
    }

    public ArrayList<BarItem> getDrinksOrder() {
        return new ArrayList<>(drinkOrder);
    }
}
