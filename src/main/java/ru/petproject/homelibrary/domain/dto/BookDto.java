package ru.petproject.homelibrary.domain.dto;

import ru.petproject.homelibrary.domain.Book;

public class BookDto {
    private Integer bookID;
    private String title;
    private String nameAuthor;

    public BookDto(Book book, String nameAuthor) {
        this.bookID = book.getBookID();
        this.title = book.getTitle();
        this.nameAuthor = nameAuthor;
    }
}
