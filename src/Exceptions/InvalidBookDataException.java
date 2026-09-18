package Exceptions;

public class InvalidBookDataException extends RuntimeException {
    public InvalidBookDataException() {
        super("Titel, Autor oder ISBN leer");
    }

    public InvalidBookDataException(String message) {
        super(message);
    }


}
