package be.technobel.fbrassine.sandwichspring.service;

import be.technobel.fbrassine.sandwichspring.models.dto.SandwichDTO;
import be.technobel.fbrassine.sandwichspring.models.form.IngredientInsertForm;
import be.technobel.fbrassine.sandwichspring.models.form.SandwichInsertForm;
import be.technobel.fbrassine.sandwichspring.models.form.SandwichUpdateForm;

import java.util.List;

public interface SandwichService {

    List<SandwichDTO> getAll();
    SandwichDTO getOne(long id);
    void insert(SandwichInsertForm form);
    void update(Long id, SandwichUpdateForm form);

}
