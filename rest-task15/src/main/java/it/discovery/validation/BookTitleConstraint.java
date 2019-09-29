package it.discovery.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = BookTitleValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface BookTitleConstraint {
    String message() default "Book title should start with capital letter";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
