package ir.maktab.data.domain;


import ir.maktab.data.enums.*;

import javax.persistence.*;

@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tripId;
    private Location origin;
    private Location destination;
    @ManyToOne(cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    private Passenger passenger;
    @ManyToOne(cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    private Driver driver;
    private int distance;
    private long price;
    private TripConfirmationState confirmationState;
    private PaymentType paymentType;
    private TripState state;

    public Location getOrigin() {
        return origin;
    }

    public Trip setOrigin(Location origin) {
        this.origin = origin;
        return this;
    }

    public Trip(Location origin, Location destination, Passenger passenger, TripConfirmationState confirmationState, PaymentType paymentType) {
        this.origin = origin;
        this.destination = destination;
        this.passenger = passenger;
        this.confirmationState = confirmationState;
        this.paymentType = paymentType;
    }

    public Location getDestination() {
        return destination;
    }

    public Trip setDestination(Location destination) {
        this.destination = destination;
        return this;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Trip setPassenger(Passenger passenger) {
        this.passenger = passenger;
        return this;
    }

    public Driver getDriver() {
        return driver;
    }

    public Trip setDriver(Driver driver) {
        this.driver = driver;
        return this;
    }

    public int getDistance() {
        return distance;
    }

    public Trip setDistance(int distance) {
        this.distance = distance;
        return this;
    }

    public long getPrice() {
        return price;
    }

    public Trip setPrice(long price) {
        this.price = price;
        return this;
    }

    public TripConfirmationState getConfirmationState() {
        return confirmationState;
    }

    public Trip setConfirmationState(TripConfirmationState confirmationState) {
        this.confirmationState = confirmationState;
        return this;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public Trip setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
        return this;
    }

    public TripState getState() {
        return state;
    }

    public Trip setState(TripState state) {
        this.state = state;
        return this;
    }

    public Trip() {
    }
}
