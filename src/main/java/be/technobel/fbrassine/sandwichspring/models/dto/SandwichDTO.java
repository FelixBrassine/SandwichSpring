package be.technobel.fbrassine.sandwichspring.models.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Builder
public class SandwichDTO {
    private long id;
    private String name;
    private String description;
    private double price;
    private List<IngredientDTO> ingredientDTO;
    private List<PanierDTO> paniersDTO;
}
