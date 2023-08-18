package Assignment.Assignment2;

// ______________
// Assignment 2
// Rajat Sharma
// Written by: Rajat Sharma (Student ID - 40196467)
// ______________


import java.util.ArrayList;
import java.util.Scanner;

public class TournamentResults {

    public static  TeamList groupA ;
    public static  TeamList groupB ;

    public static void main(String[] args) {
        //creating two empty TeamList

        groupA = new TeamList();
        groupB = new TeamList();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the team format in this space separated order 'teamID teamname gamesplayed gameswon gameslost runrate points' \nAlso write the keyword 'done' in a separate line after you're done with team input");
        int flag = 0;
        while (sc.hasNextLine()) {
            String[] s = sc.nextLine().split(" ");
            if (s.length == 1) {
                if (s[0].length() == 0)
                    continue;
                else break;
            }
            if (s.length == 2) {
                if (s[1].equals("A") || s[1].equals("a"))

                    flag = 1;
                else
                    flag = 2;
            }
            if (s.length == 7) {

                Team newEntry = new Team(s[0], s[1].toUpperCase(), Integer.parseInt(s[2]), Integer.parseInt(s[3]), Integer.parseInt(s[4]), Double.parseDouble(s[5]), Integer.parseInt(s[6]));

                if (flag == 1) {
                    if (!groupA.contains(s[0])) {
                        newEntry.setGroup("A");
                        groupA.addToStart(newEntry);
                    }
                } else {
                    if (!groupB.contains(s[0])) {
                        newEntry.setGroup("B");
                        groupB.addToStart(newEntry);
                    }
                }
            }
        }


        groupA.mergeSortHelp();
        groupB.mergeSortHelp();
        groupA.assignFlag();
        groupB.assignFlag();

        System.out.println(groupA.toString());
        System.out.println(groupB.toString());


        ArrayList<String> queries = new ArrayList<>();


        System.out.println("Query: Enter the teams in the querylist separate line (write 'done' after you're done with input)\n");

        while (true) {
            String ans = sc.nextLine();
            if (ans.toLowerCase().equals("done"))
                break;
            queries.add(ans);
        }

        for (String query : queries) {
            groupA.findQueryAnswer(query.toUpperCase());
            groupB.findQueryAnswer(query.toUpperCase());
        }

        System.out.println("\nEnter a few teamIDs in separate lines to be searched write 'done' after you're done with the  input.\n");

        while (sc.hasNextLine()) {
            String teamIDquery = sc.nextLine();
            if (teamIDquery.toLowerCase().equals("done"))
                break;
            else
                groupA.find(teamIDquery.toUpperCase());
            groupB.find(teamIDquery.toUpperCase());
        }

        System.out.println("To test the TeamList class functions:");
        String input = "";
        do {
            System.out.println("===============================MENU====================================");
            System.out.println("1.) Insert the team at a particular index in a particular Group\n" +
                    "Format(teamID teamname gamesplayed gameswon gameslost runrate points)\n" +
                    "\n" +
                    "2.)Delete from index , enter the specific index you want to delete from.\n" +
                    "\n" +
                    "3.)Delete from Start, use this function to delete from the start of a particular group.\n" +
                    "\n" +
                    "4.)Replace at index at a particular index in a particular Group\n" +
                    "Format(teamID teamname gamesplayed gameswon gameslost runrate points)\n" +
                    "\n" +
                    "5.)Enter two teamID to check if in the same group.\n" +
                    "\n" +
                    "6.)Enter the group (A/B) you want to clone adn then enter new teamID for each object.\n" +
                    "\n" +
                    "7.)Enter the keyword 'done' if you want to close the menu.\n" );
            System.out.print(">>>>");
            input = sc.nextLine();
            switch (input) {
                case "1":
                    String[] s = sc.nextLine().split(" ");
                    Team newEntry = new Team(s[0], s[1].toUpperCase(), Integer.parseInt(s[2]), Integer.parseInt(s[3]), Integer.parseInt(s[4]), Double.parseDouble(s[5]), Integer.parseInt(s[6]));

                    System.out.println("Enter the group and index(space separated) you want to insert");
                    String[] case1 = sc.nextLine().split(" ");

                    if (case1[0].equals("A") || case1[0].equals("a"))
                        flag = 1;
                    else
                        flag = 2;
                    if (flag == 1) {
                        if (!groupA.contains(s[0])) {
                            newEntry.setGroup("A");
                            groupA.insertAtIndex(newEntry, Integer.parseInt(case1[1]));
                        }
                    } else {
                        if (!groupB.contains(s[0])) {
                            newEntry.setGroup("B");
                            groupB.insertAtIndex(newEntry, Integer.parseInt(case1[1]));
                        }
                    }
                    if (flag == 1)
                        System.out.println(groupA.toString());
                    else
                        System.out.println(groupB.toString());

                    break;

                case "2":
                    System.out.println("Enter the group and index(space separated) you want to delete from");
                    String[] case2 = sc.nextLine().split(" ");
                    if (case2[0].equals("A") || case2[0].equals("a"))
                        flag = 1;
                    else
                        flag = 2;
                    if (flag == 1) {

                        groupA.deleteFromIndex(Integer.parseInt(case2[1]));

                    } else {
                        groupB.deleteFromIndex(Integer.parseInt(case2[1]));
                    }
                    if (flag == 1)
                        System.out.println(groupA.toString());
                    else
                        System.out.println(groupB.toString());


                    break;

                case "3":

                    System.out.println("Enter the group you want to delete from the start");
                    String[] case3 = sc.nextLine().split(" ");
                    if (case3[0].equals("A") || case3[0].equals("a"))
                        flag = 1;
                    else
                        flag = 2;
                    if (flag == 1) {

                        groupA.deleteFromStart();

                    } else {
                        groupB.deleteFromStart();
                    }
                    if (flag == 1)
                        System.out.println(groupA.toString());
                    else
                        System.out.println(groupB.toString());


                    break;

                case "4":
                    s = sc.nextLine().split(" ");

                    newEntry = new Team(s[0], s[1].toUpperCase(), Integer.parseInt(s[2]), Integer.parseInt(s[3]), Integer.parseInt(s[4]), Double.parseDouble(s[5]), Integer.parseInt(s[6]));

                    System.out.println("Enter the group and index(space separated) you want to replace");
                    String[] case4 = sc.nextLine().split(" ");

                    if (case4[0].equals("A") || case4[0].equals("a"))
                        flag = 1;
                    else
                        flag = 2;
                    if (flag == 1) {
                        if (!groupA.contains(s[0])) {
                            newEntry.setGroup("A");
                            groupA.replaceAtIndex(newEntry, Integer.parseInt(case4[1]));
                        }
                    } else {
                        if (!groupB.contains(s[0])) {
                            newEntry.setGroup("B");
                            groupB.replaceAtIndex(newEntry, Integer.parseInt(case4[1]));
                        }
                    }
                    if (flag == 1)
                        System.out.println(groupA.toString());
                    else
                        System.out.println(groupB.toString());


                    break;

                case "5":
                    System.out.println("Enter the teamID you want to find if in the same group");
                     s = sc.nextLine().split(" ");
                    Team team1=groupA.returnTeam(s[0]);
                    if(team1==null)
                        team1=groupB.returnTeam(s[0]);
                    Team team2=groupA.returnTeam(s[1]);
                    if(team2==null)
                        team2=groupB.returnTeam(s[1]);

                    if(team1.isInTheGroup(team2))
                        System.out.println("Both teams are in the same group");
                    else
                        System.out.println("Both teams are in different group");
                    break;

                case "6":
                    System.out.println("Enter the group you want to clone()");
                    String tempGroup=sc.nextLine();
                    TeamList newList;
                    if (tempGroup.equals("A") || tempGroup.equals("a"))
                        flag = 1;
                    else
                        flag = 2;
                    if (flag == 1) {
                        newList= new TeamList(groupA);
                    } else {
                        newList= new TeamList(groupB);
                    }

                        System.out.println(newList.toString());

                    break;
                case "done":
                    break;

                default:
                    System.out.println("Enter a correct input or write 'done' if  you want to close the menu.");
            }

        } while (!input.equals("done"));


        System.out.println("\n\nThank you for using the program.");
    }
}
