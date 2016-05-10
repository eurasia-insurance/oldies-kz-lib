package com.lapsa.kz.idnumber;

public interface IDNumberValidator {
    boolean isValid(String idNumber);

    boolean isValid(String idNumber, boolean checkDigit);
}
