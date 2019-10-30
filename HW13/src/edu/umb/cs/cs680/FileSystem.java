package edu.umb.cs.cs680;

public class FileSystem {

	private static FileSystem instance;
	private Directory dir;

	private FileSystem(Directory dir) {
		this.dir = dir;
	}

	public static FileSystem getInstance(Directory dir) {
		if (instance == null) {
			instance = new FileSystem(dir);
		}
		return instance;
	}

	public void showAllElements() {
	
		dir.printName();
	}
}
