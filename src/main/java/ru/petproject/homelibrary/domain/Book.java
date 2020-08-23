package ru.petproject.homelibrary.domain;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private Integer bookID;

    private String title;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "authors_and_books",
        joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> authors;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tags_for_books",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "name_tag")
    )
    private Set<Tag> tags;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "read_users",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> readUsers;

    public Book() {
        authors = new HashSet<>();
        tags = new HashSet<>();
        readUsers = new HashSet<>();
    }

    public Integer getBookID() {
        return bookID;
    }

    public void setBookID(Integer id) {
        this.bookID = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public Set<User> getReadUsers() {
        return readUsers;
    }

    public void setReadUsers(Set<User> readUsers) {
        this.readUsers = readUsers;
    }

    /***
     * Добавляет нового автора книги
     * @param author Новый автор книги
     */
    public void addAuthor(Author author) {
        this.authors.add(author);
    }
}
