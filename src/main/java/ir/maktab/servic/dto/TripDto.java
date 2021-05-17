package ir.maktab.servic.dto;

import ir.maktab.data.domain.Driver;
import ir.maktab.data.domain.Location;
import ir.maktab.data.domain.Passenger;
import ir.maktab.data.enums.PaymentType;
import ir.maktab.data.enums.TripConfirmationState;
import ir.maktab.data.enums.TripState;

public class TripDto {

    private int tripId;
    private Location origin;
    private Location destination;
    private Passenger passenger;
    private Driver driver;
    private int distance;
    private long price;
    private TripConfirmationState confirmationState;
    private PaymentType paymentType;
    private TripState state;

    public int getTripId() {
        return tripId;
    }

    public TripDto setTripId(int tripId) {
        this.tripId = tripId;
        return this;
    }

    public Location getOrigin() {
        return origin;
    }

    public TripDto setOrigin(Location origin) {
        this.origin = origin;
        return this;
    }

    public Location getDestination() {
        return destination;
    }

    public TripDto setDestination(Location destination) {
        this.destination = destination;
        return this;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public TripDto setPassenger(Passenger passenger) {
        this.passenger = passenger;
        return this;
    }

    public Driver getDriver() {
        return driver;
    }

    public TripDto setDriver(Driver driver) {
        this.driver = driver;
        return this;
    }

    public int getDistance() {
        return distance;
    }

    public TripDto setDistance(int distance) {
        this.distance = distance;
        return this;
    }

    public long getPrice() {
        return price;
    }

    public TripDto setPrice(long price) {
        this.price = price;
        return this;
    }

    public TripConfirmationState getConfirmationState() {
        return confirmationState;
    }

    public TripDto setConfirmationState(TripConfirmationState confirmationState) {
        this.confirmationState = confirmationState;
        return this;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public TripDto setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
        return this;
    }

    public TripState getState() {
        return state;
    }

    public TripDto setState(TripState state) {
        this.state = state;
        return this;
    }
}
