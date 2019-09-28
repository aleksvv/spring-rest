package it.discovery.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BookTitleValidator implements ConstraintValidator<BookTitleConstraint,
        String> {
    @Override
    public boolean isValid(String title, ConstraintValidatorContext context) {
        return Character.isUpperCase(title.charAt(0));
    }

    @Override
    public void initialize(BookTitleConstraint constraintAnnotation) {

    }
}
