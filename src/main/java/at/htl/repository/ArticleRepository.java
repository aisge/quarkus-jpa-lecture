package at.htl.repository;

import at.htl.model.Article;
import at.htl.model.Comment;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class ArticleRepository {

    @Inject
    EntityManager em;

    public Article getById(long id) {
        return em.find(Article.class, id);
    }

    public List<Article> getListByUserId(long userId) {
        return em.createQuery("select a from Article a where a.user.userid=:userid")
                .setParameter("userid", userId)
                .getResultList();
    }

}
