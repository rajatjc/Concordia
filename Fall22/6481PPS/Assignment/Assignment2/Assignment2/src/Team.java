// ______________
// Assignment 2
// Rajat Sharma
// Written by: Rajat Sharma (Student ID - 40196467)
// ______________

import java.util.Scanner;

/**
 * This class represents a Team.
 */
public class Team implements Groupable{

    private String teamID;//teamID is used to uniquely identify the team
    private String teamName;
    private int gamesPlayed;
    private int gamesWon;
    private int gamesLost;
    private double netRunRate;
    private int points;
    private String flag;
    private String group;

    /**
     * Returns the teamID of the given team.
     *
     * @return the teamID of the given team.
    */
    public String getTeamID() {
        return teamID;
    }

    /**
     * Returns the teamName of the given team.
     *
     * @return the teamName of the given team.
     */

    public String getTeamName() {
        return teamName;
    }

    /**
     * Assigns the teamName of the given team.
     *
     * @param teamName name of the given team.
     */


    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    /**
     * Returns the gamesPlayed by the given team.
     *
     * @return the gamesPlayed by the given team.
     */

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    /**
     * Assigns the gamesPlayed by the given team.
     *
     * @param gamesPlayed games played by the given team.
     */

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    /**
     * Returns the gamesWon by the given team.
     *
     * @return the gamesWon by the given team.
     */

    public int getGamesWon() {
        return gamesWon;
    }

    /**
     * Assigns the gamesWon by the given team.
     *
     * @param gamesWon games won by the given team.
     */


    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    /**
     * Returns the gamesLost by the given team.
     *
     * @return the gamesLost by the given team.
     */

    public int getGamesLost() {
        return gamesLost;
    }

    /**
     * Assigns the gamesLost by the given team.
     *
     * @param gamesLost games lost by the given team.
     */

    public void setGamesLost(int gamesLost) {
        this.gamesLost = gamesLost;
    }

    /**
     * Returns the netRunRate of the given team.
     *
     * @return the netRunRate of the given team.
     */

    public double getNetRunRate() {
        return netRunRate;
    }

    /**
     * Assigns the netRunRate of the given team.
     *
     * @param netRunRate net run rate of the given team.
     */

    public void setNetRunRate(double netRunRate) {
        this.netRunRate = netRunRate;
    }

    /**
     * Returns the points scored by the given team.
     *
     * @return the points scored by the given team.
     */

    public int getPoints() {
        return points;
    }


    /**
     * Assigns the points scored by the given team.
     *
     * @param points points scored by the given team.
     */

    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * Returns flag of the team.
     *
     * @return the flag to the given team.
     */

    public String getFlag() {
        return flag;
    }


    /**
     * Assigns the flag to the team.
     *
     * @param flag the flag to the given team.
     */

    public void setFlag(String flag) {
        this.flag = flag;
    }

    /**
     * Returns group of the team.
     *
     * @return the group of the given team.
     */

    public String getGroup() {
        return group;
    }


    /**
     * Assigns the group to the team.
     *
     * @param group the group to the given team.
     */

    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * Parameterized contructor initializing the following
     *
     * @param teamID the teamID of the team
     * @param teamName the teamName of the team
     * @param gamesPlayed gamesPlayed by the team
     * @param gamesWon gamesWon by the team
     * @param gamesLost gamesLost by the team
     * @param netRunRate netRunRate of the team
     * @param points points scored by the team
     */
    public Team(String teamID, String teamName, int gamesPlayed, int gamesWon, int gamesLost, double netRunRate, int points) {
        this.teamID = teamID;
        this.teamName = teamName;
        this.gamesPlayed = gamesPlayed;
        this.gamesWon = gamesWon;
        this.gamesLost = gamesLost;
        this.netRunRate = netRunRate;
        this.points = points;
        this.flag="";
        this.group="";
    }

    /**
     * Copy constructor to copy the values from another team
     *
     * @param T the Team to be copied
     * @param teamID the teamID to be copied
     *
     */

    public Team(Team T,String teamID)
    {
        this.teamID = teamID;
        this.teamName = T.teamName;
        this.gamesPlayed = T.gamesPlayed;
        this.gamesWon = T.gamesWon;
        this.gamesLost = T.gamesLost;
        this.netRunRate = T.netRunRate;
        this.points = T.points;
        this.flag=T.flag;
        this.group=T.group;
    }
    /**
     * A clone() method to make a deep copy of the Team object
     *
     * @return a new Team aboject with the same attributes values
     * ask the user for the teamID of the new Team
     */

    public Team clone()
    {
        System.out.println("Enter the teamID of the Team object you wanna clone:");
        Scanner sc = new Scanner(System.in);
        String teamID1 = sc.nextLine();
//        sc.close();
        Team T = new Team(this, teamID1);
        return T;
    }
    /**
     * Returns the details of the Team.
     *
     * @return the details of the Team.
     */
    public String toString() {
        return "Team ID: " + teamID + "\tTeam Name: " + teamName + "\tGames Played: " + gamesPlayed+"\tGames Won: " + gamesWon+"\tGames Lost: " + gamesLost+"\tNet Run Rate: " + netRunRate+"\tPoints: " + points;
    }

    /**
     * checks if two Teams are equal except for teamID
     *
     * @param T the Team to be compared.
     * @return true if the Teams are equal, false otherwise.
     * two Teams are equal if all attributes are same except teamID.
     */
    public boolean equals(Team T) {
        if (this.teamName.equals(T.getTeamName()) && this.gamesWon == T.getGamesWon() && this.gamesLost == T.getGamesLost()&& this.gamesPlayed == T.getGamesPlayed()&& this.netRunRate == T.getNetRunRate()&& this.points == T.getPoints()) {
            return true;
        }
        return false;
    }

    /**
     * Checks if two teams are in the same group.
     *
     * @param T the Teams to be compared.
     * @return
     */
    public boolean isInTheGroup(Team T) {
    //    if (this.teamName ==
        if(TournamentResults.groupA.contains(T.getTeamID()) && TournamentResults.groupA.contains(this.getTeamID())) {
            return true;
        }
        else if(TournamentResults.groupB.contains(T.getTeamID()) && TournamentResults.groupB.contains(this.getTeamID())) {
            return true;
        }
        return false;
    }
}

