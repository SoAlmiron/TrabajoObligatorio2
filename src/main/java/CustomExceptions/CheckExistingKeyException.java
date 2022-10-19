package CustomExceptions;

public class CheckExistingKeyException extends Exception {
    public String getMessage() {
        return "This key already exist.";
    }
}
