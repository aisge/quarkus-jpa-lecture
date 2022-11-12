package at.htl.repository;

import at.htl.model.Comment;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class CommentRepository {
    @Inject
    EntityManager em;

    public Comment getById(long id) {
        return em.find(Comment.class, id);
    }

    public void saveComment(Comment comment) {
        em.persist(comment);
    }


}
