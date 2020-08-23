package ru.petproject.homelibrary.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tags")
public class Tag {

    @Id
    @Column(name = "name_tag")
    private String nameTag;

    @ManyToMany(mappedBy = "tags", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Book> books;

    public String getNameTag() {
        return nameTag;
    }

    public void setNameTag(String nameTag) {
        this.nameTag = nameTag;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
