package edu.umb.cs.cs680;

public class File extends FSElement {

	private int fileSize;
	
	public File(Directory parent, String name, String owner, int size) {
		super(parent, name, owner, size);
		this.fileSize = size;
	}


	public void accept(FSVisitor v) {
		v.visit(this);
	}

	public int getDiskUtil() {
		return fileSize;
	}

}
