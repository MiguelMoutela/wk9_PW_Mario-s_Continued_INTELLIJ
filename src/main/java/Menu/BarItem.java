package Menu;

public class BarItem implements Sellable {
        private String name;
        private float price;
        private int quantity;

        public BarItem(String name, float price, int quantity) {
            this.name = name.toLowerCase();
            this.price = price;
            this.quantity = quantity;
        }

        public float getPrice() {
            return this.price;
        }

        public String getName() {
            return this.name;
        }

        public int getQuantity() { return this.quantity; }
}
