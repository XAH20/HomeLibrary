package ru.petproject.homelibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.petproject.homelibrary.model.ProcessAddBookRequest;
import ru.petproject.homelibrary.service.BooksService;
import ru.petproject.homelibrary.service.MainService;

@Controller
//@RequestMapping("/books")
public class BooksController {

    private BooksService booksService;
    private MainService mainService;

    @Autowired
    public BooksController(BooksService booksService, MainService mainService) {
        this.booksService = booksService;
        this.mainService = mainService;
    }

    @GetMapping("/main")
    public String main (@RequestParam(required = false,
            defaultValue = "") String filter, Model model) {
        mainService.main(filter, model);
        return "main";
    }

    @GetMapping("/addBook")
    public String addNewBook() {
        return "addBook";
    }

    @PostMapping("/addBook")
    public String addNewBook(ProcessAddBookRequest request, Model model) {
        booksService.addNewBook(request, model);
        return "addBook";
    }

    /*@GetMapping("/modifyBook")
    public String modifyBook(@RequestParam Integer bookID, Model model) {
        //booksService.modifyBook(bookID, model);
        return "modifyBook";
    }*/

    /*@PutMapping("/addAuthor")
    public String addNewAuthor(@RequestParam String nameAuthor) {
        Author authorFromDB = authorRepo.findByNameAuthor(nameAuthor);
        if (authorFromDB != null) {
            return "Автор уже есть в базе!";
        } else {
            Author newAuthor = new Author();
            newAuthor.setNameAuthor(nameAuthor);
            authorRepo.save(newAuthor);
            return "Автор добавлен";
        }
    }

    @GetMapping("/addAuthorBook")
    public String addNewBook(Book book, Author author) {
        Book bookFromDB = bookRepo.findByBookID(book.getBookID());
        Author authorFromDB = authorRepo.findByNameAuthor(author.getNameAuthor());
        if (authorFromDB == null) {
            return "Автора нет в базе";
        }
        Set<Author> authors = bookFromDB.getAuthors();
        for (Author a : authors) {
            if (a.getNameAuthor().equals(author.getNameAuthor())) {
                return "Автор был добавлен ранее";
            }
        }
        bookFromDB.addAuthor(authorFromDB);
        bookRepo.save(bookFromDB);
        return "Автор добавлен";
    }*/



}
