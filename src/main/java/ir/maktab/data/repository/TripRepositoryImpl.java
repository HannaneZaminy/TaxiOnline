package ir.maktab.data.repository;

import ir.maktab.data.domain.Trip;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class TripRepositoryImpl implements TripRepository {
    private final SessionFactory sessionFactory;

    public TripRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Trip trip) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(trip);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Trip trip) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(trip);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Optional<Trip> get(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
       Trip trip = session.get(Trip.class, id);
        session.getTransaction().commit();
        session.close();
        return  Optional.ofNullable(trip);
    }

    @Override
    public List<Trip> getAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List trips = session.createQuery(
                "FROM Trip "
        ).list();
        session.getTransaction().commit();
        session.close();
        return trips;
    }
}
