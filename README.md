# 🏦 Bank Account Simulation — Java OOP

**Elevate Labs Java Developer Internship | Task 5**

---

## 📌 Objective
Simulate basic bank operations using Java OOP principles including Classes, Inheritance, Encapsulation, and Method Overriding.

---

## 📁 Project Structure

```
BankAccountSimulation/
│
├── src/
│   ├── Account.java          # Base class (Encapsulation, Constructor Overloading)
│   ├── SavingsAccount.java   # Inherits Account (Inheritance, Method Overriding)
│   ├── CurrentAccount.java   # Inherits Account (Inheritance, Method Overriding)
│   ├── Bank.java             # Manages multiple accounts, Fund Transfer
│   └── BankSimulation.java   # Main class — runs the full simulation
│
└── README.md
```

---

## ✅ OOP Concepts Covered

| Concept | Where Used |
|---|---|
| **Classes & Objects** | `Account`, `SavingsAccount`, `CurrentAccount`, `Bank` |
| **Inheritance** | `SavingsAccount extends Account`, `CurrentAccount extends Account` |
| **Encapsulation** | Private fields + getters/setters in `Account` |
| **Method Overriding** | `withdraw()` and `displayAccountInfo()` overridden in subclasses |
| **Constructor Overloading** | `Account` has two constructors (with/without initial balance) |
| **Runtime Polymorphism** | `Account[]` array holding subclass objects, calling overridden methods |
| **`this` keyword** | Used in constructors and field references |
| **`super` keyword** | Subclasses call `super()` constructor and `super.withdraw()` |
| **Transaction History** | `ArrayList<String>` maintained in `Account` |

---

## 🚀 Features

- **Deposit & Withdraw** — with validation (no negative amounts)
- **Transaction History** — every operation logged
- **Savings Account** — monthly withdrawal limit + interest calculation
- **Current Account** — overdraft support
- **Fund Transfer** — between any two accounts in the bank
- **Polymorphism Demo** — same method call behaves differently per account type

---

## 🛠️ How to Run

### Prerequisites
- Java JDK 8 or higher
- VS Code / IntelliJ / any terminal

### Steps
```bash
# 1. Clone the repository
git clone https://github.com/YOUR_USERNAME/BankAccountSimulation.git
cd BankAccountSimulation/src

# 2. Compile all Java files
javac *.java

# 3. Run the simulation
java BankSimulation
```

---

## 📸 Sample Output

```
╔═══════════════════════════════════════════════╗
║       JAVA BANK ACCOUNT SIMULATION            ║
║       Elevate Labs - Task 5                   ║
╚═══════════════════════════════════════════════╝

--- Setting Up Bank Accounts ---
✅ Account SAV001 added to Elevate Bank
✅ Account CUR001 added to Elevate Bank
✅ Account ACC001 added to Elevate Bank

======= SAVINGS ACCOUNT OPERATIONS =======
✅ Deposited ₹15000.00 successfully.
✅ Withdrawn ₹5000.00 successfully.
ℹ  Withdrawals this month: 1/3
...
```

---

## 🧠 Interview Questions Answers

1. **Inheritance** — A class acquiring properties/methods of another class using `extends`.
2. **`this` keyword** — Refers to the current class instance; used in constructors and methods.
3. **Overriding vs Overloading** — Overriding: same signature in subclass. Overloading: same name, different parameters.
4. **Object Instantiation** — Creating an object using `new` keyword (e.g., `new Account(...)`).
5. **Single vs Multiple Inheritance** — Java supports single inheritance (one parent class); multiple via interfaces.
6. **Encapsulation** — Hiding data using `private` fields and exposing via getters/setters.
7. **Constructor Overloading** — Multiple constructors with different parameters in the same class.
8. **Overriding static methods** — No, static methods belong to the class, not the object; they can be hidden but not overridden.
9. **Runtime Polymorphism** — Method call resolved at runtime based on the actual object type (dynamic dispatch).
10. **Class vs Object** — Class is a blueprint; Object is an instance of that class.

---

## 👤 Author
**[Your Name]** — Java Developer Intern, Elevate Labs
