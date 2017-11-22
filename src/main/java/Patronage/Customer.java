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

        public void addToFoodOrder(Dish item) {
                foodOrder.add(item);
        }

        public void addToDrinkOrder(BarItem item) {
            this.drinkOrder.add(item);
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

        public ArrayList<Dish> getFoodOrder() {
            return new ArrayList<>(foodOrder);
        }

        public int getFoodOrderSize() {return this.foodOrder.size();}

        public ArrayList<BarItem> getDrinksOrder() {
            return new ArrayList<>(drinkOrder);
        }

        public int getDrinkOrderSize() {return this.drinkOrder.size();}


        public void amendDrinkOrder(BarItem drinkOrdered, int amount) {
            for (BarItem barItem : drinkOrder) {
                if (barItem == drinkOrdered) {
                    barItem.setQuantity(amount);
                }
            }
        }
}

