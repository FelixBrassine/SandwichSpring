package be.technobel.fbrassine.sandwichspring.service;

import be.technobel.fbrassine.sandwichspring.models.dto.PanierDTO;
import be.technobel.fbrassine.sandwichspring.models.dto.SandwichDTO;
import be.technobel.fbrassine.sandwichspring.models.form.PanierInsertForm;
import be.technobel.fbrassine.sandwichspring.models.form.SandwichUpdateForm;

import java.util.List;

public interface PanierService {
    PanierDTO getOne(long id);
}
