import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {
            System.out.println("====Welcome to Bank Management System====");
            System.out.println("1. Log in as Account Holder");
            System.out.println("2. Log in as Bank Officer");
            System.out.println("3. Add New Bank Officer (Admin only)");
            System.out.println("4. Exit");
            System.out.print("Select option: ");

            int choice ;
            try{
                choice = sc.nextInt();
                sc.nextLine();
            }
            catch (Exception e)
            {
                System.out.println("Invalid choice , try latter");
                sc.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    try {
                        handleAccountHolder(bank, sc);
                        break;
                    }
                    catch (Exception e)
                    {
                        System.out.println("Invalid");
                        break;
                    }
                case 2:
                    try {
                        handleOfficers(bank, sc);
                        break;
                    }
                    catch (Exception e)
                    {
                        System.out.println("Invalid");
                        break;
                    }
                case 3:
                    System.out.print("Enter new officer username: ");
                    String offName = sc.nextLine();
                    System.out.print("Enter password: ");
                    String offPass = sc.nextLine();
                    bank.addOfficers(offName, offPass);
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }


    private static void handleAccountHolder(Bank bank, Scanner sc) {
        System.out.print("Enter Account Number :");
        int accNum = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter PIN : ");
        String pin = sc.nextLine();
        BankAccounts acc = bank.findAccount(accNum);
        if (acc != null && acc.verifyPin(pin)) {
            System.out.println("Welcome, " + acc.getAccountHolderName());
            boolean loggedIn = true;
            while (loggedIn) {
                System.out.println("\n1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Logout");
                System.out.print("Select: ");
                int opt = sc.nextInt();

                switch (opt) {
                    case 1:
                        System.out.println("Balance: BDT " + acc.getBalance());
                        break;
                    case 2:
                        System.out.print("Amount to deposit: ");
                        double dep = sc.nextDouble();
                        acc.deposit(dep);
                        bank.saveAccount();
                        break;
                    case 3:
                        System.out.print("Amount to withdraw: ");
                        double wit = sc.nextDouble();
                        acc.withdraw(wit);
                        bank.saveAccount();
                        break;
                    case 4:
                        loggedIn = false;
                        break;
                    default:
                        System.out.println("Invalid option");
                }
            }
        } else {
            System.out.println("Invalid credentials.");
        }
    }

    private static void handleOfficers(Bank bank, Scanner sc) {
        System.out.print("Officer username: ");
        String uname = sc.nextLine();
        System.out.print("Password: ");
        String pass = sc.nextLine();
        BankOfficers officer = bank.findOfficers(uname);
        if (officer != null && officer.verifyPassword(pass)) {
            System.out.println("Welcome Officer: " + uname);
            boolean loggedIn = true;
            while (loggedIn) {
                System.out.println("\n1. Create Customer Account");
                System.out.println("2. View Customer Account");
                System.out.println("3. Deposit to Customer");
                System.out.println("4. Withdraw from Customer");
                System.out.println("5. Logout");
                System.out.print("Select: ");
                int opt = sc.nextInt();
                sc.nextLine();

                switch (opt) {
                    case 1:
                        System.out.print("Customer Name: ");
                        String name = sc.nextLine();
                        System.out.print("Set PIN: ");
                        String pin = sc.nextLine();
                        bank.createAccount(name, pin);
                        break;
                    case 2:
                        System.out.print("Customer Account Number: ");
                        int accNum = sc.nextInt();
                        BankAccounts acc = bank.findAccount(accNum);
                        if (acc != null) {
                            System.out.println("Customer : " + acc.getAccountHolderName());
                            System.out.println("Balance : BDT " + acc.getBalance());
                        } else {
                            System.out.println("Account Not Found");
                        }
                        break;
                    case 3:
                        System.out.print("Customer Account Number: ");
                        int dAccNum = sc.nextInt();
                        BankAccounts dAcc = bank.findAccount(dAccNum);
                        if (dAcc != null) {
                            System.out.println("Enter the amount : ");
                            double amt = sc.nextDouble();
                            dAcc.deposit(amt);
                            bank.saveAccount();
                        } else {
                            System.out.println("Accounts not found !");
                        }
                        break;
                    case 4:
                        System.out.print("Customer Account Number: ");
                        int wAccNum = sc.nextInt();
                        BankAccounts wAcc = bank.findAccount(wAccNum);
                        if (wAcc != null) {
                            System.out.print("Amount: ");
                            double amt = sc.nextDouble();
                            wAcc.withdraw(amt);
                            bank.saveAccount();
                        } else {
                            System.out.println("Accounts not found !");
                        }
                        break;
                    case 5:
                        loggedIn = false;
                        break;
                    default:
                        System.out.println("Invalid opinion");
                }
            }
        } else {
            System.out.println("Invalid officer credentials.");
        }
    }
}
