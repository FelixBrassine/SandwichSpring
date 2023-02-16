package be.technobel.fbrassine.sandwichspring.models.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PanierDTO {
    private long id;
    private double total;
}
