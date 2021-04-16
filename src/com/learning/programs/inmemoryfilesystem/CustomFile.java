package com.learning.programs.inmemoryfilesystem;

import java.util.ArrayList;
import java.util.List;

public class CustomFile {
	
	String fileName ;
	
	boolean isOpened;
	
	String erroMsg ;
	
	List<String> contents;

	public List<String> getContents() {
		return contents;
	}

	public void setContents(List<String> contents) {
		this.contents = contents;
	}

	public void addContents(String content) {
		if(this.contents == null ) {
			this.contents = new ArrayList<String>();
		}
		this.contents.add(content);
	}
	
	public String getErroMsg() {
		return erroMsg;
	}

	public void setErroMsg(String erroMsg) {
		this.erroMsg = erroMsg;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public boolean isOpened() {
		return isOpened;
	}

	public void setOpened(boolean isOpened) {
		this.isOpened = isOpened;
	}

	public CustomFile(String fileName, boolean isOpened) {
		super();
		this.fileName = fileName;
		this.isOpened = isOpened;
	}

	public CustomFile() {
		// TODO Auto-generated constructor stub
	}
	
	
	

}
