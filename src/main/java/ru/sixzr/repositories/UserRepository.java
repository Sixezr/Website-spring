package ru.sixzr.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.sixzr.models.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByPhone(String phone);
    boolean existsByPhone(String phone);
}
