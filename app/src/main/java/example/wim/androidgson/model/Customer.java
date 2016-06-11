package example.wim.androidgson.model;

import java.util.List;

/**
 * Created by Wim on 6/11/16.
 */
public class Customer {

    private String firstName;
    private String lastName;
    private int age;
    private Address address;
    private List<Phone> phoneNumber;

    public Customer() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Phone> getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(List<Phone> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
