package ru.petproject.homelibrary.repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.petproject.homelibrary.domain.Book;

import java.util.List;

public interface BookRepo extends CrudRepository<Book, Integer> {
    Book findByBookID(Integer bookID);

    List<Book> findByTitle(String title);

    /*@Query("select new ru.petproject.homelibrary.domain.dto.BookDto() " +
            "from books b " +
            "join authors_and_books ab " +
            "on b.book_id = ab.book_id " +
            "join authors a " +
            "on ab.author_id = a.author_id " +
            "order by b.title;")
    String[] findAll();*/
}
