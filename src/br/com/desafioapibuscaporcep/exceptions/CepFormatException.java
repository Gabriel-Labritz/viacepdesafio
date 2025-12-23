package br.com.desafioapibuscaporcep.exceptions;

public class CepFormatException extends RuntimeException {
    public CepFormatException(String message) {
        super(message);
    }
}
