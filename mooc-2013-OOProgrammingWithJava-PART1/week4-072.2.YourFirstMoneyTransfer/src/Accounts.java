
public class Accounts {

    public static void main(String[] args) {
        // Code in Account.Java should not be touched!
        // write your code here
        Account matt = new Account("Matt's account", 1000.0);
        Account me = new Account("My account", 0.0);
        matt.withdrawal(100.0);
        me.deposit(100.0);
        System.out.println(matt);
        System.out.println(me);
    }

}
