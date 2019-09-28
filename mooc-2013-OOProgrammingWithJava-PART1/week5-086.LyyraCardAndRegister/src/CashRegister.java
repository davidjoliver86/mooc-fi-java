
public class CashRegister {

    private double cashInRegister;
    private int economicalSold;
    private int gourmetSold;
    
    private final double CHEAP = 2.50;
    private final double GOURMET = 4.00;

    public CashRegister() {
        // at start the register has 1000 euros 
        this.cashInRegister = 1000.0;
    }

    public double payEconomical(double cashGiven) {
        // price of the economical lunch is 2.50 euros
        // if the given cash is at least the price of the lunch:
        //    the price of lunch is added to register
        //    the amount of sold lunch is incremented by one
        //    method returns cashGiven - lunch price 
        // if not enough money given, all is returned and nothing else happens        
        if (cashGiven < CHEAP) {
            return cashGiven;
        }
        this.economicalSold++;
        this.cashInRegister += CHEAP;
        return cashGiven - CHEAP;
    }

    public double payGourmet(double cashGiven) {
        // price of the gourmet lunch is 4.00 euros
        // if the given cash is at least the price of the lunch:
        //    the price of lunch is added to register
        //    the amount of sold lunch is incremented by one
        //    method returns cashGiven - lunch price 
        // if not enough money given, all is returned and nothing else happens
        if (cashGiven < GOURMET) {
            return cashGiven;
        }
        this.gourmetSold++;
        this.cashInRegister += GOURMET;
        return cashGiven - GOURMET;
    }
    
    public boolean payEconomical(LyyraCard card) {
        if (card.pay(CHEAP)) {
            this.economicalSold++;
            return true;
        }
        return false;
    }
    
    public boolean payGourmet(LyyraCard card) {
        if (card.pay(GOURMET)) {
            this.gourmetSold++;
            return true;
        }
        return false;
    }
    
    public void loadMoneyToCard(LyyraCard card, double sum) {
        if (sum < 0.0) {
            return;
        }
        this.cashInRegister += sum;
        card.loadMoney(sum);
    }

    public String toString() {
        return "money in register " + cashInRegister + " economical lunches sold: " + economicalSold + " gourmet lunches sold: " + gourmetSold;
    }
}
