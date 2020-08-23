package ru.petproject.homelibrary.repos;

import org.springframework.data.repository.CrudRepository;
import ru.petproject.homelibrary.domain.Author;

public interface AuthorRepo extends CrudRepository<Author, Integer> {
    Author findByNameAuthor(String nameAuthor);
}
