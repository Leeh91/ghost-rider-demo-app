package br.com.demo.validators;

import br.com.demo.annotations.validation.IsCpfValid;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

public class CpfValidator implements ConstraintValidator<IsCpfValid, String> {

    @Override
    public void initialize(IsCpfValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String cpf, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isBlank(cpf)) {
            return true;
        }
        
        String nonDigitCpf = removeNonDigits(cpf);

        if(!isValidLength(nonDigitCpf)) return false;
        if(isAllDigitsEquals(nonDigitCpf)) return false;

        int firstDigit = calculateDigit(nonDigitCpf, 10);
        int secondDigit = calculateDigit(nonDigitCpf, 11);

        return extractDigit(nonDigitCpf).equals(String.valueOf(firstDigit) + String.valueOf(secondDigit));
    }

    private String removeNonDigits (String cpf) {
        return cpf.replaceAll("\\D","");
    }

    private boolean isValidLength(String cpf) {
        return cpf.length() == 11;
    }

    private boolean isAllDigitsEquals(String cpf) {
        return cpf.chars().distinct().count() == 1;
    }

    private int calculateDigit(String cpf, int factor) {
        int total = 0;
        for(char digit : cpf.toCharArray()) {
            if(factor > 1) {
                total += Integer.parseInt(String.valueOf(digit)) * factor--;
            }
        }
        int remainder = total % 11;
        return remainder < 2 ? 0 : 11 - remainder;
    }

    private String extractDigit(String cpf){
        return cpf.substring(9);
    }
}
