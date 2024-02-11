package repository;

import entity.Person;
import entity.Ticket;
import org.hibernate.Criteria;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class TicketRepository extends JpaRepository<Ticket, Long>{

    public TicketRepository(EntityManagerFactory emf) {
        super(emf, Ticket.class);
    }

    public List<Ticket> getTicketsByOwner(Person owner) {
        EntityManager em = getEmf().createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Ticket> query = cb.createQuery(Ticket.class);
        Root<Ticket> root = query.from(Ticket.class);

        query.select(root)
                .where(cb.equal(root.get("owner"), owner));
        List<Ticket> tickets = em.createQuery(query).getResultList();

        em.close();
        return tickets;
    }
}
