package Assignment.Assignment3.Submission;// ______________
// Assignment 3
// � Mukesh Kumar Angrish
// Written by: Mukesh Kumar Angrish (Student ID - 40203596)
// ______________

import java.util.Scanner;

/**
 * This class represents a TV show.
 */
public class TVShow implements Watchable {
    // TVShow has the following attributes:
    private String showID; // showID is the unique identifier of the show
    private String showName;
    private double startTime;
    private double endTime;

    /**
     * Returns the showID of the TV Show.
     *
     * @return the showID of the TV Show.
     */
    public String getShowID() {
        return showID;
    }

    /**
     * Modifies the showName of the TV Show.
     *
     * @param showName the new showName of the TV Show.
     */
    public void setShowName(String showName) {
        this.showName = showName;
    }

    /**
     * Returns the showName of the TV Show.
     *
     * @return the showName of the TV Show.
     */
    public String getShowName() {
        return showName;
    }

    /**
     * Modifies the startTime of the TV Show.
     *
     * @param startTime the new startTime of the TV Show.
     */
    public void setStartTime(double startTime) {
        this.startTime = startTime;
    }

    /**
     * Returns the startTime of the TV Show.
     *
     * @return the startTime of the TV Show.
     */
    public double getStartTime() {
        return startTime;
    }

    /**
     * Modifies the endTime of the TV Show.
     *
     * @param endTime the new endTime of the TV Show.
     */
    public void setEndTime(double endTime) {
        this.endTime = endTime;
    }

    /**
     * Returns the endTime of the TV Show.
     *
     * @return the endTime of the TV Show.
     */
    public double getEndTime() {
        return endTime;
    }

    /**
     * Constructs a TV Show with the given parameters.
     *
     * @param showID    the showID of the TV Show.
     * @param showName  the showName of the TV Show.
     * @param startTime the startTime of the TV Show.
     * @param endTime   the endTime of the TV Show.
     */
    public TVShow(String showID, String showName, double startTime, double endTime) {
        this.showID = showID;
        this.showName = showName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * Constructs a TV Show from another TV Show.
     *
     * @param S      the TV Show to be copied.
     * @param showID the showID of the new TV Show.
     */
    public TVShow(TVShow S, String showID) {
        this.showID = showID;
        this.showName = S.getShowName();
        this.startTime = S.getStartTime();
        this.endTime = S.getEndTime();
    }

    /**
     * Clones the TV Show details and returns a deep copy of the original TV Show.
     *
     * @return a new TV Show with the same details as the original.
     * asks the user for the showID of the new TV Show.
     */
    public TVShow clone() {
        System.out.println("Enter the showID of the show you want to clone: ");
        Scanner userInput = new Scanner(System.in);
        String showID1 = userInput.nextLine();
        userInput.close();
        TVShow S = new TVShow(this, showID1);
        return S;
    }

    /**
     * Returns the details of the TV Show.
     *
     * @return the details of the TV Show.
     */
    public String toString() {
        return "Show ID: " + showID + "\tShow Name: " + showName + "\tStart Time: " + startTime + "\tEnd Time: " + endTime;
    }

    /**
     * checks if the TV Show is equal to the given TV Show.
     *
     * @param S the TV Show to be compared.
     * @return true if the TV Shows are equal, false otherwise.
     * two TV Shows are equal if they have the same showName, startTime and endTime.
     */
    public boolean equals(TVShow S) {
        if (this.showName.equals(S.getShowName()) && this.startTime == S.getStartTime() && this.endTime == S.getEndTime()) {
            return true;
        }
        return false;
    }

    /**
     * Checks if the TV Show is on the same time as the given TV Show.
     *
     * @param S the TV Show to be compared.
     * @return "Same time" if the TV Shows are on the same time, "Some Overlap" if they overlap, and "Different time" otherwise.
     * 1. "Same time" if both startTime and endTime of S and this show are the same
     * 2. "Some Overlap" if either the startTime or endTime of the TV Show is between the startTime and endTime of the compared TV Show S
     * 3. "Different time" if neither of the above conditions are true
     */
    public String isOnSameTime(TVShow S) {
        if (this.startTime == S.getStartTime() && this.endTime == S.getEndTime()) {
            return "Same time";
        } else if (this.startTime > S.getStartTime() && this.startTime < S.getEndTime()) {
            return "Some Overlap";
        } else if (this.endTime > S.getStartTime() && this.endTime < S.getEndTime()) {
            return "Some Overlap";
        } else {
            return "Different time";
        }
    }
}
