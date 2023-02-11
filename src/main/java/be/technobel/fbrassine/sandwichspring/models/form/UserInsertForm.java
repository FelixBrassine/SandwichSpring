package be.technobel.fbrassine.sandwichspring.models.form;

import be.technobel.fbrassine.sandwichspring.validation.constraints.DaysOnPast;
import be.technobel.fbrassine.sandwichspring.validation.constraints.PasswordValid;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Data
@PasswordValid
public class UserInsertForm {

    @NotBlank
    @Email
    private String email;
    @Size(min = 4)
    @NotBlank
    private String password;
    @NotBlank
    private String passwordValid;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @DaysOnPast(value = 15, unite = ChronoUnit.DAYS, message = "sould be 15 days on the past")
    private LocalDate birthDate;
}
