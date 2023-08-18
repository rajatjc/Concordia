package Assignment.Assignment2;
// ______________
// Assignment 2
// Rajat Sharma
// Written by: Rajat Sharma (Student ID - 40196467)
// ______________
/**
 * An interface for objects that can be watched.
 * @author Rajat Sharma
 */
public interface Groupable {
    /**
     * Returns a string comparison of two Team in the Group.
     *
     * @param T the other Team attributes are to be compared to
     * @return a string comparison of two Teams attributes.
     */
    public boolean isInTheGroup(Team T);

}
