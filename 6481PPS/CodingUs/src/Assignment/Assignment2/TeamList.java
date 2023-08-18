package Assignment.Assignment2;

import Assignment.Assignment3.Submission.ShowList;

import java.util.HashMap;
import java.util.NoSuchElementException;

// ______________
// Assignment 2
// Rajat Sharma
// Written by: Rajat Sharma (Student ID - 40196467)
// ______________
public class TeamList {
    /**
     * Inner class named TeamNode
     */

    public class TeamNode {
        private Team team;
        private TeamNode nextNode;

        /**
         * Returns the team in TeamNode
         *
         * @return the team in TeamNode
         */

        public Team getTeam() {
            return team;
        }

        /**
         * To modify the team in TeamNode class
         *
         * @param team the team to be assigned
         */

        public void setTeam(Team team) {
            this.team = team;
        }

        /**
         * Returns the next node in TeamNode
         *
         * @return the next node in TeamNode
         */

        public TeamNode getNextNode() {
            return nextNode;
        }


        /**
         * To modify the next node in TeamNode class
         *
         * @param nextNode the next node to be assigned
         */

        public void setNextNode(TeamNode nextNode) {
            this.nextNode = nextNode;
        }

        /**
         * Constructor which is assigning both team and next node to null
         */
        public TeamNode() {
            this.team = null;
            this.nextNode = null;
        }

        /**
         * Parameterized constructor to initialize a Team object and
         * TeamNode object accordingly
         */

        public TeamNode(Team team, TeamNode node) {
            this.team = team;
            this.nextNode = node;
        }

        /**
         * Copy constructor to initialize a TeamNode object from another TeamNode object
         *
         * @param teamNode the teamNode object to be copied
         * @param node     the next node
         */

        public TeamNode(TeamNode teamNode, TeamNode node) {
            this.team = teamNode.team;
            this.nextNode = node;
        }

        /**
         * clone() method to clone a TeamNode object and make a deep copy of it
         *
         * @return a deep copy of the TeamNode object
         */

        public TeamNode clone() {
            return new TeamNode(this.team.clone(), this.nextNode);
        }

        /**
         * Returns a string representation of the  teamNode.
         *
         * @return a string representation of the teamNode
         */

        public String toString() {
            return this.team.toString();
        }
    }

    /**
     * points to the first node in the TeamList
     */
    private TeamNode head;

    /**
     * always indicates the current size of the list
     * (how many nodes are in the list).
     */
    private int size;

    /**
     * default constructor to create an empty list
     */

    public TeamList()
    {
        this.head=null;
        this.size=0;
    }

    /**
     * Copy constructor which accepts a TeamList object
     * and creates a copy for it
     *
     * @param T the list of Teams
     */

    public TeamList(TeamList T)
    {
        //base case check for null head
        if(T.head==null)
            this.head=null;

        //create a deep copy of all the nodes by iterating over them
        else {

            //Team LtempNode=T.head.getTeam().clone();

            //create the clone of the head
            TeamNode tempNode=T.head.clone();
            //tempNode.setTeam(LtempNode);
            this.head=tempNode;

            //iterate over teh whole list to create a deepcopy of every node in the list
            for(TeamNode itrNode = T.head.getNextNode(); itrNode !=null; itrNode=itrNode.getNextNode()){
                tempNode.setNextNode((itrNode.clone()));
                tempNode=tempNode.getNextNode();

            }
            //set the last node of the list to null
            tempNode.setNextNode(null);
        }

        //set the size of the cloned list to the size of the original list
        this.size=T.size;

    }

    /**
     * accepts one parameter, an object from Team
     * class, creates a node with that passed object, and inserts this node at the head of
     * the list.
     *
     * @param T the team to be added
     */

    public void addToStart(Team T) {


        TeamNode node=new TeamNode(T,head);

        //set the head of the list object to the new TeamNode object
        this.head=node;
        //increase the size of the TeamList
        this.size++;
    }

    /**
     * A method called insertAtIndex(), which accepts two parameters, an object from the
     * Team class, and an integer representing an index. If the index is not valid (a valid
     * index must have a value between zero and size-1), then the method must throw a
     * NoSuchElementException and terminates the program. If index is valid, then the
     * method creates a node with passed Team object and inserts this node at the given
     * index. The method must properly handle all special cases.
     *
     * @param T the Team to be added in the list
     * @param index the position at which the team should be added
     * @throws NoSuchElementException if index is out of bounds
     */

    public void insertAtIndex(Team T,int index) throws NoSuchElementException
    {
        //if index is out of bounds of array size throw exception
        if(index<0 || index >this.size)
        {
            throw new NoSuchElementException();
        }
        // if index is 0 then we need to add the element to the start of the List
        if(index==0){
            this.addToStart(T);
        }

        //if index value is not 0 then iterate the list and find the position
        // the node needs to be inserted at and create the pointer chain as follows
        else {
            int next = 1;
            for (TeamList.TeamNode itr = this.head; itr != null; itr = itr.getNextNode()) {
                if (index == next) {
                    TeamList.TeamNode newNode = new TeamList.TeamNode(T, itr.getNextNode());
                    itr.setNextNode(newNode);
                }
                next++;
            }
        }

    }

