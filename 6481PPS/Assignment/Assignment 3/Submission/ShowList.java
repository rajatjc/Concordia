// ______________
// Assignment 3
// © Mukesh Kumar Angrish
// Written by: Mukesh Kumar Angrish (Student ID - 40203596)
// ______________
import java.util.NoSuchElementException;

/**
 * A class that implements the ADT list by using a chain of nodes.
 */
public class ShowList {
    /**
     * Inner class to represent a node in the list.
     */
    public class ShowNode {
        private TVShow show;
        private ShowNode next;
        /**
         * Modifies the TV Show in the Show Node.
         * @param show the new TV Show
         */
        public void setShow(TVShow show) {
            this.show = show;
        }
        /**
         * Returns the TV Show in the Show Node.
         * @return the TV Show in the Show Node
         */
        public TVShow getShow() {
            return show;
        }
        /**
         * Modifies the next node in the list.
         * @param next the new next node
         */
        public void setNext(ShowNode next) {
            this.next = next;
        }
        /**
         * Returns the next node in the list.
         * @return the next node in the list
         */
        public ShowNode getNext() {
            return next;
        }
        /**
         * Constructs a Show Node with null values for the TV Show and next node.
         */
        public ShowNode() {
            this.show = null;
            this.next = null;
        }
        /**
         * Constructs a Show Node with the specified TV Show and next node.
         * @param show the TV Show
         * @param next the next node
         */
        public ShowNode(TVShow show, ShowNode next) {
            this.show = show;
            this.next = next;
        }
        /**
         * Constructs a Show Node from another Show Node.
         * @param node the given Show Node to be copied
         * @param next the next node
         */
        public ShowNode(ShowNode node, ShowNode next) {
            this.show = node.show;
            this.next = next;
        }
        /**
         * Clones the Show Node and returns a deep copy of the original Show Node.
         * @return a deep copy of the original Show Node
         */
        public ShowNode clone() {
            // create a clone of node and then create a new ShowNode object with the cloned node and next node of ShowNode node object
            TVShow clone = this.show.clone();
            ShowNode cloneNode = new ShowNode(clone, this.next);
            return cloneNode;
        }
        /**
         * Returns a string representation of the Show Node.
         * @return a string representation of the Show Node
         */
        public String toString() {
            return this.show.toString();
        }
    }
    // private attributes of the ShowList class
    private ShowNode head;
    private int size;
    /**
     * Constructs an empty list.
     */
    public ShowList() {
        this.head = null;
        this.size = 0;
    }
    /**
     * Constructs a copy of the given list of TV Shows.
     * @param L the given list of TV Shows
     */
    public ShowList(ShowList L) {
        // if the head of the ShowList object is null, then the head of the new ShowList object is null
        if (L.head == null) {
            this.head = null;
        }
        // if the head of the ShowList object is not null, go through each node and clone each node
        else {
            // create a new ShowNode object with the cloned node and next node of ShowNode node object
            ShowNode cloneNode = L.head.clone();
            // set the head of the new ShowList object to the cloned node
            this.head = cloneNode;
            // go through each node and clone each node
            for (ShowNode node = L.head.getNext(); node != null; node = node.getNext()) {
                // create a new ShowNode object with the cloned node and next node of ShowNode node object
                cloneNode.setNext(node.clone());
                // set the head of the new ShowList object to the cloned node
                cloneNode = cloneNode.getNext();
            }
            cloneNode.setNext(null);
        }
        // set the size of the new ShowList object to the size of the ShowList object
        this.size = L.size;
    }
    /**
     * Adds a TV Show to the front of the list.
     * @param S the TV Show to be added
     */
    public void addToStart(TVShow S) {
        // create a new ShowNode object with the TVShow object and next node of ShowNode node object
        ShowNode node = new ShowNode(S, head);
        // set the head of the ShowList object to the new ShowNode object
        this.head = node;
        // increment the size of the ShowList object
        this.size++;
    }

