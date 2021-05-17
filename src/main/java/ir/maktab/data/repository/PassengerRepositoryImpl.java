package ir.maktab.data.repository;

import ir.maktab.data.domain.Passenger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class PassengerRepositoryImpl implements PassengerRepository {
    private final SessionFactory sessionFactory;

    public PassengerRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Passenger passenger) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(passenger);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Passenger passenger) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(passenger);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Optional<Passenger> get(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Passenger passenger = session.get(Passenger.class, id);
        session.getTransaction().commit();
        session.close();
        return  Optional.ofNullable(passenger);
    }

    @Override
    public List<Passenger> getAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List passengers = session.createQuery(
                "FROM Passenger "
        ).list();
        session.getTransaction().commit();
        session.close();
        return passengers;
    }
}
