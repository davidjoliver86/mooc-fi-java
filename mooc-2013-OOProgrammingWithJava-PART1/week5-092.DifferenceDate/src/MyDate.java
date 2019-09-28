public class MyDate {
    private int day;
    private int month;
    private int year;

    public MyDate(int day, int montd, int year) {
        this.day = day;
        this.month = montd;
        this.year = year;
    }
    
    public int getYear() {
        return this.year;
    }
    
    public int getMonth() {
        return this.month;
    }
    
    public int getDay() {
        return this.day;
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
    
    public int differenceInYears(MyDate comparedDate) {
        if (comparedDate.getYear() == this.getYear()) {
            return 0;
        }
        // work with whatever date is earlier
        MyDate earlier, later;
        if (this.getYear() < comparedDate.getYear()) {
            earlier = this;
            later = comparedDate;
        }
        else {
            earlier = comparedDate;
            later = this;
        }
        
        // start with raw difference
        int fullYearDiff = later.getYear() - earlier.getYear();
        
        // if the "later" date has an earlier M/D than the "earlier" date, subtract 1
        if (later.getMonth() < earlier.getMonth()) {
            return fullYearDiff - 1;
        }
        if (later.getDay() < earlier.getDay()) {
            return fullYearDiff - 1;
        }
        return fullYearDiff;
    }

}
