package ru.eremenko.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.eremenko.demo.model.User;

import java.util.List;

public interface UserRepo extends JpaRepository<User,Long> {
    List<User> findUserByUsernameStartingWithAndGender(String start,String gender);
    List<User> findDistinctByUsernameAndBirthday();
}
