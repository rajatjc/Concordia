
// ____________________________
// Assignment 2
// © Mukesh Kumar Angrish
// Written by: Mukesh Kumar Angrish (Student ID - 40203596)
// ____________________________

import java.io.IOException;

/**
 * Custom exception class that is thrown when a folder is empty.
 * @author Mukesh Kumar Angrish
 *
 */
public class EmptyFolderException extends IOException {
    static final long serialVersionUID = 1L;
    /**
	 * custom errorMessage that the program can throw to the exception
	 */
    String errorMessage;

    /**
     * single parameter constructor that outputs the error message corresponding to the folder name that is empty
     * @param folderName the folder name that is causing the exception
     */
    public EmptyFolderException(String folderName) {
        super("Error: Input folder " + folderName + " is empty");
    }

    /**
     * displays a custom error message from the program
     * @param folderName the folder name that is causing the exception
     * @param errorMessage the custom error message to be displayed
     */
    public EmptyFolderException(String folderName, String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }
}
