package be.technobel.fbrassine.sandwichspring.repository;

import be.technobel.fbrassine.sandwichspring.models.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient,Long> {
}
