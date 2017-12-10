package Patronage;

import Menu.Sellable;

import java.util.ArrayList;

public class Customer implements Patronal {
        private ArrayList<Sellable> order;
        private float funds;

        public Customer() {
            this.order = new ArrayList<>();
            this.funds = funds;
        }

        public float getBill() {
            float totalBill = 0;
            for (Sellable item : order) {
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

        public void addToOrder(Sellable item) {
                order.add(item);
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

        public ArrayList<Sellable> getOrder() {
            return new ArrayList<>(order);
        }

        public int getOrderSize() {return this.order.size();}

//        public void amendOrder(Sellable itemOrdered, int amount) {
//            for (Sellable item : order) {
//                if (item == itemOrdered) {
//                    item.setQuantity(amount);
//                }
//            }
//        }
}

