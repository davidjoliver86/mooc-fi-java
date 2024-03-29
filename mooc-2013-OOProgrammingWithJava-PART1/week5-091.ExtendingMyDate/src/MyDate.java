
public class MyDate {

    private int day;
    private int month;
    private int year;

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String toString() {
        return this.day + "." + this.month + "." + this.year;
    }

    public boolean earlier(MyDate compared) {
        if (this.year < compared.year) {
            return true;
        }

        if (this.year == compared.year && this.month < compared.month) {
            return true;
        }

        if (this.year == compared.year && this.month == compared.month
                && this.day < compared.day) {
            return true;
        }
        return false;
    }
    
    public void advance() {
        this.day++;
        if (this.day == 31) {
            this.day = 1;
            this.month++;
            if (this.month == 13) {
                this.month = 1;
                this.year++;
            }
        }
    }
    
    public void advance(int numberOfDays) {
        for (int i = 0; i < numberOfDays; i++) {
            this.advance();
        }
    }
    
    public MyDate afterNumberOfDays(int numberOfDays) {
        MyDate newDate = new MyDate(this.day, this.month, this.year);
        newDate.advance(numberOfDays);
        return newDate;
    }

}
