package ir.maktab.servic.dto;

import ir.maktab.data.domain.Account;
import ir.maktab.data.domain.Location;
import ir.maktab.data.domain.Trip;
import ir.maktab.data.enums.PassengerState;

import java.util.ArrayList;
import java.util.List;

public class PassengerDto {

    private int passengerId;
    private PassengerState state;
    private Account account;
    private List<Trip> trips=new ArrayList<>();
    private String userName;
    private String name;
    private String lastName;
    private int age;
    private String phone;
    private Location location;

    public String getUserName() {
        return userName;
    }

    public PassengerDto setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getName() {
        return name;
    }

    public PassengerDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public PassengerDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public int getAge() {
        return age;
    }

    public PassengerDto setAge(int age) {
        this.age = age;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public PassengerDto setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Location getLocation() {
        return location;
    }

    public PassengerDto setLocation(Location location) {
        this.location = location;
        return this;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public PassengerDto setPassengerId(int passengerId) {
        this.passengerId = passengerId;
        return this;
    }

    public PassengerState getState() {
        return state;
    }

    public PassengerDto setState(PassengerState state) {
        this.state = state;
        return this;
    }

    public Account getAccount() {
        return account;
    }

    public PassengerDto setAccount(Account account) {
        this.account = account;
        return this;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public PassengerDto setTrips(List<Trip> trips) {
        this.trips = trips;
        return this;
    }
}
