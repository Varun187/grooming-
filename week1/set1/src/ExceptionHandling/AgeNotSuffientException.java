package ExceptionHandling;

public class AgeNotSuffientException extends RuntimeException{

    AgeNotSuffientException(String message){
        super(message);
    }
}
