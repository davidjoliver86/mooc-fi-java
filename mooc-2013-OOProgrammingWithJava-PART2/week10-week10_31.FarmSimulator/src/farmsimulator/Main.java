package farmsimulator;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        m3();
    }

    public static void m1() {
        Farm farm = new Farm("Esko", new Barn(new BulkTank()));
        System.out.println(farm);
        System.out.println(farm.getOwner() + " is a tough guy!");
    }

    public static void m2() {
        Farm farm = new Farm("Esko", new Barn(new BulkTank()));
        farm.addCow(new Cow());
        farm.addCow(new Cow());
        farm.addCow(new Cow());
        farm.liveHour();
        farm.liveHour();
        System.out.println(farm);
    }

    public static void m3() {
        Farm farm = new Farm("Esko", new Barn(new BulkTank()));
        MilkingRobot robot = new MilkingRobot();
        farm.installMilkingRobot(robot);

        farm.addCow(new Cow());
        farm.addCow(new Cow());
        farm.addCow(new Cow());

        farm.liveHour();
        farm.liveHour();

        farm.manageCows();

        System.out.println(farm);
    }
}
