package com.learning.binarytree;

/**
 *             1
            /     \
          2        3
        /   \     
      4      5  
      
 * @author kumars
 *
 */
public class BinaryTreeTraversalTest {

	public static void main(String[] args) {

		BinaryTree btree = new BinaryTree();
		Node rootNode = new Node(1);
		rootNode.left = new Node(2);
		rootNode.right = new Node(3);
		rootNode.left.left = new Node(4);
		rootNode.left.right = new Node(5);
		btree.root = rootNode;
		
		System.out.println("The tree traversal in INORDER");
		btree.printInorder();
		System.out.println("\nThe tree traversal in POSTORDER");
		btree.printPostorder();
		System.out.println("\nThe tree traversal in PREORDER");
		btree.printPreorder();
		

	}
}
