package be.technobel.fbrassine.sandwichspring.repository;

import be.technobel.fbrassine.sandwichspring.models.entity.Sandwich;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SandwichRepository extends JpaRepository<Sandwich,Long> {
}
