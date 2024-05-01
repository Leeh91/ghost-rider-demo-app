package br.com.demo.annotations.validation;

import jakarta.validation.Constraint;
import jakarta.validation.OverridesAttribute;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import jakarta.validation.constraints.Email;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {})
@Email
public @interface IsValidEmail {

    @OverridesAttribute(constraint = Email.class, name = "message")
    String message() default "Email invalid";

    @AliasFor(annotation = Email.class)
    Class<?>[] groups() default {};

    @AliasFor(annotation = Email.class)
    Class<? extends Payload>[] payload() default {};
}
