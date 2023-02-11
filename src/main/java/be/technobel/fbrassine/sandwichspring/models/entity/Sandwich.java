package be.technobel.fbrassine.sandwichspring.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Getter @Setter
public class Sandwich {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sandwich_id", nullable = false)
    private long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private double price;

    @ManyToMany
    private Set<Ingredient> ingredients;
    @ManyToMany
    private Set<Panier> paniers;

}
