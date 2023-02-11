package be.technobel.fbrassine.sandwichspring.service.impl;

import be.technobel.fbrassine.sandwichspring.exceptions.NotFoundException;
import be.technobel.fbrassine.sandwichspring.models.dto.SandwichDTO;
import be.technobel.fbrassine.sandwichspring.models.entity.Panier;
import be.technobel.fbrassine.sandwichspring.models.entity.Sandwich;
import be.technobel.fbrassine.sandwichspring.models.form.SandwichInsertForm;
import be.technobel.fbrassine.sandwichspring.models.form.SandwichUpdateForm;
import be.technobel.fbrassine.sandwichspring.repository.IngredientRepository;
import be.technobel.fbrassine.sandwichspring.repository.PanierRepository;
import be.technobel.fbrassine.sandwichspring.repository.SandwichRepository;
import be.technobel.fbrassine.sandwichspring.service.SandwichService;
import be.technobel.fbrassine.sandwichspring.service.mapper.SandwichMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class SandwichServiceImpl implements SandwichService {

    private final SandwichRepository sandwichRepository;
    private final SandwichMapper mapper;
    private final IngredientRepository ingredientRepository;
    private final PanierRepository panierRepository;

    public SandwichServiceImpl(SandwichRepository sandwichRepository, SandwichMapper mapper,
                               IngredientRepository ingredientRepository,
                               PanierRepository panierRepository) {
        this.sandwichRepository = sandwichRepository;
        this.mapper = mapper;
        this.ingredientRepository = ingredientRepository;
        this.panierRepository = panierRepository;
    }

    @Override
    public List<SandwichDTO> getAll() {
        return sandwichRepository.findAll().stream()
                .map( mapper ::toDto)
                .toList();
    }

    @Override
    public SandwichDTO getOne(long id) {
        return sandwichRepository.findById(id)
                .map(mapper::toDto)
                .orElseThrow( () -> new NotFoundException("Sandwich not found"));
    }

    @Override
    public void insert(SandwichInsertForm form) {
        if (form == null){
            throw new IllegalArgumentException("form should be not null");
        }else{
            Sandwich entity = mapper.toEntity(form);
            entity.setIngredients(
                    new HashSet<>((ingredientRepository.findAllById(form.getIngredientsId())))
            );
            sandwichRepository.save(entity);
        }
    }

    @Override
    public void update(Long id, SandwichUpdateForm form) {
        Sandwich toUpdate = sandwichRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Sandwich not found"));

        toUpdate.setName( form.getName() );
        toUpdate.setDescription( form.getDescription() );
        toUpdate.setPrice( form.getPrice() );
        toUpdate.setIngredients(
                new HashSet<>(ingredientRepository.findAllById(form.getIngredientsId()))
        );
        sandwichRepository.save(toUpdate);
    }
}
