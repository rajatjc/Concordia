import java.util.Scanner;

public class UseBST {

	public static void main(String[] args) {
		
			
		BST b1 = new BST();
		
	
		System.out.println("Enter a value to add to the tree or -1 to terminate: ");
		int v, y;
		Scanner kb = new Scanner(System.in);
		
		v = kb.nextInt();
		while(v != -1)
		{
			b1.insert(v);
			
			v = kb.nextInt();
		}
		
		System.out.println("Tree creation is done.");
 
		System.out.println("Enter the values you want to search for ending by -1 to terminate: ");
		v = kb.nextInt();
		while(v != -1)
		{
			y = b1.parentOf(v);
			if(y==-1)
				System.out.println("Value " + v + " does not exist in tree.");
			else if (y == 0)
				System.out.println("Value " + v + " is tree root.");
			else
				System.out.println("Parent of " + v + " is " + y);
			v = kb.nextInt();
		}
		kb.close();
	}

}

class BST {
	
	class Node {
		int value;
		Node leftChild, rightChild;
		Node parent;
		public Node(int val, Node par) {
			value = val;
			parent = par;
			leftChild = null;
			rightChild = null;
		}
	}
	
	Node root;
	
	public void insert(int val) {
		if(root == null) {
			root = new Node(val, null);
		}
		else {
			insertRecur(root, val, null);
		}
	}
	
	private Node insertRecur(Node node, int val, Node parent) {
		if(node == null) {
			node = new Node(val, parent);
			return node;
		}
			
		if(val < node.value) {
			node.leftChild = insertRecur(node.leftChild, val, node);
		}
		else if(val > node.value) {
			node.rightChild = insertRecur(node.rightChild, val, node);
		}
		else {
			// value already exists
		}
		return node;
	}
	
	public int parentOf(int val) {
		if(root.value == val) {
			return 0;
		}
		else {
			return parentOfRecur(root, val);
		}
	}
	
	private int parentOfRecur(Node node, int val) {
		if(node == null) {
			return -1;
		}
		
		if(val < node.value) {
			return parentOfRecur(node.leftChild, val);
		}
		else if(val > node.value) {
			return parentOfRecur(node.rightChild, val);
		}
		else {
			return node.parent.value;
		}
	}
}

// 20 32 5 3 2 15 27 45 38 52 1 9 8 10 67 59 102 63 -1
// 15 52 1 102 77 32 10 45 93 67 -1