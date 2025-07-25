import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

public class Bank {
    private List<BankAccounts> accounts;
    private List<BankOfficers> officers;
    private final String ACCOUNTS_FILE = "accounts.txt";
    private final String OFFICER_FILE = "officer.txt";

    public Bank()
    {
        accounts = new ArrayList<>();
        officers = new ArrayList<>();

        loadAccounts();
        loadOfficers();
    }

    public void createAccount(String name ,String pin)
    {
        int accNumber = genarateAccountNumber();
        BankAccounts account = new BankAccounts(accNumber,name,pin,0.0);
        accounts.add(account);
        saveAccount();
        System.out.println("New customer account created. Account Number: " + accNumber);
    }

    public BankAccounts findAccount(int accNum)
    {
        for(BankAccounts acc : accounts)
        {
            if(acc.getAccountNumber() == accNum)
                return acc;
        }
        return null;
    }

    public void saveAccount()
    {
        try(PrintWriter pw = new PrintWriter(new FileWriter(ACCOUNTS_FILE))){
            for(BankAccounts acc : accounts)
            {
                pw.println(acc.toFileString());
            }
        }
        catch (IOException e)
        {
            System.out.println("Error saving accounts.");
        }
    }

    private void loadAccounts()
    {
        File file = new File(ACCOUNTS_FILE);
        if(!file.exists())
            return;
        try(Scanner sc = new Scanner(file))
        {
            while(sc.hasNextLine())
            {
                String[] parts = sc.nextLine().split(",");
                if(parts.length==4)
                {
                    int accNum = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String pin = parts[2];
                    double bal = Double.parseDouble(parts[3]);
                    accounts.add(new BankAccounts(accNum,name,pin,bal));
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("Error loading accounts");
        }

    }

    private int genarateAccountNumber(){
        int max = 100;
        for(BankAccounts acc : accounts)
        {
            if(acc.getAccountNumber()>max)
            {
                max = acc.getAccountNumber();
            }
        }
        return  max+1;
    }

    public void addOfficers(String userName,String password)
    {
        officers.add(new BankOfficers(userName,password));
        saveOfficers();
        System.out.println("Officer new officer "+userName);
    }

    public BankOfficers findOfficers(String userName)
    {
        for(BankOfficers bankOfficers : officers)
        {
            if(bankOfficers.getUserName().equals(userName))
            {
                return bankOfficers;
            }
        }
        return null;
    }

    private void saveOfficers()
    {
        try(PrintWriter printWriter = new PrintWriter(new FileWriter(OFFICER_FILE))){
            for(BankOfficers officers1: officers)
            {
                printWriter.println(officers1.toFileString());
            }
        }
        catch (IOException e){
            System.out.println("Error saving officers");
        }
    }

    private void loadOfficers()
    {
        File file = new File(OFFICER_FILE);
        if(!file.exists())
            return;
        try(Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()){
                String[] parts = sc.nextLine().split(",");
                if(parts.length == 2)
                {
                    officers.add(new BankOfficers(parts[0],parts[1]));
                }
            }
        }
        catch (IOException e)
        {
            System.out.println("Error loading officers");
        }
    }
}




