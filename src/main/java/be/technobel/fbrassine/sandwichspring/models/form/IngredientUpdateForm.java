package be.technobel.fbrassine.sandwichspring.models.form;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class IngredientUpdateForm {
    @Size(min=4, message = "4 caracteres minimun")
    private String name;
}
