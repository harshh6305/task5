/**
 * CurrentAccount - Inherits from Account (Single Inheritance).
 * Demonstrates Method Overriding with overdraft feature.
 */
public class CurrentAccount extends Account {

    private double overdraftLimit;

    // Constructor
    public CurrentAccount(String accountNumber, String accountHolderName, double initialBalance, double overdraftLimit) {
        super(accountNumber, accountHolderName, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    // Method Overriding - withdraw with overdraft support
    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Withdrawal amount must be positive!");
            return false;
        }
        if (amount > getBalance() + overdraftLimit) {
            System.out.println("❌ Exceeds overdraft limit! Max withdrawal: ₹" 
                + String.format("%.2f", getBalance() + overdraftLimit));
            return false;
        }
        setBalance(getBalance() - amount);
        String record = "WITHDRAW | ₹" + String.format("%.2f", amount) + " | Balance: ₹" + String.format("%.2f", getBalance());
        addTransaction(record);
        System.out.println("✅ Withdrawn ₹" + String.format("%.2f", amount) + " successfully.");
        if (getBalance() < 0) {
            System.out.println("⚠  Overdraft used! Current balance: ₹" + String.format("%.2f", getBalance()));
        }
        return true;
    }

    // Method Overriding - displayAccountInfo
    @Override
    public void displayAccountInfo() {
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║         ACCOUNT INFORMATION          ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║ Account No      : " + getAccountNumber());
        System.out.println("║ Holder          : " + getAccountHolderName());
        System.out.println("║ Type            : Current Account");
        System.out.println("║ Balance         : ₹" + String.format("%.2f", getBalance()));
        System.out.println("║ Overdraft Limit : ₹" + String.format("%.2f", overdraftLimit));
        System.out.println("╚══════════════════════════════════════╝");
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }
}
