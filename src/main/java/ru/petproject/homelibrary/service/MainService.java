package ru.petproject.homelibrary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import ru.petproject.homelibrary.domain.Book;
import ru.petproject.homelibrary.repos.AuthorRepo;
import ru.petproject.homelibrary.repos.BookRepo;

import java.util.Collections;
import java.util.List;

@Service
public class MainService {
    private BookRepo bookRepo;
    private AuthorRepo authorRepo;

    @Autowired
    public MainService(BookRepo bookRepo, AuthorRepo authorRepo) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
    }

    public void main (String filter, Model model) {
        Iterable<Book> allBooks = bookRepo.findAll();
        if (filter != null && !filter.isEmpty()) {
            allBooks = bookRepo.findByTitle(filter);
        }
        model.addAttribute("allbooks", allBooks);
        model.addAttribute("filter", filter);
    }
}
