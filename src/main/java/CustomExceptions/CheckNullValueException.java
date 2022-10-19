package CustomExceptions;

public class CheckNullValueException extends Exception{
    public String getMessage() {
        return "This Key don´t have this value.";
    }
}
