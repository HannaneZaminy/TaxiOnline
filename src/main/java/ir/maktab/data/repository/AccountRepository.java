package ir.maktab.data.repository;

import ir.maktab.data.domain.Account;


import java.util.List;
import java.util.Optional;

public interface AccountRepository {
    void create(Account account);
    void update(Account account);
    Optional  get(Long id);
    List getAll();
}
