import java.util.Calendar;

public class Person {
    private String name;
    private MyDate birthday;
    
    public Person(String name, int pp, int kk, int vv) {
        this.name = name;
        this.birthday = new MyDate(pp, kk, vv);
    }
    
    public Person(String name, MyDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }
    
    public Person(String name) {
        this(name, Calendar.getInstance().get(Calendar.DATE), Calendar.getInstance().get(Calendar.MONTH) + 1, Calendar.getInstance().get(Calendar.YEAR));
    }
    
    
    public int age() {
// calculate the age based on the birthday and the current day
        // you get the current day as follows: 
        // Calendar.getInstance().get(Calendar.DATE);
        // Calendar.getInstance().get(Calendar.MONTH) + 1; // January is 0 so we add one
        // Calendar.getInstance().get(Calendar.YEAR);
        Calendar calendar = Calendar.getInstance();
        int yearDiff = calendar.get(Calendar.YEAR) - this.birthday.getYear();
        // if birthday hasnt passed, subtract 1
        if (this.birthday.getMonth() > calendar.get(Calendar.MONTH) + 1) {
            return yearDiff - 1;
        }
        if (this.birthday.getDay() > calendar.get(Calendar.DATE)) {
            return yearDiff - 1;
        }
        return yearDiff;
    }
    
    public boolean olderThan(Person compared) {
        // compare the ages based on birthdays
        if (this.birthday.getYear() == compared.birthday.getYear()) {
            if (this.birthday.getMonth() == compared.birthday.getMonth()) {
                return this.birthday.getDay() < compared.birthday.getDay();
            }
            return this.birthday.getMonth() < compared.birthday.getMonth();
        }
        return this.birthday.getYear() < compared.birthday.getYear();
    }
    
    public String getName() {
        return this.name;
    }
    
    public String toString() {
        return this.name + ", born " + this.birthday;
    }
}
