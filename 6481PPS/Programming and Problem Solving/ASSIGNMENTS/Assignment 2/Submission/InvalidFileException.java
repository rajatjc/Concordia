
// ____________________________
// Assignment 2
// © Mukesh Kumar Angrish
// Written by: Mukesh Kumar Angrish (Student ID - 40203596)
// ____________________________

import java.io.IOException;

/**
 * Custom exception class that is thrown when a file is invalid.
 * @author Mukesh Kumar Angrish
 *
 */
public class InvalidFileException extends IOException {
	static final long serialVersionUID = 1L;
	/**
	 * custom errorMessage that the program can throw to the exception
	 */
    String errorMessage;
    
    /**
     * single parameter constructor that outputs the error message corresponding to the file name that is invalid
     * @param fileName the file name that is causing the exception
     */
    public InvalidFileException(String fileName) {
        super("Error: Input file named " + fileName + " cannot be found");
    }

    /**
     * displays a custom error message from the program
     * @param fileName the file name that is causing the exception
     * @param errorMessage the custom error message to be displayed
     */
    public InvalidFileException(String fileName, String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }
}
