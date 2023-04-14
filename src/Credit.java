public class Credit {
    private static double balance = 0;

    public static void creditCharge(double amount) {
        balance += amount;
    }

    public static double getChange(double amount) {
        double change = -1;

        if (amount >= 0) {
            balance -= amount;
            change = amount;
        }

        return change;
    }

    public static double getBalance() {
        return balance;
    }
}
