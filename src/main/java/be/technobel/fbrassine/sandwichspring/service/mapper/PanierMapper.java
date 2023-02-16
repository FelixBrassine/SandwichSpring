package be.technobel.fbrassine.sandwichspring.service.mapper;

import be.technobel.fbrassine.sandwichspring.models.dto.PanierDTO;
import be.technobel.fbrassine.sandwichspring.models.entity.Panier;
import be.technobel.fbrassine.sandwichspring.models.form.PanierInsertForm;

import org.springframework.stereotype.Service;

@Service
public class PanierMapper {
    public PanierDTO toDto(Panier entity){

        if (entity == null){
            return null;
        }else {
            return PanierDTO.builder()
                    .id(entity.getId())
                    .build();
        }
    }

    public Panier formToEntity(PanierInsertForm form) {
        if (form == null){
            return null;
        }else{
            Panier panier = new Panier();
            return panier;
        }
    }
}
