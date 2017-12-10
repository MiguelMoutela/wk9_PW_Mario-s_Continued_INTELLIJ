package Patronage;

import Menu.Sellable;

import java.util.ArrayList;

public interface Patronal {
    float getBill();
    void payBill(float amount);
    ArrayList<Sellable> getOrder();
    boolean checkCustomerCanPay(float bill);
//    void amendOrder(Sellable item, int amountInStock);

}
