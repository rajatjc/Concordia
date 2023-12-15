package Assignment.Assignnment1;
//
// Assignment 1
// © Rajat Sharma
// Written by: Rajat Sharma(ID- 40196467)
//

//        in this following program I have tracked the voter information in a software application that helps the staff
//        (users) in keeping track of the Voters in every neighborhood.

//the voter class has a number of getter setter methods to set and get value of the variables of the class


import java.util.Scanner;

/**
 * a Voter class containing the voterID voterName voterAge voterEmail voterPCode
 * @author Rajat Sharma
 * */
public class Voter {



    private final long voterID;
    private String voterName;
    private byte voterAge;
    private String voterEmail;
    private char[] voterPCode;

    private static int numberOfVoters = 0;


    /**
     * default constructor which is called when an object of Voter class is created
     * @author Rajat Sharma*/
    public Voter() {
        // initialize default values
        voterID=10;

        setVoterName("John Doe");

        setVoterAge((byte) 18);

        setVoterEmail("abc@gmail.com");

        char[] temp = {'H','2','T','1','X','2'};

        setVoterPCode(temp);

        numberOfVoters++;
    }


    /**
     *         parameterized constructor called with parameters of the Voter class object
     *         @param voterEmail email of voter
     *         @param voterName Name of voter
     *         @param voterAge age of voter
     *         @param voterPCode Postal code of voter
    */
    public Voter(long voterID, String voterName,byte voterAge, String voterEmail, char[] voterPCode){
        numberOfVoters++;
        this.voterID=voterID;
        setVoterEmail(voterEmail);
        setVoterName(voterName);
        setVoterPCode(voterPCode);
        setVoterAge(voterAge);
    }
    /**
     * return the voter ID of the voter
     * @return the voter ID of the voter
    */
    public long getVoterID() {
        return voterID;
    }
    /**
     * return the voter name of the voter
     * @return the voter name of the voter
    */
    public String getVoterName() {
        return voterName;
    }

    /**
     * set the voter name of the voter
     * @param voterName voter name of the voter
    */
    public void setVoterName(String voterName) {
        this.voterName = voterName;
    }

    /**
     * return the voter age of the voter
     * @return the voter age of the voter
     *
    */
    public byte getVoterAge() {
        return voterAge;
    }

    /**
     * set the voter age of the voter
     * @param voterAge voter age of the voter
    */
    public void setVoterAge(byte voterAge) {
        this.voterAge = voterAge;
    }

    /**
     * return the voter email of the voter
     * @return the voter email of the voter
    */
    public String getVoterEmail() {
        return voterEmail;
    }

     /**
      * set the voter email of the voter
      * @param voterEmail voter email of the voter
    */

    public void setVoterEmail(String voterEmail) {
        this.voterEmail = voterEmail;
    }


     /**
      * return the voter PCode of the voter
      * @return the voter PCode of the voter
    */

    public char[] getVoterPCode() {
        return voterPCode;
    }

    /**
     * set the voter PCode of the voter
     * @param voterPCode voter PCode of the voter
    */

    public void setVoterPCode(char[] voterPCode) {
        this.voterPCode = voterPCode;
    }


    /**
     * return a Voter object as string
     * @return a Voter object as string
     * */
    @Override
    public String toString() {
        return
                "ID: "+getVoterID()+"\n" +
                "Name: "+getVoterName()+"\n" +
                "Age: "+getVoterAge()+"\n" +
                "Email: "+getVoterEmail()+"\n" +
                "PCode: "+String.copyValueOf(getVoterPCode())+"\n";
    }
    /**
     * return a voter object with Voter and index as a parameter
     * @return a voter object with Voter and index as a parameter
     * */
    public static String displayVoter(Voter v, int index)
    {
        String temp="\nVoter: # "+index+"\n" +
                "ID: "+v.getVoterID()+"\n" +
                "Name: "+v.getVoterName()+"\n" +
                "Age: "+v.getVoterAge()+"\n" +
                "Email: "+v.getVoterEmail()+"\n" +
                "PCode: "+String.copyValueOf(v.getVoterPCode())+"\n";
        return temp;
    }

