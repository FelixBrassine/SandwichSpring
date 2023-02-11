package be.technobel.fbrassine.sandwichspring.validation.validators;

import be.technobel.fbrassine.sandwichspring.validation.constraints.DaysOnPast;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;

@Component
public class DaysOnPastValidator implements ConstraintValidator<DaysOnPast, LocalDate> {

    private int daysOnPast;
    private TemporalUnit chronoUnit;

    @Override
    public void initialize(DaysOnPast constraintAnnotation){
        daysOnPast = constraintAnnotation.value();
        chronoUnit = constraintAnnotation.unite();
    }

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
//        if (chronoUnit == ChronoUnit.SECONDS){
//            return value.isBefore(LocalDateTime.now().minusSeconds(daysOnPast));
//        }else if (chronoUnit == ChronoUnit.MINUTES) {
//            return value.isBefore(LocalDateTime.now().minusMinutes(daysOnPast));
//        }else if (chronoUnit == ChronoUnit.HOURS) {
//            return value.isBefore(LocalDateTime.now().minusHours(daysOnPast));
//        }else if (chronoUnit == ChronoUnit.DAYS){
//            return value.isBefore(LocalDateTime.now().minusDays(daysOnPast));
//        }else if (chronoUnit == ChronoUnit.MONTHS) {
//            return value.isBefore(LocalDateTime.now().minusMonths(daysOnPast));
//        }else {
//            return value.isBefore(LocalDateTime.now().minusYears(daysOnPast));
//        }
//        return value.equals(LocalDateTime.now().minus(daysOnPast, chronoUnit));
//       return  LocalDate.now().minus(value. (LocalDate.now()));
//       < LocalDateTime.now().minus(daysOnPast, chronoUnit);
        return value.isBefore(LocalDate.now().minus(daysOnPast, chronoUnit));

    }
}
