package Patronage;

import Menu.BarItem;
import Menu.Dish;

import java.util.ArrayList;

public interface Patronal {
    public float getBill();
    public void payBill(float amount);
    public ArrayList<Dish> getFoodOrder();
    public ArrayList<BarItem> getDrinksOrder();
}