    /**
     * A method called deleteFromIndex(), which accepts one int parameter representing
     * an index. If index is not valid, method must throw a NoSuchElementException
     * and terminate the program. Otherwise, node pointed by that index is deleted from
     * the list. The method must properly handle all special cases.
     *
     * @param index the index of the element to be removed
     * @throws NoSuchElementException if the index to be deleted is out of range
     */

    public void deleteFromIndex(int index) throws NoSuchElementException{
        //if index is out of bounds throw error
        if(index<0 || index>=this.size)
        {
            throw new NoSuchElementException();
        }
        if(index==0)
        {
            this.head=this.head.getNextNode();
        }
        else{
            int next=1;
            for(TeamNode itr=this.head;itr!=null;itr=itr.getNextNode()){
                if(index==next)
                {
                    itr.setNextNode(itr.getNextNode().getNextNode());
                }
                next++;
            }
        }
        //decreasing the size of list
        this.size--;
    }

    /**
     * A method called deleteFromStart(), which deletes the first node in the list (the one
     * pointed by head). All special cases must be properly handled.
     *
     * @throws NoSuchElementException if first element of the list is null
     *
     * */

    public void deleteFromStart() throws NoSuchElementException{

        //if head is null that means list is empty so throw an error
        if(this.head==null)
        {
            throw new NoSuchElementException();
        }
        //set the head pointer to the next value
        else{
            this.head=this.head.getNextNode();
        }
        //decrease the size of list
        size--;
    }

    /**
     * A method called replaceAtIndex(), which accepts two parameters, an object from
     * Team class, and an integer representing an index. If index is not valid, the method
     * simply returns; otherwise, object in list at passed index must be replaced with the
     * object passed.
     *
     * @param T the Team to be replaced
     * @param index the position in the list where the new Team is to be replaced*/

    public void replaceAtIndex(Team T,int index)
    {
        //if index is out of bounds then simply return
        if(index<0|| index>=this.size)
        {
            return;
        }
        //if index is 0 replace the team at the head node
        if(index==0)
        {
            this.head.setTeam(T);
        }

        else{


            int next=1;
            //iterate over the list
            for(TeamNode itr=this.head;itr!=null;itr=itr.getNextNode()){

                //if the index is found just replace the team using the setTeam() method
                if(index==next)
                {
                    itr.setTeam(T);
                }
                //increment the next variable
                next++;
            }
        }
    }

    /**
     * A method called find(), which accepts one parameter of type String representing a
     * teamID. Method then searches the list for a teamNode with that teamID. If such
     * an object is found, then method returns a pointer to that teamNode; otherwise,
     * method returns null. The method must keep track of how many iterations were
     * made before the search finally finds the team or concludes that it is not in the list.
     *
     * @param teamID the ID of the team to be returned
     * @return the node in the list with the given teamID and null  if not found
     *
     *This method can cause privacy leaks
     */

    public TeamNode find(String teamID)
    {
        int next=1;
        //iterate over the whole list and from TeamNode with the given teamID
        for(TeamNode itr=this.head;itr!=null;itr=itr.getNextNode())
        {
            if(itr.getTeam().getTeamID().equals(teamID)){
                System.out.println("teamID "+teamID+" found after "+next+" iterations in group "+itr.getTeam().getGroup());
                return itr;
            }
            next++;
        }
        //if itr is not found return null.
        return null;
    }

    /**
     * A method called contains (), which accepts a parameter of type String representing
     * a teamID. Method returns true if a team with that teamID is in the list; otherwise,
     * the method returns false.
     *
     * @param teamID the ID of the team to be checked
     * @return true if a team with that teamID is in the list;
     */

    public boolean contains(String teamID)
    {
        //iterate over the whole list to find TeamNode with given teamID
        for(TeamNode itr=this.head;itr!=null;itr=itr.getNextNode())
        {
            if(itr.getTeam().getTeamID().equals(teamID))
            {
                return true;
            }
        }
        //if the given teamId is not found in the list
        return false;
    }

    /**
     * A method called equals (), which accepts one parameter of type TeamList. Method
     * returns true if the two lists contain similar teams; otherwise, the method returns
     * false. Recall that two Team objects are equal if they have the same values except
     * for the teamID, which can, and is expected to be, different.
     *
     * @param T the TeamList object to be compared
     * @return true if both list contain the same Team otherwise false
     */

    public boolean equals(TeamList T)
    {
        if(this.size!=T.size){
            return false;
        }
        TeamNode currNode=this.head;
        TeamNode newNode=T.head;
        while(currNode!=null&&newNode!=null)
        {
            if(!currNode.equals(newNode))
            {
                return false;
            }
            currNode=currNode.getNextNode();
            newNode=newNode.getNextNode();
        }

        //if both the lists are exhausted and false isnt returned then return true

        return true;
    }


