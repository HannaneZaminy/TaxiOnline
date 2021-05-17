package ir.maktab.data.domain;

import javax.persistence.*;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountId;
    @Column
    private long balance;
    @OneToOne
    private Passenger passenger;

    public Account(int accountId, long balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public Account() {
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
