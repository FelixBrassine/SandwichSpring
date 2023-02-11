package be.technobel.fbrassine.sandwichspring.service.impl;

import be.technobel.fbrassine.sandwichspring.exceptions.NotFoundException;
import be.technobel.fbrassine.sandwichspring.models.dto.IngredientDTO;
import be.technobel.fbrassine.sandwichspring.models.entity.Ingredient;
import be.technobel.fbrassine.sandwichspring.models.form.IngredientInsertForm;
import be.technobel.fbrassine.sandwichspring.models.form.IngredientUpdateForm;
import be.technobel.fbrassine.sandwichspring.repository.IngredientRepository;
import be.technobel.fbrassine.sandwichspring.service.IngredientService;
import be.technobel.fbrassine.sandwichspring.service.mapper.IngredientMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngServiceImpl implements IngredientService {


    private final IngredientRepository ingredientRepository;
    private final IngredientMapper mapper;

    public IngServiceImpl(IngredientRepository ingredientRepository, IngredientMapper mapper) {
        this.ingredientRepository = ingredientRepository;
        this.mapper = mapper;
    }

    @Override
    public List<IngredientDTO> getAll() {
        return ingredientRepository.findAll().stream()
                .map( mapper ::toDto)
                .toList();
    }

    @Override
    public IngredientDTO getOne(long id) {
        return ingredientRepository.findById(id)
                .map(mapper::toDto)
                .orElseThrow( () -> new NotFoundException("Ingredient not found"));
    }

    @Override
    public void insert(IngredientInsertForm form) {
        if (form == null){
            throw new IllegalArgumentException("form should be not null");
        }else{
            Ingredient entity = mapper.toEntity(form);
            ingredientRepository.save(entity);

        }
    }

    @Override
    public void update(Long id, IngredientUpdateForm form) {
        Ingredient toUpdate = ingredientRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Ingredient not found"));
        toUpdate.setName( form.getName() );
        ingredientRepository.save(toUpdate);
    }
}
