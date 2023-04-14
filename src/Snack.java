public class Snack extends Item {
    public Snack(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    public void display() {
        System.out.println(getName() + " - $" + getPrice() + " - " + getQuantity() + " left");
    }
}
