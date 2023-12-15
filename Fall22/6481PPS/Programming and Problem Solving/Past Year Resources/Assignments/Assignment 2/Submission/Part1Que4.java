package Assignment2;

import java.util.Arrays;

public class Part1Que4 {

	public static String getSortedStr(String s) {
		char[] charArr = s.toCharArray();
		Arrays.sort(charArr);
		return new String(charArr);
	}

	public static boolean checkForValidBinaryTree(String preorder, String postorder, Node tree) {
		System.out.println("preorder ==> " + preorder + " of length ==> " + preorder.length());
		System.out.println("postorder ==> " + postorder + " of length ==> " + postorder.length());
		int length = postorder.length();
		
		if(length  == 3) {
			if(preorder.charAt(0) == postorder.charAt(2) && preorder.charAt(1) == postorder.charAt(0) && preorder.charAt(2) == postorder.charAt(1)) {
				tree = new Node(preorder.charAt(0));
				tree.left = new Node(preorder.charAt(1));
				tree.right = new Node(preorder.charAt(2));
				System.out.println("last L Root R node tree ===> " + tree);
				return true;
			}
			else {
				if(!(preorder.charAt(0) == postorder.charAt(2))) {
					System.out.println("issue due to ==> " + preorder.charAt(0));
				}
				else if(!(preorder.charAt(1) == postorder.charAt(0))) {
					System.out.println("issue due to ==> " + preorder.charAt(1));
				}
				else {
					System.out.println("issue due to ==> " + preorder.charAt(2));
				}
				return false;
			}
		}

		if(length == 1) {
			if(preorder.charAt(0) == postorder.charAt(0)) {
				tree = new Node(preorder.charAt(0));
				System.out.println("leaf node tree ===> " + tree);
				return true;
			}
			else {
				System.out.println("issue due to ==> " + preorder.charAt(0));
				return false;
			}
		}

		if (preorder.charAt(0) == postorder.charAt(length - 1)) {
			tree = new Node(preorder.charAt(0));
			System.out.println("found root node tree ===> " + tree);
			int index = 0;
			boolean foundRootMatch = false;
			while (!foundRootMatch && index <= length - 1) {
				System.out.println("index ==> " + index);
				if (preorder.charAt(1) == postorder.charAt(index)) {
					foundRootMatch = true;
					break;
				}
				index++;
			}
			if (foundRootMatch) {
				System.out.println("foundRootMatch tree ==> " + tree);
				if(index+1 < length && index+2 < length) { // has left and right sub tree
					return checkForValidBinaryTree(preorder.substring(1, (index + 1)+1), postorder.substring(0, (index)+1), tree.left) // left tree
							&&
						   checkForValidBinaryTree(preorder.substring(index + 2, (length - 1)+1), postorder.substring(index + 1, (length - 2)+1), tree.right); // right tree
				}  
				else if (!(index+1 < length)) { // has only right sub tree
					return checkForValidBinaryTree(preorder.substring(index + 2, (length - 1)+1), postorder.substring(index + 1, (length - 2)+1), tree.right); // right tree
				}
				else if(!(index+2 < length)) { // has only left sub tree
					return checkForValidBinaryTree(preorder.substring(1, (index + 1)+1), postorder.substring(0, (index)+1), tree.left); // left tree
				}
				else { // do not have any sub tree;
					return true;
				}
			} else {
				System.out.println("issue due to ==> " + preorder.charAt(1));
				return false;
			}
		} else {
			System.out.println("issue due to ==> " + preorder.charAt(0));
			return false;
		}
	}
	
	public static void printInorder(Node root)
    {
        if (root == null) {
        	System.out.println();
        	return;
        }
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }
 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String preOrder = "EKDMJGIACFHBL"; // "12453"
		String postOrder = "DJIGAMKFLBHCE"; // "45231"
		
		Node tree = null;

		if (preOrder.length() == postOrder.length() && checkForValidBinaryTree(preOrder, postOrder, tree)) {
			System.out.println("tree ===> " + tree);
			printInorder(tree);
			System.out.println("valid");
		} else {
			System.out.println("invalid");
		}

	}

}

//class to create nodes
class Node {
	char data;
	Node left, right;

	public Node(char item) {
		data = item;
		left = right = null;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
	}
	
}
