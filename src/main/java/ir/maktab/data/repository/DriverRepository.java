package ir.maktab.data.repository;

import ir.maktab.data.domain.Driver;


import java.util.List;
import java.util.Optional;

public interface DriverRepository {
    void create(Driver driver);
    void update(Driver driver);
    Optional get(Long id);
    List getAll();
}
