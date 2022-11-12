package at.htl.repository;

import at.htl.model.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class UserRepository {
    @Inject
    EntityManager em;

    public User getById (long id) {
        return em.find(User.class, id);
    }
}
