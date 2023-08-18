package Assignment.Assignment3.Submission;// ______________
// Assignment 3
// � Mukesh Kumar Angrish
// Written by: Mukesh Kumar Angrish (Student ID - 40203596)
// ______________

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class is used to process the TV Guide and Interest file and shows if a user has conflicts between the shows they are watching and want to watch.
 */
public class ProcessWishlist {
    /**
     * This method is used to process the TV Guide file and shows if a user has conflicts between the shows they are watching and want to watch.
     *
     * @param args - the command line arguments (not used)
     */
    public static void main(String[] args) {
        // create two empty ShowList objects
        ShowList showList1 = new ShowList();
        ShowList showList2 = new ShowList();
        ArrayList<TVShow> watching = new ArrayList<TVShow>();
        ArrayList<TVShow> wishlist = new ArrayList<TVShow>();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the file path for TV Guide(default: TVGuide.txt): ");
        String TVGuideFilePath = input.nextLine();
        // if TVGuideFilePath is empty, use default file path
        if (TVGuideFilePath.equals("")) {
            TVGuideFilePath = "TVGuide.txt";
        }
        System.out.print("Enter the file path for Interest(default: Interest.txt): ");
        String InterestFilePath = input.nextLine();
        // if InterestFilePath is empty, use default file path
        if (InterestFilePath.equals("")) {
            InterestFilePath = "Interest.txt";
        }
        input.close();

        // check if file path is valid by using File objects
        File TVGuideFile = new File(TVGuideFilePath);
        File InterestFile = new File(InterestFilePath);

        if (TVGuideFile.exists() && TVGuideFile.isFile() && TVGuideFile.canRead() && InterestFile.exists() && InterestFile.isFile() && InterestFile.canRead()) {
            // if file path is valid, read the file and store the information in ShowList objects
            try {
                System.out.println("Reading TV Guide file...");
                // create buffered reader to read the file
                BufferedReader br = new BufferedReader(new FileReader(TVGuideFile));
                // the file has following structure repeated for each show:
                // showID showName
                // S startTime
                // E endTime
                // \n
                // loop through the file line by line until the end of the file
                String line = br.readLine();
                while (line != null) {
                    if (line.equals("")) {
                        line = br.readLine();
                        continue;
                    }
                    String[] showInfo = line.trim().split(" ");
                    String showID = showInfo[0];
                    String showName = showInfo[1];
                    // read the next line to get the start time
                    line = br.readLine();
                    double startTime = Double.parseDouble(line.trim().split(" ")[1]);
                    // read the next line to get the end time
                    line = br.readLine();
                    double endTime = Double.parseDouble(line.trim().split(" ")[1]);
                    // create a new TVShow object with the information
                    TVShow show = new TVShow(showID, showName, startTime, endTime);
                    // check if the show is in the showList1, if not, add it to showList1
                    if (!showList1.contains(showID)) {
                        showList1.addToStart(show);
                    }
                    // read the next line to get the next show information
                    line = br.readLine();
                }

                // close the buffered reader
                br.close();
                // print the contents of the showList1 object to the console
//				System.out.println("\nThe contents of the showList1 object are: ");
//				System.out.println(showList1);
//				System.out.println("\nThe contents of the showList2 object are: ");
//				System.out.println(showList2);
            } catch (FileNotFoundException e) {
                System.out.println("TV Guide file not valid.");
                System.exit(0);
            } catch (IOException e) {
                System.out.println("Something went wrong while reading the TV Guide file");
                System.exit(0);
            }
            // if file path is valid, read the file and store the information in watching and wishlist ArrayLists respectively
            try {
                System.out.println("Reading Interest file...");
                // create buffered reader to read the file
                BufferedReader br = new BufferedReader(new FileReader(InterestFile));
                // the file has following structure repeated for each show:
                // Watching
                // n lines with showID
                // Wishlist
                // k lines with showID
                String line = br.readLine();
                ArrayList<TVShow> current = new ArrayList<TVShow>();
                while (line != null) {
                    if (line.toLowerCase().equals("watching")) {
                        current = watching;
                    } else if (line.toLowerCase().equals("wishlist")) {
                        current = wishlist;
                    } else {
                        if (line.equals("")) {
                            line = br.readLine();
                            continue;
                        }
                        if (showList1.contains(line.trim())) {
                            // #PRIVACY_COMMENT: needed to make ShowList.ShowNode class visible to use the find method
                            current.add(showList1.find(line.trim()).getShow());
                        }
                    }
                    line = br.readLine();
                }
                // close the buffered reader
                br.close();
                // print the contents of the watching and wishlist ArrayLists to the console
//				System.out.println("\nThe contents of the watching ArrayList are: ");
//				System.out.println(watching);
//				System.out.println("\nThe contents of the wishlist ArrayList are: ");
//				System.out.println(wishlist);

            } catch (FileNotFoundException e) {
                System.out.println("Interest file not valid.");
                System.exit(0);
            } catch (IOException e) {
                System.out.println("Something went wrong while reading the Interest file");
                System.exit(0);
            }
        } else {
            // if file path is invalid, print error message to the console
            System.out.println("File paths are invalid.");
            System.exit(0);
        }
        System.out.println("Processing files...");
        // loop over all the showIDs in wishlist ArrayList
        // for each showID, loop over all the showIDs in watching ArrayList
        // fetch the TVShow object for both showIDs and check call the isOnSameTime() method
        for (TVShow willBeWatching : wishlist) {
            String outcome = "User can watch show " + willBeWatching.getShowID() + " as he/she/they are not watching anything else during that time";
            boolean isConflict = false;
            ArrayList<String> conflicts = new ArrayList<String>();
            for (TVShow alreadyWatching : watching) {
                String isOnSameTime = willBeWatching.isOnSameTime(alreadyWatching);
                if (!isOnSameTime.equals("Different time")) {
                    if (isOnSameTime.equals("Same time")) {
                        isConflict = true;
                        if (!conflicts.contains(isOnSameTime)) {
                            conflicts.add(isOnSameTime);
                            System.out.println("User can't watch show " + willBeWatching.getShowID() + " as he/she will begin another show at the same time.");
//							System.out.println(alreadyWatching.getShowID() + "\t" + willBeWatching.getShowID());
                        }
                    }
                    if (isOnSameTime.equals("Some Overlap")) {
                        isConflict = true;
                        if (!conflicts.contains(isOnSameTime)) {
                            conflicts.add(isOnSameTime);
                            System.out.println("User can't watch show " + willBeWatching.getShowID() + " as he/she is not finished with a show he/she is watching.");
//							System.out.println(alreadyWatching.getShowID() + "\t" + willBeWatching.getShowID());
                        }
                    }
                }
            }
            if (!isConflict)
                System.out.println("User can watch show " + willBeWatching.getShowID() + " as he/she is not watching anything else during that time.");
        }
    }
}
