/**
 * BankSimulation - Main class to demonstrate all bank operations.
 * 
 * Covers Key OOP Concepts:
 *  - Classes & Objects (Account, SavingsAccount, CurrentAccount, Bank)
 *  - Inheritance (SavingsAccount and CurrentAccount extend Account)
 *  - Encapsulation (private fields with getters/setters)
 *  - Method Overriding (@Override in subclasses)
 *  - Constructor Overloading (Account has two constructors)
 *  - Runtime Polymorphism (Account reference holding subclass objects)
 *  - this / super keyword usage
 */
public class BankSimulation {

    public static void main(String[] args) {

        System.out.println("╔═══════════════════════════════════════════════╗");
        System.out.println("║       JAVA BANK ACCOUNT SIMULATION            ║");
        System.out.println("║       Elevate Labs - Task 5                   ║");
        System.out.println("╚═══════════════════════════════════════════════╝");

        // ─── Create Bank ───────────────────────────────────────────────
        Bank bank = new Bank("Elevate Bank");

        // ─── Object Instantiation ──────────────────────────────────────
        // Savings Account - uses full constructor
        SavingsAccount savings = new SavingsAccount("SAV001", "Rahul Sharma", 50000.0, 6.5);

        // Current Account with overdraft
        CurrentAccount current = new CurrentAccount("CUR001", "Priya Patel", 20000.0, 10000.0);

        // Basic Account - uses overloaded constructor (no initial balance)
        Account basic = new Account("ACC001", "Amit Verma");

        // Add accounts to bank
        System.out.println("\n--- Setting Up Bank Accounts ---");
        bank.addAccount(savings);
        bank.addAccount(current);
        bank.addAccount(basic);

        // ─── Display All Accounts ──────────────────────────────────────
        bank.displayAllAccounts();

        // ─── Savings Account Operations ────────────────────────────────
        System.out.println("\n\n======= SAVINGS ACCOUNT OPERATIONS =======");
        savings.displayAccountInfo();

        System.out.println("\n-- Deposit --");
        savings.deposit(15000);

        System.out.println("\n-- Withdraw (x3 to hit limit) --");
        savings.withdraw(5000);
        savings.withdraw(3000);
        savings.withdraw(2000);
        savings.withdraw(1000); // Should fail - limit reached

        System.out.println("\n-- Apply Monthly Interest --");
        savings.applyInterest();

        savings.displayAccountInfo();
        savings.displayTransactionHistory();

        // ─── Current Account Operations ────────────────────────────────
        System.out.println("\n\n======= CURRENT ACCOUNT OPERATIONS =======");
        current.displayAccountInfo();

        System.out.println("\n-- Deposit --");
        current.deposit(5000);

        System.out.println("\n-- Withdraw within overdraft --");
        current.withdraw(22000); // Uses overdraft

        System.out.println("\n-- Try to exceed overdraft --");
        current.withdraw(15000); // Should fail

        current.displayAccountInfo();
        current.displayTransactionHistory();

        // ─── Basic Account Operations ──────────────────────────────────
        System.out.println("\n\n======= BASIC ACCOUNT OPERATIONS =======");
        basic.deposit(10000);
        basic.withdraw(3000);
        basic.withdraw(20000); // Should fail
        basic.displayAccountInfo();

        // ─── Fund Transfer Between Accounts ───────────────────────────
        System.out.println("\n\n======= FUND TRANSFER =======");
        bank.transfer("SAV001", "CUR001", 5000);

        // ─── Runtime Polymorphism Demo ─────────────────────────────────
        System.out.println("\n\n======= RUNTIME POLYMORPHISM DEMO =======");
        System.out.println("Calling displayAccountInfo() via Account reference...\n");

        Account[] allAccounts = { savings, current, basic }; // polymorphism
        for (Account acc : allAccounts) {
            acc.displayAccountInfo(); // runtime determines which version to call
        }

        // ─── Final Summary ─────────────────────────────────────────────
        System.out.println("\n\n======= FINAL BANK SUMMARY =======");
        bank.displayAllAccounts();

        System.out.println("\n✅ Simulation Complete! All OOP concepts demonstrated.\n");
    }
}
