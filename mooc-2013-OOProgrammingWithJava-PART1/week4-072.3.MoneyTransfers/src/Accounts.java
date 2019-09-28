
public class Accounts {

    public static void main(String[] args) {
        // Code in Account.Java should not be touched!
        // write your code here
        Account acctA = new Account("A", 100.0);
        Account acctB = new Account("B", 0.0);
        Account acctC = new Account("C", 0.0);
        transfer(acctA, acctB, 50.0);
        transfer(acctB, acctC, 25.0);
    }
    
    public static void transfer(Account from, Account to, double howMuch) {
        from.withdrawal(howMuch);
        to.deposit(howMuch);
    }

}
