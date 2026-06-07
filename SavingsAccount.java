/**
 * SavingsAccount - Inherits from Account (Single Inheritance).
 * Demonstrates Method Overriding and added behavior (interest).
 */
public class SavingsAccount extends Account {

    private double interestRate; // Annual interest rate in %
    private int withdrawalLimit;
    private int withdrawalsThisMonth;

    // Constructor using super() - this keyword
    public SavingsAccount(String accountNumber, String accountHolderName, double initialBalance, double interestRate) {
        super(accountNumber, accountHolderName, initialBalance); // calling parent constructor
        this.interestRate = interestRate;
        this.withdrawalLimit = 3; // max 3 withdrawals per month
        this.withdrawalsThisMonth = 0;
    }

    // Method Overriding - withdraw with limit check
    @Override
    public boolean withdraw(double amount) {
        if (withdrawalsThisMonth >= withdrawalLimit) {
            System.out.println("❌ Monthly withdrawal limit (" + withdrawalLimit + ") reached for Savings Account!");
            return false;
        }
        boolean success = super.withdraw(amount); // calling parent method using super
        if (success) {
            withdrawalsThisMonth++;
            System.out.println("ℹ  Withdrawals this month: " + withdrawalsThisMonth + "/" + withdrawalLimit);
        }
        return success;
    }

    // Apply monthly interest
    public void applyInterest() {
        double interest = getBalance() * (interestRate / 100) / 12;
        setBalance(getBalance() + interest);
        String record = "INTEREST | ₹" + String.format("%.2f", interest) + " | Balance: ₹" + String.format("%.2f", getBalance());
        addTransaction(record);
        System.out.println("✅ Monthly interest of ₹" + String.format("%.2f", interest) + " applied.");
    }

    // Reset monthly withdrawals
    public void resetMonthlyWithdrawals() {
        withdrawalsThisMonth = 0;
        System.out.println("🔄 Monthly withdrawal count reset.");
    }

    // Method Overriding - displayAccountInfo
    @Override
    public void displayAccountInfo() {
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║         ACCOUNT INFORMATION          ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║ Account No    : " + getAccountNumber());
        System.out.println("║ Holder        : " + getAccountHolderName());
        System.out.println("║ Type          : Savings Account");
        System.out.println("║ Balance       : ₹" + String.format("%.2f", getBalance()));
        System.out.println("║ Interest Rate : " + interestRate + "% per annum");
        System.out.println("║ Withdrawals   : " + withdrawalsThisMonth + "/" + withdrawalLimit + " this month");
        System.out.println("╚══════════════════════════════════════╝");
    }

    public double getInterestRate() {
        return interestRate;
    }
}
