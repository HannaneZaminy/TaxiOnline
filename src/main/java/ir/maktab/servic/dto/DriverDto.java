package ir.maktab.servic.dto;

import ir.maktab.data.domain.Car;
import ir.maktab.data.domain.Location;
import ir.maktab.data.domain.Trip;
import ir.maktab.data.enums.DriverState;

import java.util.ArrayList;
import java.util.List;

public class DriverDto {
    private int driverId;
    private DriverState state;
    private Car car;
    private List<Trip> trips = new ArrayList<>();
    private String userName;
    private String name;
    private String lastName;
    private int age;
    private String phone;
    private Location location;
    public int getDriverId() {
        return driverId;
    }

    public String getUserName() {
        return userName;
    }

    public DriverDto setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getName() {
        return name;
    }

    public DriverDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public DriverDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public int getAge() {
        return age;
    }

    public DriverDto setAge(int age) {
        this.age = age;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public DriverDto setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Location getLocation() {
        return location;
    }

    public DriverDto setLocation(Location location) {
        this.location = location;
        return this;
    }

    public DriverDto setDriverId(int driverId) {
        this.driverId = driverId;
        return this;
    }

    public DriverState getState() {
        return state;
    }

    public DriverDto setState(DriverState state) {
        this.state = state;
        return this;
    }

    public Car getCar() {
        return car;
    }

    public DriverDto setCar(Car car) {
        this.car = car;
        return this;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public DriverDto setTrips(List<Trip> trips) {
        this.trips = trips;
        return this;
    }
}
