package br.com.softblue.bluefood.infrastructure.web.validator;

import br.com.softblue.bluefood.util.Filetype;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
@Constraint(validatedBy = UploadValidator.class )
public @interface UploadConstraint {
    String message() default "Arquivo Inválido";
    Filetype[] acceptedTypes();

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
