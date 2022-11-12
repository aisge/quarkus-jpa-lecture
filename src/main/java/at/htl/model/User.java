package at.htl.model;

import javax.persistence.*;

@Entity
@Table(name="Users")
public class User {
    @Id
    @GeneratedValue
    private Long userid;

    @Column(name="USERNAME", length=20)
    private String username;

    @Column(length=50)
    private String firstname;

    @Column(length=50)
    private String lastname;

    public User() {
    }

    public User(String username, String firstname, String lastname) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
