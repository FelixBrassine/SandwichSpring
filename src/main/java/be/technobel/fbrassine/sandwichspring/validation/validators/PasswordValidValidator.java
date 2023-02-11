package be.technobel.fbrassine.sandwichspring.validation.validators;

import be.technobel.fbrassine.sandwichspring.models.form.UserInsertForm;
import be.technobel.fbrassine.sandwichspring.validation.constraints.PasswordValid;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class PasswordValidValidator implements ConstraintValidator<PasswordValid, UserInsertForm> {


    @Override
    public boolean isValid(UserInsertForm value, ConstraintValidatorContext context) {
        return value.getPassword().equals(value.getPasswordValid());
    }
}
