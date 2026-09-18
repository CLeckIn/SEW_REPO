package Exceptions;

public class LibraryFullException extends RuntimeException {
    public LibraryFullException() {
        super("Die Büchrei ist voll");
    }


    public LibraryFullException(String message) {
        super(message);
    }
}
