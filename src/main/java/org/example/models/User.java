package org.example.models;

public class User {

    private String firstName;
    private String lastName;
    private String postalCode;

    public User() {};

    public User(String firstName, String lastName, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;

    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }


}
