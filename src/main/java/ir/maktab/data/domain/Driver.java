package ir.maktab.data.domain;

import ir.maktab.data.enums.DriverState;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Driver extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int driverId;
    @Enumerated(EnumType.STRING)
    private DriverState state;
    private Car car;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Trip> trips = new ArrayList<>();

    public Driver(String userName, String name, String lastName, int age, String phone) {
        super(userName, name, lastName, age, phone);
        this.state = DriverState.WAITING_TO_TRAVEL;
    }

    public DriverState getState() {
        return state;
    }

    public void setState(DriverState state) {
        this.state = state;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    public Driver() {
        super();
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

}
