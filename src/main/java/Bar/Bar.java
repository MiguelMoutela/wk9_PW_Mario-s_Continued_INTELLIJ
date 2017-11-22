package Bar;

import java.util.ArrayList;

public class Bar {
    private ArrayList<BarItem>stockList;

    public Bar() {
        this.stockList = new ArrayList<BarItem>();
    }

    public int getSize() { return stockList.size();}

    public void addToBar(BarItem barItem) {
        stockList.add(barItem);
    }

    public void takeFromBar(BarItem barItem) {
        stockList.remove(barItem);
    }

    public int checkAmount(BarItem barItem) {

        for(BarItem item : stockList) {
            if (item.getName().equals(barItem.getName())) {
                return item.getQuantity();
            }
        }

        return 0;
    }

    public void decreaseQuantity(BarItem barItem, int amount) {
        for(BarItem item : stockList) {
            if (item.getName().equals(barItem.getName())) {
                item.decreaseQuantity(amount);
                return;
            }
        }
//        int quantity = barItem.getQuantity();
//        quantity-= amount;
//        barItem.setQuantity(quantity);
    }
}
