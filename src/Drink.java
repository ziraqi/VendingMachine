public class Drink extends Item {
    private String size;

    public Drink(String name, double price, int quantity, String size) {
        super(name, price, quantity);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void display() {
        System.out.println(getName() + " - $" + getPrice() + " - " + getSize() + " - " + getQuantity() + " left");
    }
}
