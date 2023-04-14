import java.util.ArrayList;

public class VendingMachine {
    private ArrayList<Item> items;

    public VendingMachine() {
        this.items = new ArrayList<Item>();
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public Item getItem(int index) {
        return this.items.get(index);
    }

    public int getSize() {
        return this.items.size();
    }

    public boolean checkAvailability(int index) {
        Item item = this.items.get(index);
        return item.getQuantity() > 0;
    }

    public void decrementQuantity(int index) {
        Item item = this.items.get(index);
        item.decrementQuantity();
    }

    public void viewInventory() {
        System.out.println("\nInventory:");
        for (int i = 0; i < this.items.size(); i++) {
            Item item = this.items.get(i);
            item.display();
        }
    }
}
