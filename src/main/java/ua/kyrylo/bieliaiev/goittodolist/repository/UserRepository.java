package ua.kyrylo.bieliaiev.goittodolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kyrylo.bieliaiev.goittodolist.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
