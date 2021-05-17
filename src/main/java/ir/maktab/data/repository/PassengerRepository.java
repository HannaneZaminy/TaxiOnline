package ir.maktab.data.repository;

import ir.maktab.data.domain.Passenger;

import java.util.List;
import java.util.Optional;

public interface PassengerRepository {
    void create(Passenger passenger);
    void update(Passenger passenger);
    Optional get(Long id);
    List getAll();
}
