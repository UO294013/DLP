package errorhandler;

import ast.types.ErrorType;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ErrorHandler {

    private static ErrorHandler instance;
    public static List<ErrorType> errors = new ArrayList<ErrorType>();

    private ErrorHandler() {
    }

    public static ErrorHandler getInstance() {
        if (instance == null) {
            instance = new ErrorHandler();
        }
        return instance;
    }

    public static void addError(ErrorType error) {
        errors.add(error);
    }

    public void showErrors(PrintStream out) {
        for (ErrorType error : errors) {
            out.println(error.toString());
        }
    }

    public boolean anyError() {
        return !errors.isEmpty();
    }

    @Override
    public String toString() {
        return "ErrorHandler [errors=" + errors.toString() + "]";
    }
}
