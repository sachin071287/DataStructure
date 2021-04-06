package com.learning.linkedlist;

public class Test {

	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		list = LinkedList.insert(list, "Sachin");
		list = LinkedList.insert(list, "kumar");
		list = LinkedList.insert(list, "Misti");
		list = LinkedList.insert(list, "Sonu");
		LinkedList.printList(list);
		
		LinkedList.deleteByKey(list, "Misti");
		LinkedList.printList(list);
		
	}

}
