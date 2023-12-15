
// ____________________________
// Assignment 2
// © Mukesh Kumar Angrish
// Written by: Mukesh Kumar Angrish (Student ID - 40203596)
// ____________________________

/**
 * Custom exception class that is thrown when a duplicate record is found.
 * @author Mukesh Kumar Angrish
 *
 */
public class DuplicateRecordException extends Exception {
    static final long serialVersionUID = 1L;
    /**
	 * custom errorMessage that the program can throw to the exception
	 */
    String errorMessage;

    /**
     * single parameter constructor that outputs the error message corresponding to the order ID
     * @param order_ID the order ID that is causing the exception
     */
    public DuplicateRecordException(long order_ID) {
        super("Error: Duplicate record found for order_ID " + order_ID);
    }

    /**
     * displays a custom error message from the program
     * @param order_ID the order ID that is causing the exception
     * @param errorMessage the custom error message to be displayed
     */
    public DuplicateRecordException(long order_ID, String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }
}
