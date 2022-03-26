package net.fondbackend.repository;

import javax.mail.Session;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractRepository {
    @PersistenceContext
    protected EntityManager em;

    protected Session getHibernateSession(){
        return (Session) em.getDelegate();
    }
}