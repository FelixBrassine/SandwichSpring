package be.technobel.fbrassine.sandwichspring.repository;

import be.technobel.fbrassine.sandwichspring.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);

}
