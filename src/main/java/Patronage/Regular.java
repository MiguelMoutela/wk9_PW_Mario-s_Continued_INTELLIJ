package Patronage;

import Menu.Sellable;

import java.util.ArrayList;


public class Regular implements Patronal {
        private ArrayList<Sellable> order;
        private float funds;
        private float discount;

        public Regular() {
            this.funds = 0;
            this.order = new ArrayList<>();
            this.discount = 0.1f;
        }

        public float getBill() {
            float totalBill = 0;
            for (Sellable item : order) {
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

    public void addToOrder(Sellable item) { order.add(item); }

    public ArrayList<Sellable> getOrder() {
        return new ArrayList<>(order);
    }

//    public void amendOrder(Sellable itemOrdered, int amount) {
//        for (Sellable item : order) {
//            if (item == itemOrdered) {
//                item.setQuantity(amount);
//            }
//        }
//    }
}
