package be.technobel.fbrassine.sandwichspring.models.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class UserDTO {
    private long id;
    private String email;
    private String password;
    private String role;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Boolean enabled;
    private Boolean blackListed;
}
