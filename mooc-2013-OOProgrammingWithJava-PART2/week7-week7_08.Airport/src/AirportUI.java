
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class AirportUI {

    private Scanner scanner;
    private HashMap<String, Plane> planes;
    private ArrayList<Flight> flights;

    public AirportUI(Scanner scanner) {
        this.scanner = scanner;
        this.planes = new HashMap<String, Plane>();
        this.flights = new ArrayList<Flight>();
    }

    public void runAirportPanel() {
        System.out.println("Airport panel\n"
                + "--------------------\n");
        while (true) {
            System.out.println("Choose operation:\n"
                    + "[1] Add airplane\n"
                    + "[2] Add flight\n"
                    + "[x] Exit");
            System.out.print("> ");
            String command = scanner.nextLine();
            if ("1".equals(command)) {
                addPlane();
            }
            if ("2".equals(command)) {
                addFlight();
            }
            if ("x".equals(command)) {
                break;
            }
        }
    }

    public void runFlightService() {
        System.out.println("Flight service\n"
                + "------------\n");
        while (true) {
            System.out.println("Choose operation:\n"
                    + "[1] Print planes\n"
                    + "[2] Print flights\n"
                    + "[3] Print plane info\n"
                    + "[x] Quit");
            System.out.print("> ");
            String command = scanner.nextLine();
            if ("1".equals(command)) {
                printPlanes();
            }
            if ("2".equals(command)) {
                printFlights();
            }
            if ("3".equals(command)) {
                printPlaneInfo();
            }
            if ("x".equals(command)) {
                break;
            }
        }
    }

    private void addPlane() {
        System.out.print("Give plane ID: ");
        String id = scanner.nextLine();
        System.out.print("Give plane capacity: ");
        int capacity = scanner.nextInt();
        this.planes.put(id, new Plane(id, capacity));
    }

    private void addFlight() {
        System.out.print("Give plane ID: ");
        String id = scanner.nextLine();
        Plane plane = planes.get(id);
        if (plane == null) {
            return;
        }
        System.out.print("Give departure airport code: ");
        String departure = scanner.nextLine();
        System.out.print("Give destination airport code: ");
        String destination = scanner.nextLine();
        flights.add(new Flight(plane, departure, destination));
    }

    private void printPlanes() {
        for (Plane plane : planes.values()) {
            System.out.println(plane);
        }
    }

    private void printFlights() {
        for (Flight flight : flights) {
            System.out.println(flight);
        }
    }

    private void printPlaneInfo() {
        System.out.print("Give plane ID: ");
        String id = scanner.nextLine();
        Plane plane = planes.get(id);
        if (plane == null) {
            return;
        }
        System.out.println(plane);
    }
}
