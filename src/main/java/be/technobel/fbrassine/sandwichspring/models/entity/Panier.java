package be.technobel.fbrassine.sandwichspring.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter@Setter
public class Panier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id", nullable = false)
    private long id;
    @ManyToMany
    @JoinTable(
            name="panier_sandwich",
            joinColumns = @JoinColumn(name = "panier_id"),
            inverseJoinColumns = @JoinColumn(name="sandwich_id")
    )
    private Set<Sandwich> sandwiches = new LinkedHashSet<>();

    @OneToOne(mappedBy="panier")
    private User user;
}
