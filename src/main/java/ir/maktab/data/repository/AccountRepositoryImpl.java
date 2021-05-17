package ir.maktab.data.repository;

import ir.maktab.data.domain.Account;
import ir.maktab.data.domain.Passenger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class AccountRepositoryImpl implements AccountRepository {
    private final SessionFactory sessionFactory;

    public AccountRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Account account) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(account);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Account account) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(account);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Optional<Account> get(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Account account = session.get(Account.class, id);
        session.getTransaction().commit();
        session.close();
        return  Optional.ofNullable(account);
    }

    @Override
    public List<Account> getAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List account = session.createQuery(
                "FROM Account "
        ).list();
        session.getTransaction().commit();
        session.close();
        return  account;
    }
}