    /**
     * Returns a string representation of the list.
     *
     * @return a string representation of the list
     */
    public String toString() {

        if (this.size == 0) {
            return "";
        }
        String s = "";
        TeamList.TeamNode itr=this.head;
        while(itr!=null)
        {
            s += itr.toString() + "\n";
            itr=itr.getNextNode();
        }
        // return the string
        return s;
    }

    public Team returnTeam(String teamID)

    {
        TeamList.TeamNode itr=this.head;
        while(itr!=null)
        {
            if(itr.getTeam().getTeamID().equals(teamID))
                return itr.getTeam();
            itr=itr.getNextNode();
        }
        return null;
    }


    /**
     * Assign winning flag to the team.
     *
     *
     */
    public void assignFlag() {


        TeamList.TeamNode itr=this.head;
        TeamList.TeamNode itr1=itr.getNextNode();

        int val1=itr.getTeam().getPoints();
        int val2=itr1.getTeam().getPoints();

        int c1=0;
        int c2=0;

        while(itr!=null)
        {
            if(val1==itr.getTeam().getPoints())
                c1++;
            if(val2==itr.getTeam().getPoints())
                c2++;
            itr=itr.getNextNode();
        }

        itr=this.head;
        itr1=itr.getNextNode();

        int index=0;
        int cFlag=0;
        while(itr1!=null)
        {
            if(index==0)
            {
                if(c1>2)
                    itr.getTeam().setFlag("b");
                else
                    itr.getTeam().setFlag("a");

                if(c2>=2)
                    itr1.getTeam().setFlag("b");
                else
                    itr1.getTeam().setFlag("a");

            }
            else
            {
                if(cFlag==1)
                {
                    itr1.getTeam().setFlag("c");
                }
                else
                {
                    if(itr.getTeam().getPoints()==itr1.getTeam().getPoints())
                    {
                        itr1.getTeam().setFlag("d");
                    }
                    else
                    {
                        itr1.getTeam().setFlag("c");
                        cFlag=1;
                    }
                }

            }
            itr=itr.getNextNode();
            itr1=itr1.getNextNode();
            index++;
        }
    }

    TeamList.TeamNode sortedMerge(TeamList.TeamNode  a, TeamList.TeamNode b)
    {
        TeamList.TeamNode  result = null;
        /* Base cases */
        if (a == null)
            return b;
        if (b == null)
            return a;

        /* Pick either a or b, and recur */
        if (a.getTeam().getPoints() > b.getTeam().getPoints()) {
            result = a;

            result.setNextNode(sortedMerge(a.getNextNode(), b));

        }
        else if(a.getTeam().getPoints() < b.getTeam().getPoints()) {


            result = b;
            result.setNextNode(sortedMerge(a, b.getNextNode()));
        }
        else
        {
            if(a.getTeam().getNetRunRate()>b.getTeam().getNetRunRate())
            {

                result = a;
                result.setNextNode(sortedMerge(a.getNextNode(), b));
            }
            else{

                result = b;
                result.setNextNode(sortedMerge(a, b.getNextNode()));
            }
        }
        return result;
    }

    void mergeSortHelp()
    {
        this.head=mergeSort(this.head);
    }
    TeamList.TeamNode mergeSort(TeamList.TeamNode h)
    {
        // Base case : if head is null
        if (h == null || h.getNextNode() == null) {
            return h;
        }

        // get the middle of the list
        TeamList.TeamNode middle = getMiddle(h);
        TeamList.TeamNode nextOfMiddle = middle.getNextNode();

        // set the next of middle node to null
        middle.setNextNode(null);

        // Apply mergeSort on left list
        TeamList.TeamNode left = mergeSort(h);

        // Apply mergeSort on right list
        TeamList.TeamNode right = mergeSort(nextOfMiddle);

        // Merge the left and right lists
        TeamList.TeamNode sortedlist = sortedMerge(left, right);
        return sortedlist;
    }

    // Utility function to get the middle of the linked list
    public static TeamList.TeamNode getMiddle(TeamList.TeamNode head)
    {
        if (head == null)
            return null;

        TeamList.TeamNode slow = head, fast = head;

        while (fast.getNextNode() != null && fast.getNextNode().getNextNode() != null) {
            slow = slow.getNextNode();
            fast = fast.getNextNode().getNextNode();
        }
        return slow;
    }

    public void findQueryAnswer(String teamN)
    {
        HashMap<String, String> myMap = new HashMap<String, String>() {{
            put("a", " qualifies for the second round as it has more points than four other teams.");
            put("b", " qualifies for the second round as it has a higher net run rate.");
            put("c", " can't qualify for the second round as it doesn't have enough points.");
            put("d", " can't qualify for the second round as it doesn't have high enough run rate.");
        }};

        TeamList.TeamNode tempHead=this.head;
        while(tempHead!=null)
        {
            if(tempHead.getTeam().getTeamName().equals(teamN))
            {
                System.out.println(teamN+ myMap.get(tempHead.getTeam().getFlag()));
            }
            tempHead=tempHead.getNextNode();
        }

    }




}
