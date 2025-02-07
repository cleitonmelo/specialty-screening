package br.com.hackaton.specialtyscreening.exception;

public class SpecialtyNotFoundException extends RuntimeException {

    public SpecialtyNotFoundException(String message) {
        super(message);
    }
}
