package at.htl.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Article {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @Column(length=32000)
    private String content;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="userid")
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    @JoinColumn(name="author_id")
    private User user;

    @OneToMany(mappedBy = "article")
    private List<Comment> commentList = new LinkedList<>();

    public Article() {
    }

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
