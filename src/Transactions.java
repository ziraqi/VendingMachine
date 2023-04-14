public class Transactions {
    private static double totalSales = 0;
    private static double totalChange = 0;

    public void addTransaction(double amount, double change) {
        totalSales += amount;
        totalChange += change;
    }

    public void viewTransactions() {
        System.out.println("Total sales: $" + totalSales);
        System.out.println("Total change: $" + totalChange);
    }
}
