package Exceptions;

public class NoSpaceException extends Exception {
    public NoSpaceException(){
        super("No Space Exception");
    }

    public NoSpaceException(String message){
        super(message);
    }
}
