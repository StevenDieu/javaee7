package org.kearis.formation.javaee7.chapitre6;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

import static org.kearis.formation.javaee7.chapitre6.JsfUser.*;


/**
 * Created by steven on 08/12/2016.
 */
@Stateless
@Remote
@Named
public class UserEJB {

    // ======================================
    // =             Attributes             =
    // ======================================

    @PersistenceContext(unitName = "jsfExample")
    private EntityManager em;

    // ======================================
    // =           Public Methods           =
    // ======================================

    public JsfUser createUser(JsfUser user) {
        em.persist(user);
        return user;
    }

    public List<JsfUser> findAllUser() {
        TypedQuery<JsfUser> query = em.createNamedQuery(FIND_ALL, JsfUser.class);
        em.joinTransaction();
        return query.getResultList();
    }

    public JsfUser getUser(int id){
        return em.find(JsfUser.class, id);
    }
}
