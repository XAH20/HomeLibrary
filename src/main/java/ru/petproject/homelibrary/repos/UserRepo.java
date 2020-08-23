package ru.petproject.homelibrary.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.petproject.homelibrary.domain.User;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByUsername(String username);
    User findByUserID(Integer userID);
}
