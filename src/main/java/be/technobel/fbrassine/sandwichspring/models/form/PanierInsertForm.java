package be.technobel.fbrassine.sandwichspring.models.form;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Set;

@Data
public class PanierInsertForm {
    @NotNull
    private Long  sandwichId;

}
