package ServiceArea;

public class Ingredient {
    private String name;
    private int quantity;

    public Ingredient(String name, Integer quantity) {
        this.name = name.toLowerCase();
        this.quantity = quantity;
    }

    public String getName() {
        return this.name;
    }
    public int getQuantity() {
        return this.quantity;
    }

    public void reduceQuantity(int amount) {
        if (amount > 0) {
            this.quantity -= amount;
        }
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
