package be.technobel.fbrassine.sandwichspring.models.dto;

import be.technobel.fbrassine.sandwichspring.models.entity.Ingredient;
import be.technobel.fbrassine.sandwichspring.models.entity.Sandwich;
import lombok.Builder;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Builder
public class IngredientDTO {
    private long id;
    private String name;
}
