package be.technobel.fbrassine.sandwichspring.service.mapper;

import be.technobel.fbrassine.sandwichspring.models.dto.IngredientDTO;
import be.technobel.fbrassine.sandwichspring.models.form.IngredientInsertForm;
import be.technobel.fbrassine.sandwichspring.models.form.IngredientUpdateForm;
import be.technobel.fbrassine.sandwichspring.models.entity.Ingredient;
import be.technobel.fbrassine.sandwichspring.repository.IngredientRepository;
import be.technobel.fbrassine.sandwichspring.service.IngredientService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class IngredientMapper {

    public IngredientDTO toDto(Ingredient entity){

        if (entity == null){
            return null;
        }else {
            return IngredientDTO.builder()
                    .id(entity.getId())
                    .name(entity.getName())
                    .build();
        }
    }
    public Ingredient toEntity(IngredientInsertForm form){
        if (form == null){
            return null;
        }else{
            Ingredient ingredient = new Ingredient();
            ingredient.setName(form.getName());
            return ingredient;
        }
    }
    public Ingredient toEntity(IngredientUpdateForm form){
        if (form == null){
            return null;
        }else{
            Ingredient ingredient = new Ingredient();
            ingredient.setName(form.getName());
            return ingredient;
        }
    }

}
