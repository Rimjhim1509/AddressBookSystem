package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressManager {
    Map<String, AddressBook> addressBookMap = new HashMap<>();

    public void createAddressBook() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name to create");
        String name = sc.nextLine();
        if (addressBookMap.containsKey(name)) {
            System.out.println("Address Book already exists");
            return;
        }
        addressBookMap.put(name, new AddressBook());
        System.out.println("Address Book created successfully!");

    }

    public AddressBook getAddressBook() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name to find : ");
        String name = sc.nextLine();
        if (!addressBookMap.containsKey(name)) {
            return null;
        }
        return addressBookMap.get(name);
    }

    public void searchCity() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a city name: ");
        String city = sc.nextLine();
        addressBookMap.values().stream()
                .flatMap(book -> book.getContact().stream())
                .filter(p -> p.getCity().equalsIgnoreCase(city)).forEach(System.out::println);
    }

    public void searchState() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the state name : ");
        String state = sc.nextLine();
        addressBookMap.values()
                .stream()
                .flatMap(book -> book.getContact().stream())
                .filter(c -> c.getState().equalsIgnoreCase(state))
                .forEach(System.out::print);

    }

    public void displayAddressBooks() {
        for (String addressBook : addressBookMap.keySet()) {
            System.out.println(addressBook);
        }
    }
}