    /**
     * Adds a TV Show to a given position in the list.
     * @param S the TV Show to be added
     * @param index the position in the list where the TV Show is to be added
     * @throws NoSuchElementException if the index is out of range
     */
    public void insertAtIndex(TVShow S, int index) throws NoSuchElementException {
        // if the index is less than 0 or greater than the size of the ShowList object, throw an exception
        if (index < 0 || index > this.size) {
            throw new NoSuchElementException();
        }
        // if the index is 0, then add the TVShow object to the start of the ShowList object
        if (index == 0) {
            this.addToStart(S);
        }
        // if the index is not 0, then go through each node and insert the TVShow object at the index
        else {
            // go through each node and insert the TVShow object at the index
            int next = 1;
            for (ShowNode node = this.head; node != null; node = node.getNext()) {
                // if the index is 1, then insert the TVShow object at the index
                if (index == next) {
                    // create a new ShowNode object with the TVShow object and assign next node as the next node of the current node
                    ShowNode newNode = new ShowNode(S, node.getNext());
                    // set the next node of the current node to the new ShowNode object
                    node.setNext(newNode);
                }
                // increment the next index
                next++;
            }
        }
    }
    /**
     * Removes a TV Show from the front of the list.
     * @throws NoSuchElementException if the list is empty
     */
    public void deleteFromStart() throws NoSuchElementException{
        // if the head of the ShowList object is null, then throw an exception
        if (this.head == null) {
            throw new NoSuchElementException();
        }
        // if the head of the ShowList object is not null, then set the head of the ShowList object to the next node of the head of the ShowList object
        else {
            this.head = this.head.getNext();
        }
        // decrement the size of the ShowList object
        this.size--;
    }
    /**
     * Removes a TV Show from a given position in the list.
     * @param index the position in the list where the TV Show is to be removed
     * @throws NoSuchElementException if the index is out of range
     */
    public void deleteFromIndex(int index) throws NoSuchElementException {
        // if the index is less than 0 or greater than the size of the ShowList object, throw an exception
        if (index < 0 || index > this.size-1) {
            throw new NoSuchElementException();
        }
        // if the index is 0, then remove the first node of the ShowList object
        if (index == 0) {
            this.deleteFromStart();
        }
        // if the index is not 0, then go through each node and remove the node at the index
        else {
            // go through each node and remove the node at the index
            int next = 1;
            for (ShowNode node = this.head; node != null; node = node.getNext()) {
                // if the index is 1, then remove the node at the index
                if (index == next) {
                    // set the next node of the current node to the next node of the next node
                    node.setNext(node.getNext().getNext());
                }
                // increment the next index
                next++;
            }
        }
        // decrement the size of the ShowList object
        this.size--;
    } 
    /**
     * Replaces a TV Show at a given position in the list.
     * @param S the replacement TV Show
     * @param index the position in the list where the TV Show is to be replaced
     */
    public void replaceAtIndex(TVShow S, int index) {
        // if the index is less than 0 or greater than the size of the ShowList object, throw an exception
        if (index < 0 || index > this.size-1) {
            // simply return without doing anything
            return;
        }
        // if the index is 0, then replace the first node of the ShowList object with the TVShow object
        if (index == 0) {
            this.head.setShow(S);
        }
        // if the index is not 0, then go through each node and replace the node at the index with the TVShow object
        else {
            // go through each node and replace the node at the index with the TVShow object
            int next = 1;
            for (ShowNode node = this.head; node != null; node = node.getNext()) {
                // if the index is 1, then replace the node at the index with the TVShow object
                if (index == next) {
                    // set the show of the current node to the TVShow object
                    node.setShow(S);
                }
                // increment the next index
                next++;
            }
        }
    }
    /**
     * Returns the TV Show for a given ID. This method can leak private information since it is returning a reference to an object
     * @param showID the ID of the TV Show to be returned
     * @return the node in the list containing the TV Show with the given ID, or null if no such node exists
     * One way to avoid this leakage is to make the ShowNode class private and/or make methods that extend the (private) find method such that the method can only be used by other ShowList methods
     */
    public ShowNode find(String showID) {
        int iterations = 1;
        // go through each node and find the ShowNode object with the showID
        for (ShowNode node = this.head; node != null; node = node.getNext()) {
            // if the showID of the current node is the same as the showID, then return the current node
            if (node.getShow().getShowID().equals(showID)) {
                System.out.println("Found the show " + showID + " in " + iterations + " iterations.");
                return node;
            }
            iterations++;
        }
        // if the ShowNode object with the showID is not found, then return null
        return null;
    }
    /**
     * Returns true if the list contains a TV Show with the given ID.
     * @param showID the ID of the TV Show to be checked
     * @return true if the list contains a TV Show with the given ID, false otherwise
     */ 
    public boolean contains(String showID) {
        // go through each node and find the ShowNode object with the showID
        for (ShowNode node = this.head; node != null; node = node.getNext()) {
            // if the showID of the current node is the same as the showID, then return true
            if (node.getShow().getShowID().equals(showID)) {
                return true;
            }
        }
        // if the ShowNode object with the showID is not found, then return false
        return false;
    }
    /**
     * Returns true if both lists contain the same TV Shows, false otherwise.
     * @param S the ShowList object to be compared to
     * @return true if both lists contain the same TV Shows, false otherwise
     */
    public boolean equals(ShowList S) {
        // if the size of the ShowList object is not the same, then return false
        if (this.size != S.size) {
            return false;
        }
        // go through each node for each ShowList and use the equals() method to compare the ShowNode objects at the same index
        ShowNode thisNode = this.head;
        ShowNode compareNode = S.head;
        while(thisNode != null && compareNode != null) {
            // if the equals() method returns false, then return false
            if (!thisNode.equals(compareNode)) {
                return false;
            }
            thisNode = thisNode.getNext();
            compareNode = compareNode.getNext();
        }
        // if the ShowNode objects are equal, then return true
        return true;
    }
    /**
     * Returns a string representation of the list.
     * @return a string representation of the list
     */
    public String toString() {
        // if the ShowList object is empty, then return an empty string
        if (this.size == 0) {
            return "";
        }
        // go through each node and add the string representation of the ShowNode object to the string
        String s = "";
        for (ShowNode node = this.head; node != null; node = node.getNext()) {
            s += node.toString() + "\n";
        }
        // return the string
        return s;
    }
}
