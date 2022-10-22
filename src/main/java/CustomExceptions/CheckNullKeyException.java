package CustomExceptions;

public class CheckNullKeyException extends Exception {
    public String getMessage() {
        return "Key nonexistent.";
    }
}
