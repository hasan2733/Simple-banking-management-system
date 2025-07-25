public class BankOfficers {
    private String userName;
    private String password;

    public BankOfficers(String userName,String password)
    {
        this.userName =userName;
        this.password =password;
    }

    public String getUserName()
    {
        return userName;
    }

    public boolean verifyPassword(String inputPassword)
    {
        return this.password.equals(inputPassword);
    }

    public String toFileString()
    {
        return userName+","+password;
    }
}
