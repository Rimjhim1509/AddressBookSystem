package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String email;
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Contact )) return false;
        Contact contact = new Contact();
        return firstName.equalsIgnoreCase(getFirstName())&& lastName.equalsIgnoreCase(getLastName());
    }
    public int hashCode(){
        return Objects.hash(firstName.toLowerCase() , lastName.toLowerCase());
    }

}
