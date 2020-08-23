package ru.petproject.homelibrary.domain;



import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "usr")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "user_id")
    private Integer userID;

    private String username;
    private String password;
    private boolean active;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    @ManyToMany(mappedBy = "readUsers", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Book> readBooks;

    public User() {
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer id) {
        this.userID = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Book> getReadBooks() {
        return readBooks;
    }

    public void setReadBooks(Set<Book> readBooks) {
        this.readBooks = readBooks;
    }
}
