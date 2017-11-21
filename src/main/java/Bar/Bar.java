package Bar;

import java.util.ArrayList;

public class Bar {
    private ArrayList<BarItem>stockList;

    public Bar() {
        this.stockList = new ArrayList<BarItem>();
    }
    public void addToBar(BarItem barItem) {
        stockList.add(barItem);
    }
    public void takeFromBar(BarItem barItem) {
        stockList.remove(barItem);
    }
    public int checkAmount(BarItem barItem) {
            return barItem.getQuantity();
    }
    public void decreaseQuantity(BarItem barItem, int amount) {
        int quantity = barItem.getQuantity();
        quantity-= amount;
        barItem.setQuantity(quantity);
    }
}
