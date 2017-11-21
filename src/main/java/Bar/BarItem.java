package Bar;

import Menu.Sellable;

public class BarItem implements Sellable {
        private float price;
        private int quantity;

        public BarItem(float price, int quantity) {
            this.price = price;
            this.quantity = quantity;
        }
        public float getPrice() {
            return this.price;
        }

        public int getQuantity() { return this.quantity; }

        public void setQuantity(int quantity) { this.quantity = quantity; }

//        public void decreaseQuantity(int amount) { this.quantity -= amount; }
}
