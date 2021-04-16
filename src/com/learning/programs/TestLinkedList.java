package com.learning.programs;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import myApp.TestLinkedList.LinkedList.Node;

public class TestLinkedList {

	public static void main(String[] args) {
		TestLinkedList test = new TestLinkedList();
		LinkedList list = test.new LinkedList();
		Node node1 =list.new Node(1);
		Node node2 =list.new Node(2);
		/*
		 * Node node3 =list.new Node(2); //Node node4 =list.new Node(3); Node node5
		 * =list.new Node(2); Node node6 =list.new Node(1);
		 */
		list.addNode(node1);
		list.addNode(node2);
		/*
		 * list.addNode(node3); //list.addNode(node4); list.addNode(node5);
		 * list.addNode(node6);
		 */
		
		System.out.println(list);
		System.out.println("List is palindrome: " + list.isListPalindrome(list));
		
				
	}

	/**
	 * @author kumars
	 *
	 */
	public class LinkedList {

		int length;

		Node head;

		public int getLength() {
			return length;
		}

		public void setLength(int length) {
			this.length = length;
		}

		public Node getHead() {
			return head;
		}

		public void setHead(Node head) {
			this.head = head;
		}

		public boolean hasNext(Node node) {
			return node.getNext() != null;

		}
		
		public void addNode(Node node) {
			if (head == null) {
				head = node;
				return;
			}
			
			Node currentNode = head;
			while (currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(node);

		}
		
		@Override
			public String toString() {
			String output = "";
			if (head == null) {
				return super.toString();
			}
			
			Node currentNode = head;
			while (currentNode.getNext() != null) {
				output = output + currentNode.getData() + ",";
				currentNode = currentNode.getNext();
			}
			return output + currentNode.getData();
			}
		
		public boolean isListPalindrome(LinkedList list) {
			Stack<Integer>stack = new Stack();
			
			Node headNode = list.getHead();
			if(headNode == null) {
				return true;
			}
			if(headNode.getNext()==null) {
				return true;
			}
			Node tempCurrentNode = head;
			while(tempCurrentNode.getNext()!=null){
				stack.push(tempCurrentNode.getData());
				tempCurrentNode = tempCurrentNode.getNext();
			}
			stack.push(tempCurrentNode.getData());
			Node tempCurrentNode1 = head;
			for (int i=stack.size()-1;i>=0; i--) {
				if(stack.get(i) != null && stack.get(i) != tempCurrentNode1.data) {
					return false;
				}
				tempCurrentNode1 = tempCurrentNode1.getNext();
			}
			return true;
			
		}

		class Node {
			int data;
			Node next;

			public Node(int data) {
				this.data = data;
			}
			public int getData() {
				return data;
			}

			public void setData(int data) {
				this.data = data;
			}

			public Node getNext() {
				return next;
			}

			public void setNext(Node next) {
				this.next = next;
			}

		}

	}
}