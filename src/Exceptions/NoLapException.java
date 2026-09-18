package Exceptions;

public class NoLapException extends Exception {
    public NoLapException(String message) {
        super(message);
    }

    public NoLapException(){
        super("Fehler:");
    }
}
