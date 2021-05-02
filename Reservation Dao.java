import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class Reservation Dao {
    @PersistenceContext
    EntityManager entityManager;

    public Reservation  create (Reservation  reservation ) {
        entityManager.persist(reservation );
        return reservation ;
    }

    public Reservation  read(Integer id) {
        Reservation  reservation  = entityManager.find(Reservation .class, id);
        return reservation ;
    }

    public Reservation  update (Reservation  reservation , Integer id) {
        Reservation  reservation ToChange = entityManager.find(Reservation .class, id);
        reservation ToChange.setId(reservation .getId());
reservation ToChange.setRoom(reservation .getRoom());
reservation ToChange.setReservationstart(reservation .getReservationstart());
reservation ToChange.setReservationend(reservation .getReservationend());
reservation ToChange.setUser(reservation .getUser());
        return reservation ToChange;
    }

    public Boolean delete(Reservation  reservation , Integer id) {
        Reservation  reservation ToDelete = entityManager.find(Reservation .class, id);
        entityManager.remove(reservation ToDelete);
        return Boolean.TRUE;
    }

    public List<Reservation > findAll() {
        return (List<Reservation >) entityManager.createQuery("SELECT R FROM Reservation  R").getResultList();
    }
}