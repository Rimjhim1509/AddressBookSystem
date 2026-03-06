package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressManager {
    Map<String , AddressBook> addressBookMap = new HashMap<>();
    public void createAddressBook(){

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name to create");
        String name = sc.nextLine();
        if(addressBookMap.containsKey(name)){
            System.out.println("Address Book already exists");
            return;
        }
        addressBookMap.put(name , new AddressBook());
        System.out.println("Address Book created successfully!");

    }
    public AddressBook getAddressBook(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name to find : ");
        String name = sc.nextLine();
        if(!addressBookMap.containsKey(name)){
            return null;
        }
        return addressBookMap.get(name);
    }
}
