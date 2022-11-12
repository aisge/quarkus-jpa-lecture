package at.htl.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    private Long id;

    private String text;

    @JsonIgnoreProperties({"firstname", "lastname"})
    @ManyToOne
    private User user;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    private Article article;


    public Comment() {
    }

    public Comment(String text, User user, Article article) {
        this.text = text;
        this.user = user;
        this.article = article;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
