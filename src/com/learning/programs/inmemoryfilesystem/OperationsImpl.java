package com.learning.programs.inmemoryfilesystem;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class OperationsImpl implements Operations {
// <fileName , customObject to store file info>
	Map<String, CustomFile> inMemoryFiles = new HashMap<String, CustomFile>();
	
	@Override
	public CustomFile readFile(String fileName) {
		CustomFile customFile = new CustomFile();
		if (fileName == null || fileName.length() < 1) {
			return null;
		}
		if (inMemoryFiles.containsKey(fileName)) {
			return inMemoryFiles.get(fileName);
		}
		customFile.setErroMsg("No file found");
		return customFile;
	}

	@Override
	public boolean closeFile(String fileName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CustomFile openFile(String fileName, boolean needtoCreateIfnotPresent) {
		if (fileName == null || fileName.length() < 1) {
			return null;
		}
		if (inMemoryFiles.containsKey(fileName)) {
			return inMemoryFiles.get(fileName);
		}
		if (needtoCreateIfnotPresent) {
			inMemoryFiles.put(fileName, new CustomFile(fileName, true));
		}
		return null;
	}

	@Override
	public CustomFile writeToFile(String fileName, String content) {
		CustomFile customFile = new CustomFile();
		if (fileName == null || fileName.length() < 1) {
			customFile.setErroMsg("Invalid File Name");
			return customFile;
		}
		if (inMemoryFiles.containsKey(fileName)) {
			customFile = inMemoryFiles.get(fileName);
			customFile.addContents(content);
			return customFile;
		}
		customFile.setErroMsg("NO file");
		return customFile;
	}

}
