/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonebook.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import phonebook.data.Phonebook;
import phonebook.entity.Address;
import phonebook.entity.PersonalInfo;
import phonebook.entity.PhoneNumber;

/**
 *
 * @author davido
 */
public class PhonebookUI {

    private Scanner scanner;
    private Phonebook phonebook;
    private boolean running;

    public PhonebookUI(Scanner scanner) {
        this.scanner = scanner;
        this.phonebook = new Phonebook();
        this.running = true;
    }

    public void run() {
        displayMenu();
        while (running) {
            running = getCommand();
        }
    }

    private void displayMenu() {
        System.out.println("phone search\n"
                + "available operations:\n"
                + " 1 add a number\n"
                + " 2 search for a number\n"
                + " 3 search for a person by phone number\n"
                + " 4 add an address\n"
                + " 5 search for personal information\n"
                + " 6 delete personal information\n"
                + " 7 filtered listing\n"
                + " x quit");
    }

    private boolean getCommand() {
        System.out.print("\ncommand: ");
        String raw = this.scanner.nextLine();
        if (raw.isEmpty()) {
            return true;
        }
        char command = raw.toCharArray()[0];
        switch (command) {
            case 'x':
                return false;
            case '1':
                addNumber();
                return true;
            case '2':
                searchForNumber();
                return true;
            case '3':
                searchForPersonByNumber();
                return true;
            case '4':
                addAddress();
                return true;
            case '5':
                searchForPersonalInfo();
                return true;
            case '6':
                deletePersonalInfo();
                return true;
            case '7':
                filteredSearch();
                return true;
            default:
                System.out.println("fuck you");
                return true;
        }
    }

    private void addNumber() {
        System.out.print("whose number: ");
        String name = this.scanner.nextLine();
        System.out.print("number: ");
        String number = this.scanner.nextLine();
        this.phonebook.addNumber(name, number);
    }

    private void searchForNumber() {
        System.out.print("\nwhose number: ");
        String name = this.scanner.nextLine();
        List<PhoneNumber> results = this.phonebook.searchForNumber(name);
        if (results == null) {
            System.out.println(" not found");
            return;
        }
        for (PhoneNumber number : results) {
            System.out.printf(" %s\n", number);
        }
    }

    private void searchForPersonByNumber() {
        System.out.print("number: ");
        String number = this.scanner.nextLine();
        String person = phonebook.searchForPersonByNumber(number);
        if (person == null) {
            System.out.println(" not found");
        } else {
            System.out.printf(" %s\n", person);
        }
    }

    private void addAddress() {
        System.out.print("whose address: ");
        String name = this.scanner.nextLine();
        System.out.print("street: ");
        String street = this.scanner.nextLine();
        System.out.print("city: ");
        String city = this.scanner.nextLine();
        this.phonebook.addNumber(name, street, city);
    }

    private void printPersonalInfo(List<PersonalInfo> personalInfo) {
        String address = null;
        List<PhoneNumber> phoneNumbers = new ArrayList<PhoneNumber>();
        for (PersonalInfo info : personalInfo) {
            if (info instanceof Address) {
                address = info.get();
            }
            if (info instanceof PhoneNumber) {
                phoneNumbers.add((PhoneNumber) info);
            }
        }
        if (address == null) {
            System.out.println("  address unknown");
        } else {
            System.out.printf("  address: %s\n", address);
        }
        if (phoneNumbers.isEmpty()) {
            System.out.println("  phone number not found");
        } else {
            System.out.println("  phone numbers:");
            for (PhoneNumber phoneNumber : phoneNumbers) {
                System.out.printf("   %s\n", phoneNumber.get());
            }
        }
    }

    private void searchForPersonalInfo() {
        System.out.print("whose information: ");
        String name = this.scanner.nextLine();
        List<PersonalInfo> personalInfo = phonebook.getPersonalInfo(name);
        if (personalInfo == null) {
            System.out.println("  not found");
            return;
        }
        printPersonalInfo(personalInfo);
    }

    private void deletePersonalInfo() {
        System.out.print("whose information: ");
        String name = this.scanner.nextLine();
        phonebook.deletePersonalInfo(name);
    }

    private void filteredSearch() {
        System.out.print("keyword (if empty, all listed): ");
        String query = this.scanner.nextLine();
        List<String> names = phonebook.getAllNames();
        boolean foundAny = false;
        for (String name : names) {
            boolean foundName = false;
            if (name.toLowerCase().contains(query)) {
                foundName = true;
                foundAny = true;
            }
            List<PersonalInfo> personalInfo = phonebook.getPersonalInfo(name);
            for (PersonalInfo info : personalInfo) {
                if (info.get().toLowerCase().contains(query)) {
                    foundName = true;
                    foundAny = true;
                    break;
                }
            }
            if (foundName) {
                System.out.printf("\n %s\n", name);
                printPersonalInfo(personalInfo);
            }
        }
        if (!foundAny) {
            System.out.println(" keyword not found");
        }
    }
}