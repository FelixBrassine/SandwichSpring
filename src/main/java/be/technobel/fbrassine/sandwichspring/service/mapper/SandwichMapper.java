package be.technobel.fbrassine.sandwichspring.service.mapper;

import be.technobel.fbrassine.sandwichspring.models.dto.IngredientDTO;
import be.technobel.fbrassine.sandwichspring.models.dto.SandwichDTO;
import be.technobel.fbrassine.sandwichspring.models.entity.Ingredient;
import be.technobel.fbrassine.sandwichspring.models.entity.Sandwich;
import be.technobel.fbrassine.sandwichspring.models.form.IngredientInsertForm;
import be.technobel.fbrassine.sandwichspring.models.form.SandwichInsertForm;
import be.technobel.fbrassine.sandwichspring.models.form.SandwichUpdateForm;
import be.technobel.fbrassine.sandwichspring.repository.IngredientRepository;
import be.technobel.fbrassine.sandwichspring.service.IngredientService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SandwichMapper {
    private final IngredientMapper ingredientMapper;
    private final IngredientRepository ingredientRepository;

    public SandwichMapper(IngredientMapper ingredientMapper,
                          IngredientRepository ingredientRepository) {
        this.ingredientMapper = ingredientMapper;
        this.ingredientRepository = ingredientRepository;
    }

    public SandwichDTO toDto(Sandwich entity){

        if (entity == null){
            return null;
        }else {
            return SandwichDTO.builder()
                    .id(entity.getId())
                    .name(entity.getName())
                    .description(entity.getDescription())
                    .price(entity.getPrice())
                    .ingredientDTO(
                            entity.getIngredients().stream()
                                    .map(ingredientMapper::toDto)
                                    .toList()
                    )
                    .build();
        }
    }
    public Sandwich formToEntity(SandwichInsertForm form){
        if (form == null){
            return null;
        }else{
            Sandwich sandwich = new Sandwich();
            sandwich.setName(form.getName());
            sandwich.setDescription(form.getDescription());
            sandwich.setPrice(form.getPrice());

            return sandwich;
        }
    }
    public Sandwich toEntity(SandwichDTO s){

        Sandwich sandwich = new Sandwich();
        sandwich.setName(s.getName());
        sandwich.setDescription(s.getDescription());
        sandwich.setPrice(s.getPrice());
        return sandwich;
    }
}
