package com.example.demo.service;

import com.example.demo.model.Contact;

import java.util.*;

public class AddressManager {
    Map<String, AddressBook> addressBookMap = new HashMap<>();
    Map<String , List<Contact>> cityPerson = new HashMap<>();
    Map<String , List<Contact>> statePerson = new HashMap<>();
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
        if(!cityPerson.containsKey(city) || cityPerson.get(city).size() == 0) {
            System.out.println("No contact");
            return;
        }

        cityPerson
                .get(city)
                .stream().forEach(System.out::println);
    }

    public void searchState() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the state name : ");
        String state = sc.nextLine();
        if(!statePerson.containsKey(state) || statePerson.get(state).size() == 0) {
            System.out.println("No contact");
            return;
        }

        statePerson
                .get(state)
                .stream()
                .forEach(System.out::print);

    }

    public void displayAddressBooks() {
        for (String addressBook : addressBookMap.keySet()) {
            System.out.println(addressBook);
        }
    }

    public void addToCityAndStateMap(Contact contact) {
        if(!cityPerson.containsKey(contact.getCity())) cityPerson.put(contact.getCity(), new ArrayList<>());
        cityPerson.get(contact.getCity()).add(contact);

        if(!statePerson.containsKey(contact.getState())) statePerson.put(contact.getState(), new ArrayList<>());
        statePerson.get(contact.getState()).add(contact);
    }
}