    /**
     * return the current number of voters
     * @return the current number of voters
     * */
    public static int findNumberOfCreatedVoters(){return numberOfVoters;}



    /**
     * equates two voter objects depending on ID and PCode
     * @param temp The voter object we want to compare
     * @return true if both the voter object have same ID and same PCode
     * */

    public boolean equals(Voter temp)
    {
        if(this.getVoterID()==temp.getVoterID()&&this.getVoterPCode().equals(temp.getVoterPCode()))
            return true;
        else
            return false;

    }

    /**
     * Main method of the voter class has many functions inculcated in the
     * switch case, and they are as follows:
     * 1. Enter new voters (password required)
     * 2. Change information of a voter (password required)
     * 3. Display all voters by a specific voterPcode
     * 4. Display all voters under a certain age.
     * 5. Quit
     * @author Rajat Sharma
     * */

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        //welcome message
        System.out.print("Welcome to the Parti Québécois Voter tracker application.\n\n");
        System.out.print("Enter the maximum number of voters in your neighbourhood : ");


        int voterSize;
        if(sc.hasNextInt())
        {
            while(true)
            {
                voterSize=sc.nextInt();
                if(voterSize<0)
                {
                    System.out.println("Enter a positive number of voters.");
                }
                else
                {
                    break;
                }
            }

            //potential
            //of keeping track of all the created Voter objects
            Voter[] voterBase=new Voter[voterSize];
            int passAttemps=0;
            int wrongPass=0;


            while(true) {
                //Main menu with all the functionalities
                System.out.println("====================MAIN MENU=======================");
                    System.out.print("What do you want to do? \n" +
                            "1. Enter new voters (password required) \n" +
                            "2. Change information of a voter (password required) \n" +
                            "3. Display all voters by a specific voterPcode \n" +
                            "4. Display all voters under a certain age. \n" +
                            "5. Quit \n" +
                            "Please enter your choice > ");
                    int option = sc.nextInt();
                    if (option > 0 && option < 6) {

                        //storing the password in a variable called the password
                        String password = "password";
                        OUTER:
                        switch (option) {
                            case 1:
                                while (true) {
                                    System.out.println("Enter password: ");
                                    String userPassword = sc.next();
                                    if (userPassword.equals(password)) {
                                        passAttemps=0;

                                        System.out.print("How many Voters do you want to enter: ");
                                        int newUsers=sc.nextInt();
                                        if(newUsers>voterSize-Voter.findNumberOfCreatedVoters()) {
                                            int remainingVoters=voterSize-Voter.findNumberOfCreatedVoters();
                                            System.out.print("You can only add "+remainingVoters+" voters");
                                            break;
                                        }
                                        else
                                        {
                                            int index=Voter.findNumberOfCreatedVoters();
                                            for(int i=index;i<index+newUsers;i++)
                                            {
                                                System.out.println("Enter the details of voter "+i+" in the following format \",\" separated (ID, Name, Age, Email, PCode)");
                                                String[] input=sc.next().split(",");
                                                voterBase[i]=new Voter(Long.parseLong(input[0]),input[1],Byte.parseByte(input[2]),input[3],input[4].toCharArray());
                                               // System.out.println(voterBase[index].toString());
                                            }
                                            break OUTER;
                                        }
                                    } else {
                                        passAttemps++;
                                        if (passAttemps == 12) {
                                            System.out.println("Program detected suspicious activities and will terminate immediately!");
                                            System.exit(0);
                                        }
                                        else if (passAttemps == 3 || passAttemps == 6 || passAttemps == 9) {
                                            System.out.println("You have entered the incorrect password for the " + passAttemps + " times and are being redirected to the main menu");
                                            break OUTER;
                                        }
                                        else
                                        {
                                            System.out.println("The password is incorrect please enter the correct password.");
                                            continue;
                                        }
                                    }
                                }
                                break;


                                //case 2 for the updation of voter on the basis of ID
                            case 2:
                                while(true)
                                {
                                    System.out.println("Enter password: ");
                                    String userPassword = sc.next();
                                    if (userPassword.equals(password)) {
                                        wrongPass=0;
                                        System.out.println("Enter the voterID of the voter you want to update");
                                        int updateVoterID= Integer.parseInt(sc.next());
                                        int flag=0;
                                        int found=0;
                                        for(int i=0;i<Voter.findNumberOfCreatedVoters();i++)
                                        {
                                            if(updateVoterID==voterBase[i].getVoterID())
                                            {
                                                flag=1;
                                                found=i;
                                            }
                                        }
                                        if(flag==1) {
                                            while(true)
                                            {
                                                System.out.println(displayVoter(voterBase[found],found));
                                                System.out.println("Which of the following attribute do you need to change");
                                                System.out.println("What information would you like to change?\n" +
                                                        "1. Name\n" +
                                                        "2. Age\n" +
                                                        "3. Email\n" +
                                                        "4. PCode\n" +
                                                        "5. Quit\n" +
                                                        "Enter your choice >");
                                                int updateChoice=sc.nextInt();
                                                switch (updateChoice)
                                                {
                                                    case 1:
                                                        System.out.println("Enter the updated name of the voter");
                                                        voterBase[found].setVoterName(sc.next());
                                                        break;
                                                    case 2:
                                                        System.out.println("Enter the updated age of the voter");
                                                        voterBase[found].setVoterAge(Byte.parseByte(sc.next()));
                                                        break;
                                                    case 3:
                                                        System.out.println("Enter the updated Email of the voter");
                                                        voterBase[found].setVoterEmail(sc.next());
                                                        break;
                                                    case 4:
                                                        System.out.println("Enter the updated PCode of the voter");
                                                        voterBase[found].setVoterPCode(sc.next().toCharArray());
                                                        break;
                                                    case 5:
                                                        break OUTER;
                                                    default:
                                                        System.out.println("Please enter a number between 1-5 inclusive");
                                                }
                                            }
                                        }
                                        else
                                        {
                                            System.out.println("There is no voter with the specified voterID");
                                            System.out.println("Do you want to re enter another voter(press 1)or quit this operation and go back?(press any other key)");

                                            String choice=sc.next();
                                            if(choice.equals("1"))
                                            {
                                                int currVoters=Voter.findNumberOfCreatedVoters();
                                                System.out.println("Enter the details of voter "+currVoters+" in the following format \",\" separated (ID, Name, Age, Email, PCode)");
                                                String[] input=sc.next().split(",");
                                                voterBase[currVoters]=new Voter(Long.parseLong(input[0]),input[1],Byte.parseByte(input[2]),input[3],input[4].toCharArray());
                                            }
                                            else
                                            {
                                                break OUTER;
                                            }
                                        }

                                    }
                                    else
                                    {
                                        wrongPass++;
                                        if(wrongPass==3)
                                        {
                                            break OUTER;
                                        }
                                        else
                                        {
                                            System.out.println("The password is incorrect please enter the correct password.");
                                            continue;
                                        }
                                    }
                                }
                              //  break;

                            case 3:
                                System.out.println("Enter the PCode of the voter");
                                String pCode=sc.next();

                                for(int i=0;i<Voter.findNumberOfCreatedVoters();i++)
                                {
                                    if(pCode.equalsIgnoreCase(String.valueOf(voterBase[i].getVoterPCode())))
                                    {
                                        System.out.println(displayVoter(voterBase[i],i));
                                    }
                                }
                                break;


                            case 4:
                                System.out.println("Enter the age of the voter");
                                int findAge= Integer.parseInt(sc.next());
                                for(int i=0;i<Voter.findNumberOfCreatedVoters();i++)
                                {
                                    if(findAge>voterBase[i].getVoterAge())
                                    {
                                        System.out.println(displayVoter(voterBase[i],i));
                                    }
                                }
                                break;


                            case 5:
                                System.out.print("Thank you for using Parti Québécois Voter tracker application.\n");
                                System.exit(0);
                                break;

                            default:
                        }
                    } else {
                        System.out.println("Please enter a number between 1 and 5 inclusive.");
                    }

                }


        }

    }
}

