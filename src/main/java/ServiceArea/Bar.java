package ServiceArea;

import Menu.BarItem;
import Restaurant.Storable;

import java.util.ArrayList;

public class Bar implements Storable {
    private ArrayList<Ingredient>stockList;

    public Bar() {
        this.stockList = new ArrayList<Ingredient>();
    }

    public ArrayList<Ingredient> getCopyOfStock() {
        return new ArrayList<>(this.stockList);
    }

    public int getSize() { return stockList.size();}

    public void addToBar(Ingredient ingredient) {
        stockList.add(ingredient);
    }

    public void takeFromBar(BarItem barItem) {
        stockList.remove(barItem);
    }

    public int checkAmount(Ingredient barItem) {
        for(Ingredient item : stockList) {
            if (item.getName().equals(item.getName())) {
                return item.getQuantity();
            }
        }
        return 0;
    }

    public void decreaseQuantity(Ingredient barItem, int amount) {
        for(Ingredient item : stockList) {
            if (item.getName().equals(barItem.getName())) {
                item.reduceQuantity(amount);
                return;
            }
        }
//        int quantity = barItem.getQuantity();
//        quantity-= amount;
//        barItem.setQuantity(quantity);
    }
}
