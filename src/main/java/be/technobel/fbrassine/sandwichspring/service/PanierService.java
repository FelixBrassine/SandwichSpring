package be.technobel.fbrassine.sandwichspring.service;

import be.technobel.fbrassine.sandwichspring.models.dto.PanierDTO;
import be.technobel.fbrassine.sandwichspring.models.dto.SandwichDTO;
import be.technobel.fbrassine.sandwichspring.models.entity.Sandwich;
import be.technobel.fbrassine.sandwichspring.models.form.PanierInsertForm;

import java.util.List;

public interface PanierService {
    PanierDTO getOne(long id);
    List<SandwichDTO> getAllSand(Long id);
    void addSand(Long id);
    void delete(Long id);
}
