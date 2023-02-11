package be.technobel.fbrassine.sandwichspring.validation.constraints;

import be.technobel.fbrassine.sandwichspring.validation.validators.DaysOnPastValidator;
import be.technobel.fbrassine.sandwichspring.validation.validators.PasswordValidValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.temporal.ChronoUnit;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidValidator.class)
public @interface PasswordValid {
    String message() default "Passwords should be the same";
    Class<?>[] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
