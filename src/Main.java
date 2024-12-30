import java.util.Scanner;

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class BankAccount {
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }
    public int getBalance() {
        return balance;
    }
    public void transfer(int amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds in the account.");
        }
        balance -= amount;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your initial account balance: ");
        int initialBalance = scanner.nextInt();

        BankAccount account = new BankAccount(initialBalance);

        System.out.print("Enter the transfer amount: ");
        int transferAmount = scanner.nextInt();

        try {
            account.transfer(transferAmount);
            System.out.println("The transfer for the amount of " + transferAmount + " PLN has been completed successfully.");
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Current account balance: " + account.getBalance() + " PLN");
        }
        scanner.close();
    }
}
