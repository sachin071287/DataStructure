package com.learning.programs.inmemoryfilesystem;

public class FileSystemTest {

	public static void main(String[] args) {

		OperationsImpl test = new OperationsImpl();
		// opening a file
		test.openFile("sachin", true);

		// reading file
		CustomFile output = test.readFile("sachin");
		System.out.println("Result : FileName " + output.getFileName() + " ErrorMsg : " + output.getErroMsg());

		// write
		test.writeToFile("sachin", "kumar");
		test.writeToFile("sachin", "ola");

		// reading again
		CustomFile output1 = test.readFile("sachin");
		for (String string : output1.getContents()) {
			System.out.println("Content of File : " + string);
		}
	}

}
