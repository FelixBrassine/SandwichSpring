package be.technobel.fbrassine.sandwichspring.models.form;

import be.technobel.fbrassine.sandwichspring.models.entity.Ingredient;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
public class SandwichUpdateForm {

    @Size(min=4, message = "4 caracteres minimun")
    private String name;
    private String description;
    @Positive(message = "must be positive")
    @Digits(integer = 2, fraction = 2)
    private double price;
    @Size(min = 2, message = "2 ingredients minimum")
    private Set<Long> ingredientsId;
}
