import java.time.temporal.TemporalAmount;

public class BankAccounts {
    private int accountNumber;
    private String accountHolderName;
    private String pin;
    private double balance;

    public BankAccounts(int accountNumber, String accountHolderName, String pin,double balance)
    {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.pin = pin;
        this.balance =balance;
    }

    public int getAccountNumber()
    {
        return accountNumber;
    }

    public String getAccountHolderName()
    {
        return accountHolderName;
    }

    public boolean verifyPin(String inputPin)
    {
        return this.pin.equals(inputPin);
    }

    public double getBalance()
    {
        return balance;
    }

    public void deposit(double amount)
    {
        if(amount>0)
        {
            balance+=amount;
            System.out.println("Successfully Deposited BDT  " + amount);
        }
        else
        {
            System.out.println("Invalid amount.");
        }
    }

    public void withdraw(double amount)
    {
        if(amount>0 && amount<=balance)
        {
            System.out.println("Successfully Withdraw BDT " + amount);
            balance-= amount;
        }
        else
        {
            System.out.println("Insufficient balance");
        }
    }

    public String toFileString(){
        return accountNumber+","+accountHolderName+","+pin+","+balance;
    }

}
