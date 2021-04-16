package com.learning.programs.inmemoryfilesystem;

public interface Operations {

	CustomFile readFile(String fileName);

	boolean closeFile(String fileName);

	CustomFile openFile(String fileName, boolean needtoCreateIfnotPresent);

	CustomFile writeToFile(String fileName, String content);

}
