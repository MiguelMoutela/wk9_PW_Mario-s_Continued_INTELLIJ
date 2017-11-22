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
        if (checkCustomerCanPay(bill)) {
            this.funds -= bill;
        }
    }

    public boolean checkCustomerCanPay(float bill) {
        boolean customerCanPay = true;
        if (this.funds < bill) {
            return !customerCanPay;
        }
        return customerCanPay;
    }

        public void addToFoodOrder(Dish item) {
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

    public void amendDrinkOrder(BarItem drinkOrdered, int amount) {
        for (BarItem barItem : drinkOrder) {
            if (barItem == drinkOrdered) {
                barItem.setQuantity(amount);
            }
        }
    }
}
