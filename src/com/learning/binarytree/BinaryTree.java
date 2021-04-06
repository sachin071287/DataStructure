package com.learning.binarytree;

/**
 * Tree :
 *     1
 *   2   3
 *  4  5
 * @author kumars
 *
 */
public class BinaryTree {

	static Node root;

	public BinaryTree() {
		root = null;
	}

	/**
	 * For preorder we print : NODE, LEFT , RIGHT
	 * 
	 * @param node
	 */
	public static void printPreOrder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + " ");
		printPreOrder(node.left);
		printPreOrder(node.right);
	}

	/**
	 * For inorder we print : LEFT ,NODE ,RIGHT
	 * 
	 * @param node
	 */
	public static void printInOrder(Node node) {
		if (node == null) {
			return;
		}
		printInOrder(node.left);
		System.out.print(node.data + " ");
		printInOrder(node.right);
	}

	/**
	 * For postorder we print : LEFT , RIGHT ,NODE
	 * 
	 * @param node
	 */
	public static void printPostOrder(Node node) {
		if (node == null) {
			return;
		}
		printPostOrder(node.left);
		printPostOrder(node.right);
		System.out.print(node.data + " ");
	}

	// Wrappers over above recursive functions
	void printPostorder() {
		printPostOrder(root);
	}

	void printInorder() {
		printInOrder(root);
	}

	void printPreorder() {
		printPreOrder(root);
	}

}
