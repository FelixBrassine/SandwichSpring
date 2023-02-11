package be.technobel.fbrassine.sandwichspring.service;

import be.technobel.fbrassine.sandwichspring.models.dto.IngredientDTO;
import be.technobel.fbrassine.sandwichspring.models.form.IngredientInsertForm;
import be.technobel.fbrassine.sandwichspring.models.form.IngredientUpdateForm;

import java.util.List;

public interface IngredientService {
    List<IngredientDTO> getAll();
    IngredientDTO getOne(long id);
    void insert(IngredientInsertForm form);
    void update(Long id, IngredientUpdateForm form);
}
