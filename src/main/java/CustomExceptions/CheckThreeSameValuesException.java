package CustomExceptions;

public class CheckThreeSameValuesException extends Exception {
    public String getMessage() {
        return "This value is repeat at least three times.";
    }
}
