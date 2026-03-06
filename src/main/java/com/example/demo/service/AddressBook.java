package com.example.demo.service;

import com.example.demo.model.Contact;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    ArrayList<Contact> contactList = new ArrayList<>();
    public void addContact(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter First Name:");
        String firstName = sc.nextLine();

        System.out.println("Enter Last Name:");
        String lastName = sc.nextLine();

        Contact newContact = new Contact();
        newContact.setFirstName(firstName);
        newContact.setLastName(lastName);

        if (contactList.contains(newContact)) {
            System.out.println("Contact already exists with name " + firstName + " " + lastName);
            return;
        }

        System.out.println("Enter Address:");
        String address = sc.nextLine();

        System.out.println("Enter City:");
        String city = sc.nextLine();

        System.out.println("Enter State:");
        String state = sc.nextLine();

        System.out.println("Enter Zip:");
        String zip = sc.nextLine();

        System.out.println("Enter Phone Number:");
        String phone = sc.nextLine();

        System.out.println("Enter Email:");
        String email = sc.nextLine();
        Contact contact = new Contact(firstName,lastName,address,city,state,zip,phone,email);
        contactList.add(contact);
        System.out.println("Contact added successfully!");


    }
    public void editContact(){
        System.out.println("Enter the name to edit name : ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        for(Contact c : contactList){
            if(c.getFirstName().equalsIgnoreCase(name)){
                System.out.println("Enter new Address:");
                c.setAddress(sc.nextLine());

                System.out.println("Enter new City:");
                c.setCity(sc.nextLine());

                System.out.println("Enter new State:");
                c.setState(sc.nextLine());

                System.out.println("Enter new Zip:");
                c.setZip(sc.nextLine());

                System.out.println("Enter new Phone Number:");
                c.setPhoneNumber(sc.nextLine());

                System.out.println("Enter new Email:");
                c.setEmail(sc.nextLine());

                System.out.println("Contact updated successfully!");
                return;
            }
            System.out.println("Contact not available");
        }
    }
    public void deleteContact(){
        System.out.println("Enter the First Name of the contact to delete:");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        for(int i = 0 ; i< contactList.size() ; i++){
            if(contactList.get(i).getFirstName().equalsIgnoreCase(name)){
                contactList.remove(i);
                System.out.println("Contact deleted successfully!");
                return;

            }
            System.out.println("Contact not found!");
        }
    }

    public void displayContacts() {
        if (contactList.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }
        for (Contact c : contactList) {
            System.out.println(c);
        }
    }

    }
