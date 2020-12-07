package com.dovile.javafuncional.combinatorpattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;
import static com.dovile.javafuncional.combinatorpattern.CutomerRegistrationValidator.ValidationResult;
import static com.dovile.javafuncional.combinatorpattern.CutomerRegistrationValidator.ValidationResult.*;

/**
 * @author Dovile Barkauskaite <barkauskaite.dovile@gmail.com>
 */
public interface CutomerRegistrationValidator extends Function<Customer, ValidationResult> {

    static CutomerRegistrationValidator isEmailValid(){
        return customer -> customer.getEmail().contains("@") ?
                SUCCESS : EMAIL_NOT_VALID;
    }

    static CutomerRegistrationValidator isPhoneValid(){
        return customer -> customer.getPhoneNumber().contains("+3") ?
                SUCCESS : PHONE_NUMBER_NOT_VALID;
    }

    static CutomerRegistrationValidator isAdult(){
        return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() > 16 ?
                SUCCESS : IS_NOT_AN_ADULT;
    }

    default CutomerRegistrationValidator and (CutomerRegistrationValidator other){
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(SUCCESS) ? other.apply(customer) : result;
        };
    }

    enum ValidationResult{
        SUCCESS,
        PHONE_NUMBER_NOT_VALID,
        EMAIL_NOT_VALID,
        IS_NOT_AN_ADULT
    }
}
