import java.util.HashMap;
import java.util.Map;

/**
 * Bank class - manages multiple accounts.
 * Demonstrates object instantiation and collections.
 */
public class Bank {

    private String bankName;
    private Map<String, Account> accounts; // stores all accounts

    public Bank(String bankName) {
        this.bankName = bankName;
        this.accounts = new HashMap<>();
    }

    // Add an account to the bank
    public void addAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
        System.out.println("✅ Account " + account.getAccountNumber() + " added to " + bankName);
    }

    // Get account by account number
    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    // Transfer funds between accounts (uses this keyword internally)
    public void transfer(String fromAccountNo, String toAccountNo, double amount) {
        Account from = accounts.get(fromAccountNo);
        Account to = accounts.get(toAccountNo);

        if (from == null || to == null) {
            System.out.println("❌ One or both account numbers are invalid!");
            return;
        }

        System.out.println("\n💸 Initiating transfer of ₹" + String.format("%.2f", amount)
            + " from " + fromAccountNo + " to " + toAccountNo);

        boolean success = from.withdraw(amount);
        if (success) {
            to.deposit(amount);
            System.out.println("✅ Transfer successful!");
        } else {
            System.out.println("❌ Transfer failed.");
        }
    }

    // Display all accounts
    public void displayAllAccounts() {
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║      " + bankName + " - ALL ACCOUNTS        ║");
        System.out.println("╠══════════════════════════════════════╣");
        for (Account acc : accounts.values()) {
            System.out.println("║ " + acc.getAccountNumber() + " | " 
                + acc.getAccountHolderName() + " | ₹" 
                + String.format("%.2f", acc.getBalance()));
        }
        System.out.println("╚══════════════════════════════════════╝");
    }

    public String getBankName() {
        return bankName;
    }
}
