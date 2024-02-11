package repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public abstract class JpaRepository<E, K> {
    private final EntityManagerFactory emf;
    protected final Class<E> clazz;

    public JpaRepository(EntityManagerFactory emf, Class<E> clazz) {
        this.emf = emf;
        this.clazz = clazz;
    }

    public void add(E entity) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(entity);

        transaction.commit();
        em.close();
    }

    public E find(K key) {
        EntityManager em = emf.createEntityManager();

        E entity = em.find(clazz, key);

        em.close();
        return entity;
    }

    public List<E> getAll() {
        EntityManager em = emf.createEntityManager();

        List<E> entities = em.createQuery("SELECT e FROM " + clazz.getSimpleName() + " e", clazz).getResultList();

        em.close();
        return entities;
    }

    public void update(E entity) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.merge(entity);

        transaction.commit();
        em.close();
    }

    public void delete(E entity) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.remove(em.merge(entity));

        transaction.commit();
        em.close();
    }

    protected EntityManagerFactory getEmf() {
        return emf;
    }
}
