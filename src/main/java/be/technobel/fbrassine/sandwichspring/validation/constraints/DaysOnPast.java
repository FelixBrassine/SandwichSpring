package be.technobel.fbrassine.sandwichspring.validation.constraints;

import be.technobel.fbrassine.sandwichspring.validation.validators.DaysOnPastValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.temporal.ChronoUnit;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DaysOnPastValidator.class)
public @interface DaysOnPast {

    int value() default 0;
    ChronoUnit unite() default ChronoUnit.DAYS;
    String message() default "The date is too recent";
    Class<?>[] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
