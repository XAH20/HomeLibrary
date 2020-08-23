package ru.petproject.homelibrary.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "author_id")
    private Integer authorID;

    @Column(name = "name_author")
    private String nameAuthor;

    @ManyToMany(mappedBy = "authors", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Book> books;

    public Author() {
    }

    public Author(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }


    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String name) {
        this.nameAuthor = name;
    }

    public Integer getAuthorID() {
        return authorID;
    }

    public void setAuthorID(Integer authorID) {
        this.authorID = authorID;
    }

    public static class Tag {
        private String nameTag;

        public String getNameTag() {
            return nameTag;
        }

        public void setNameTag(String nameTag) {
            this.nameTag = nameTag;
        }
    }
}
