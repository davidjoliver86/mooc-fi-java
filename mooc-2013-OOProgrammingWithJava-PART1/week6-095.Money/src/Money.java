
public class Money {

    private final int euros;
    private final int cents;

    public Money(int euros, int cents) {

        if (cents > 99) {
            euros += cents / 100;
            cents %= 100;
        }

        this.euros = euros;
        this.cents = cents;
    }

    public int euros() {
        return euros;
    }

    public int cents() {
        return cents;
    }

    @Override
    public String toString() {
        String zero = "";
        if (cents < 10) {
            zero = "0";
        }

        return euros + "." + zero + cents + "e";
    }
    
    public Money plus(Money added) {
        return new Money(this.euros() + added.euros(), this.cents() + added.cents());
    }
    
    public Money minus(Money decremented) {
        if (!decremented.less(this)) {
            return new Money(0, 0);
        }
        if (decremented.cents() > this.cents()) {
            return new Money(this.euros() - decremented.euros() - 1, this.cents() + 100 - decremented.cents());
        }
        return new Money(this.euros() - decremented.euros(), this.cents() - decremented.cents());
    }
    
    public boolean less(Money compared) {
        if (this.euros() < compared.euros()) {
            return true;
        }
        if (this.euros() > compared.euros()) {
            return false;
        }
        return this.cents() < compared.cents();
    }
}
