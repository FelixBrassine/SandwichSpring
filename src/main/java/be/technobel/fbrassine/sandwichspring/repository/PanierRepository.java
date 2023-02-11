package be.technobel.fbrassine.sandwichspring.repository;

import be.technobel.fbrassine.sandwichspring.models.entity.Panier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PanierRepository extends JpaRepository<Panier, Long> {
}
