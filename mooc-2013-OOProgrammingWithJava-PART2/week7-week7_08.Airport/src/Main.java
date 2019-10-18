
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AirportUI ui = new AirportUI(scanner);
        ui.runAirportPanel();
        ui.runFlightService();
    }
}
