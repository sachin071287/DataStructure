package com.learning.linkedlist;

public class LinkedList {

	Node head;

	public static LinkedList insert(LinkedList list, String data) {
		// create a new node
		Node newNode = new Node();
		newNode.setData(data);
		newNode.setNextNode(null);

		// add to the linkedlist if
		if (list.head == null) {
			list.head = newNode;
		} else {
			// traverse the list, go till last and add the new node.
			Node lastNode = list.head;
			while (lastNode.nextNode != null) {
				lastNode = lastNode.nextNode;
			}
			lastNode.nextNode = newNode;

		}
		return list;
	}

	public static void printList(LinkedList list) {
		if (list == null) {
			return;
		}
		Node currentNOde = list.head;
		System.out.println("LinkedLIst is ");
		while (currentNOde != null) {
			System.out.println(currentNOde.getData());
			currentNOde = currentNOde.nextNode;
		}
	}

	public static LinkedList deleteByKey(LinkedList list, String key) {
		Node currentNode = list.head;

		// case1 : key is at head node
		if (currentNode != null && currentNode.getData().equalsIgnoreCase(key)) {
			list.head = currentNode.nextNode;
			System.out.println("Key present at HEAD and deleted");
			return list;
		}

		// case2 : key is present in between
		Node prev = null;
		while (currentNode != null && !currentNode.getData().equalsIgnoreCase(key)) {
			prev = currentNode;
			currentNode = currentNode.nextNode;
		}
		if (currentNode != null) {
			prev.nextNode = currentNode.nextNode;
			System.out.println("Deleted from middle");
		}
		// case 3 : if no key found
		if (currentNode == null) {
			System.out.println("NO key found");
		}
		return list;
	}
}
