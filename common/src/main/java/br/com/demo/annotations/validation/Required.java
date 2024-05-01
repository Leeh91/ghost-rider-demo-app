package br.com.demo.annotations.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import jakarta.validation.constraints.NotNull;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ReportAsSingleViolation
@Constraint(
        validatedBy = {}
)
@NotNull
public @interface Required {
    @AliasFor(annotation = NotNull.class)
    String message() default "must not be null";

    @AliasFor(annotation = NotNull.class)
    Class<?>[] groups() default {};

    @AliasFor(annotation = NotNull.class)
    Class<? extends Payload>[] payload() default {};
}
