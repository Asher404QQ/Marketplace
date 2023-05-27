package ru.kors.marketplace.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kors.marketplace.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
