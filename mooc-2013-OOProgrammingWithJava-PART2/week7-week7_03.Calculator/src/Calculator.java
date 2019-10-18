/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author root
 */
public class Calculator {
    
    private Reader reader;
    private int calculations;

    public Calculator() {
        this.reader = new Reader();
        this.calculations = 0;
    }

    public void start() {
        while (true) {
            System.out.print("command: ");
            String command = reader.readString();
            if (command.equals("end")) {
                break;
            }

            if (command.equals("sum")) {
                sum();
            } else if (command.equals("difference")) {
                difference();
            } else if (command.equals("product")) {
                product();
            }
        }
        statistics();
    }
    
    private int[] getValues() {
        int[] values = new int[2];
        System.out.print("value1: ");
        values[0] = reader.readInteger();
        System.out.print("value2: ");
        values[1] = reader.readInteger();
        this.calculations++;
        return values;
    }

    private void sum() {
        int[] values = getValues();
        System.out.println("sum of the values " + (values[0] + values[1]));
    }

    private void difference() {
        int[] values = getValues();
        System.out.println("difference of the values " + (values[0] - values[1]));
    }

    private void product() {
        int[] values = getValues();
        System.out.println("product of the values " + (values[0] * values[1]));
    }

    private void statistics() {
        System.out.println("Calculations done " + calculations);
    }
}
