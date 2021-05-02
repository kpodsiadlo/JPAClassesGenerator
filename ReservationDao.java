import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class ReservationDao {
    @PersistenceContext
    EntityManager entityManager;

    public Reservation create (Reservation reservation) {
        entityManager.persist(reservation);
        return reservation;
    }

    public Reservation read(Integer id) {
        Reservation reservation = entityManager.find(Reservation.class, id);
        return reservation;
    }

    public Reservation update (Reservation reservation, Integer id) {
        Reservation reservationToChange = entityManager.find(Reservation.class, id);
        reservationToChange.setId(reservation.getId());
        reservationToChange.setRoom(reservation.getRoom());
        reservationToChange.setReservationStart(reservation.getReservationStart());
        reservationToChange.setReservationEnd(reservation.getReservationEnd());
        reservationToChange.setUser(reservation.getUser());
        return reservationToChange;
    }

    public Boolean delete(Reservation reservation, Integer id) {
        Reservation reservationToDelete = entityManager.find(Reservation.class, id);
        entityManager.remove(reservationToDelete);
        return Boolean.TRUE;
    }

    public List<Reservation> findAll() {
        return (List<Reservation>) entityManager.createQuery("SELECT R FROM Reservation R").getResultList();
    }
}