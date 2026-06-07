import java.util.ArrayList;
import java.util.List;

/**
 * Base Account class demonstrating Encapsulation and OOP principles.
 * Maintains balance and transaction history.
 */
public class Account {

    // Encapsulated fields (private)
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private List<String> transactionHistory;

    // Constructor
    public Account(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with initial balance: ₹" + initialBalance);
    }

    // Overloaded Constructor (Constructor Overloading)
    public Account(String accountNumber, String accountHolderName) {
        this(accountNumber, accountHolderName, 0.0);
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Deposit amount must be positive!");
            return;
        }
        this.balance += amount;
        String record = "DEPOSIT  | ₹" + String.format("%.2f", amount) + " | Balance: ₹" + String.format("%.2f", balance);
        transactionHistory.add(record);
        System.out.println("✅ Deposited ₹" + String.format("%.2f", amount) + " successfully.");
    }

    // Withdraw method
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Withdrawal amount must be positive!");
            return false;
        }
        if (amount > balance) {
            System.out.println("❌ Insufficient funds! Available balance: ₹" + String.format("%.2f", balance));
            return false;
        }
        this.balance -= amount;
        String record = "WITHDRAW | ₹" + String.format("%.2f", amount) + " | Balance: ₹" + String.format("%.2f", balance);
        transactionHistory.add(record);
        System.out.println("✅ Withdrawn ₹" + String.format("%.2f", amount) + " successfully.");
        return true;
    }

    // Display account details (overridable by subclasses - Method Overriding)
    public void displayAccountInfo() {
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║         ACCOUNT INFORMATION          ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║ Account No : " + accountNumber);
        System.out.println("║ Holder     : " + accountHolderName);
        System.out.println("║ Type       : Basic Account");
        System.out.println("║ Balance    : ₹" + String.format("%.2f", balance));
        System.out.println("╚══════════════════════════════════════╝");
    }

    // Display transaction history
    public void displayTransactionHistory() {
        System.out.println("\n╔══════════════════════════════════════════════════════╗");
        System.out.println("║              TRANSACTION HISTORY                     ║");
        System.out.println("╠══════════════════════════════════════════════════════╣");
        for (int i = 0; i < transactionHistory.size(); i++) {
            System.out.println("║ " + (i + 1) + ". " + transactionHistory.get(i));
        }
        System.out.println("╚══════════════════════════════════════════════════════╝");
    }

    // Getters (Encapsulation)
    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    protected List<String> getTransactionHistory() {
        return transactionHistory;
    }

    // Protected setter for balance (used by subclasses)
    protected void setBalance(double balance) {
        this.balance = balance;
    }

    protected void addTransaction(String record) {
        transactionHistory.add(record);
    }
}
