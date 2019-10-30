package edu.umb.cs.cs680;

public class FSElement {

	private String name;
	private String owner;
	private int size;
	private Directory parent;
	
	public FSElement(Directory parent, String name, String owner, int size) {
		this.parent = parent;
		this.name = name;
		this.owner = owner;
		this.size = size;
	}
	
	public void accept(FSVisitor v) {
	}

	public int getDiskUtil() {
		return 0;
	}
	
	public Directory getParent() {
		return parent;
	}

	public int getSize() {
		return size;
	}

	public String getName() {
		return name;

	}
	public String getOwner()
	{
		return owner;
	}
	
	public String toString()
	{
		return name;
	}

}
