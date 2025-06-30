import java.util.Scanner;

interface A {
    void check_balance(int x);
    void withdraw(int x, int y);
    void deposit(int x);
    void add_user(String N, String num, String id, int p);
}

class Bank implements A {
    int balance = 0;
    String name, number, aadhar;
    int pin;

    public void add_user(String N, String num, String id, int p) {
        name = N;
        number = num;
        aadhar = id;
        pin = p;
        System.out.println("User Added Successfully");
    }

    public void withdraw(int x, int y) {
        if (y == pin) {
            if (balance <= 0) {
                System.out.println("Low account balance, you cannot withdraw");
            } else {
                balance = balance - x;
                System.out.println("Withdrawn: " + x);
                System.out.println("Remaining balance: " + balance);
            }
        } else {
            System.out.println("Wrong PIN entered");
        }
    }

    public void deposit(int x) {
        balance = balance + x;
        System.out.println("Available balance = " + balance);
    }

    public void check_balance(int x) {
        if (x == pin) {
            System.out.println("Available balance = " + balance);
        } else {
            System.out.println("Wrong PIN");
        }
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner A = new Scanner(System.in);
        Bank b = new Bank();
        int ch;

        while (true) {
            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Add User");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            ch = A.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    int x = A.nextInt();
                    System.out.print("Enter PIN: ");
                    int y = A.nextInt();
                    b.withdraw(x, y);
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    int d = A.nextInt();
                    b.deposit(d);
                    break;

                case 3:
                    System.out.print("Enter PIN to check balance: ");
                    int p = A.nextInt();
                    b.check_balance(p);
                    break;

                case 4:
                    A.nextLine(); // consume leftover newline
                    System.out.print("Enter name: ");
                    String n = A.nextLine();
                    System.out.print("Enter phone number: ");
                    String num = A.nextLine();
                    System.out.print("Enter Aadhaar number: ");
                    String ad = A.nextLine();
                    System.out.print("Set PIN: ");
                    int pin = A.nextInt();
                    b.add_user(n, num, ad, pin);
                    break;

                case 5:
                    System.out.println("Exiting... Thank you!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
