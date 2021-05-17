package ir.maktab.data.repository;

import ir.maktab.data.domain.Trip;

import java.util.List;
import java.util.Optional;

public interface TripRepository {
    void create(Trip trip);
    void update(Trip trip);
    Optional get(Long id);
    List getAll();
}
