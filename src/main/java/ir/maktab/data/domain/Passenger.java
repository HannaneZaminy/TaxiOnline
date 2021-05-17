package ir.maktab.data.domain;

import ir.maktab.data.enums.PassengerState;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Passenger extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int passengerId;
    private PassengerState state;
    @OneToOne(cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    private Account account;
    @OneToMany(cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    private List<Trip>trips=new ArrayList<>();



    public Passenger(String userName, String name, String lastName, int age, String phone) {
        super(userName, name, lastName, age, phone);
    }

    public Passenger() {

    }

    public PassengerState getState() {
        return state;
    }

    public Passenger setState(PassengerState state) {
        this.state = state;
        return this;
    }

    public Account getAccount() {
        return account;
    }


}
