import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // create vending machine
        VendingMachine vendingMachine = new VendingMachine();

        // add items to vending machine
        vendingMachine.addItem(new Snack("Lays", 1.5, 10));
        vendingMachine.addItem(new Snack("Skittles", 1.0, 5));
        vendingMachine.addItem(new Drink("Dr.Pepper", 2.0, 7, "12 oz"));
        vendingMachine.addItem(new Drink("SmartWater", 1.0, 15, "16 oz"));
        vendingMachine.addItem(new Drink("Hi-C", 1.0, 15, "8 oz"));
        vendingMachine.addItem(new Drink("Sprite", 1.5, 12, "16 oz"));
        vendingMachine.addItem(new Drink("Coke", 1.5, 13, "16 oz"));
        vendingMachine.addItem(new Drink("Lemonade", 2.0, 11, "16 oz"));
        vendingMachine.addItem(new Drink("Iced Tea Sweet", 1.0, 10, "16 oz"));
        vendingMachine.addItem(new Drink("Iced Tea UnSweet", 1.0, 16, "16 oz"));
        vendingMachine.addItem(new Snack("SweetTarts", 1.7, 10));
        vendingMachine.addItem(new Snack("Oreo's", 1.5, 9));
        vendingMachine.addItem(new Snack("HoneyBun", 2.0, 7));
        vendingMachine.addItem(new Snack("Hot Cheetos", 1.2, 10));
        vendingMachine.addItem(new Snack("Sweet Ropes", 2.5, 8));
        vendingMachine.addItem(new Snack("Munchies", 1.0, 5));
        
        Scanner scanner = new Scanner(System.in);

        boolean continueShopping = true;

        while (continueShopping) {
            // display menu
            System.out.println("Menu:");
            for (int i = 0; i < vendingMachine.getSize(); i++) {
                Item item = vendingMachine.getItem(i);
                System.out.printf("%d. %s ($%.2f)\n", i + 1, item.getName(), item.getPrice());
            }

            // prompt user for selection
            System.out.print("Enter the number of your selection (or 0 to quit): ");
            int selection = scanner.nextInt();

            if (selection == 0) {
                // exit program
                continueShopping = false;
            } else if (selection >= 1 && selection <= vendingMachine.getSize()) {
                // check if item is available
                if (vendingMachine.checkAvailability(selection - 1)) {
                    // get item and price
                    Item item = vendingMachine.getItem(selection - 1);
                    double price = item.getPrice();

                    // prompt user for credit
                    System.out.printf("Enter credit amount ($%.2f): $", price);
                    double credit = scanner.nextDouble();

                    // check if credit is sufficient
                    if (credit >= price) {
                        // calculate change
                        double change = Credit.getChange(credit - price);
                        if (change >= 0) {
                            // decrement item quantity
                            vendingMachine.decrementQuantity(selection - 1);

                            // credit charge and add transaction
                            Credit.creditCharge(price);
                            Transactions transactions = new Transactions();
                            transactions.addTransaction(price, change);

                            // display transaction
                            System.out.println("Thank you for your purchase!");
                            System.out.println("Item: " + item.getName());
                            System.out.printf("Price: $%.2f\n", price);
                            System.out.printf("Credit: $%.2f\n", credit);
                            System.out.printf("Change: $%.2f\n", change);

                            // prompt user to continue or quit
                            System.out.print("Would you like to make another purchase? (y/n): ");
                            String answer = scanner.next();
                            if (answer.equalsIgnoreCase("n")) {
                                continueShopping = false;
                            }
                        } else {
                            System.out.println("Insufficient balance.");
                        }
                    } else {
                        System.out.println("Insufficient credit.");
                    }
                } else {
                    System.out.println("Item is out of stock.");
                }
            } else {
                System.out.println("Invalid selection.");
            }
        }

        // view inventory and transactions
        vendingMachine.viewInventory();
        Transactions transactions = new Transactions();
        transactions.viewTransactions();
    }
}
