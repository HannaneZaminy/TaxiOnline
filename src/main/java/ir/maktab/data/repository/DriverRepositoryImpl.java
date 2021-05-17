package ir.maktab.data.repository;

import ir.maktab.data.domain.Driver;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class DriverRepositoryImpl implements DriverRepository {
    private final SessionFactory sessionFactory;

    public DriverRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Driver driver) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(driver);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Driver driver) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(driver);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Optional<Driver> get(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Driver driver = session.get(Driver.class, id);
        session.getTransaction().commit();
        session.close();
        return  Optional.ofNullable(driver);
    }

    @Override
    public List<Driver> getAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List drivers = session.createQuery(
                "FROM Driver "
        ).list();
        session.getTransaction().commit();
        session.close();
        return drivers;
    }
}
