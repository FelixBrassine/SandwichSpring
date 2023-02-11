package be.technobel.fbrassine.sandwichspring.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter @Setter
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id", nullable = false)
    private long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(
            name="ingredient_sandwich",
            joinColumns = @JoinColumn(name = "ingredient_id"),
            inverseJoinColumns = @JoinColumn(name="sandwich_id")
    )
    private Set<Sandwich> sandwichs = new LinkedHashSet<>();
}
