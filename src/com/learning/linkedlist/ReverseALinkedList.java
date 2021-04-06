package com.learning.linkedlist;

public class ReverseALinkedList {

	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		list = LinkedList.insert(list, "Sachin");
		list = LinkedList.insert(list, "kumar");
		list = LinkedList.insert(list, "Misti");
		list = LinkedList.insert(list, "Sonu");
		LinkedList.printList(list);

		reverse(list);
		LinkedList.printList(list);

	}

	/**
	 * Initialize three pointers
	 * prev as NULL, curr as head and next as NULL.
	 * Iterate through the linked list. 
	 * In loop, do following. // Before changing
	 * next of current, // store next node next = curr->next // Now change next of
	 * current // This is where actual reversing happens curr->next = prev
	 * 
	 * // Move prev and curr one step forward prev = curr curr = next
	 * 
	 * @param list
	 */
	private static void reverse(LinkedList list) {
		
		Node prev = null; 
		Node next =null;
		Node current = list.head;
		while (current != null) {
			next = current.nextNode;
			current.nextNode = prev;
			prev = current;
			current = next;
		}
		list.head = prev;
	}

}
