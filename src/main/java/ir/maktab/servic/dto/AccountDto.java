package ir.maktab.servic.dto;

import ir.maktab.data.domain.Passenger;

public class AccountDto {

    private int accountId;

    private long balance;

    private Passenger passenger;

    public int getAccountId() {
        return accountId;
    }

    public AccountDto setAccountId(int accountId) {
        this.accountId = accountId;
        return this;
    }

    public long getBalance() {
        return balance;
    }

    public AccountDto setBalance(long balance) {
        this.balance = balance;
        return this;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public AccountDto setPassenger(Passenger passenger) {
        this.passenger = passenger;
        return this;
    }
}
