package ru.petproject.homelibrary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import ru.petproject.homelibrary.domain.Author;
import ru.petproject.homelibrary.domain.Book;
import ru.petproject.homelibrary.model.ProcessAddBookRequest;
import ru.petproject.homelibrary.repos.AuthorRepo;
import ru.petproject.homelibrary.repos.BookRepo;

import java.util.List;

@Service
public class BooksService {
    private BookRepo bookRepo;
    private AuthorRepo authorRepo;

    @Autowired
    public BooksService(BookRepo bookRepo, AuthorRepo authorRepo) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
    }

    public void addNewBook(ProcessAddBookRequest request, Model model) {
        if(request.getTitle().equals("") || request.getAuthor().equals("")) {
            model.addAttribute("messageNewBook", "Поля не могут быть пустыми");
            return;
        }
        List<Book> booksFromDB = bookRepo.findByTitle(request.getTitle());

        if (booksFromDB != null) {
            for (Book book :
                    booksFromDB) {
                if (book.getAuthors() != null) {
                    for (Author author :
                            book.getAuthors()) {
                        if (request.getTitle().equals(book.getTitle()) &&
                                request.getAuthor().equals(author.getNameAuthor())) {
                            model.addAttribute("messageNewBook", "Книга этого автора с таким названием уже есть в базе");
                            return;
                        }
                    }
                }
            }
        }
        Book newBook = new Book();
        newBook.setTitle(request.getTitle());
        Author author = authorRepo.findByNameAuthor(request.getAuthor());
        Author newAuthor = null;
        if (author != null) {
            newAuthor = author;
        } else {
            newAuthor = new Author(request.getAuthor());
            authorRepo.save(newAuthor);
        }
        newBook.addAuthor(newAuthor);
        bookRepo.save(newBook);
        model.addAttribute("messageNewBook", "Книга добавлена!");
    }

    /*public void modifyBook(Integer bookID, Model model) {
        Book bookFromDB = bookRepo.findByBookID(bookID);
        model.addAttribute("book", bookFromDB);
    }*/
}
