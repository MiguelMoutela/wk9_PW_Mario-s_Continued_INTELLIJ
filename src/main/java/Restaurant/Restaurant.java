package Restaurant;

import Menu.Menu;
import Kitchen.Kitchen;
import Bar.Bar;

import java.util.ArrayList;

public class Restaurant {
    private String name;
    private float turnover;
    private Table[] tables;
    private Menu menu;
    private ArrayList<Storable> stores;
    private Kitchen kitchen;
    private Bar bar;

    public Restaurant(String name, Menu menu) {
        this.name = name;
        this.turnover = 0;
        this.tables = new Table[5];
        this.menu = menu;
        this.stores = new ArrayList();
        this.kitchen = new Kitchen();
    }
    public void addToTurnOver(Table table) {
        turnover += table.getTableTotal();
    }
}
