package edu.umb.cs.cs680;

public class Link extends FSElement {

	public Link(Directory parent, String name, String owner, int size, FSElement target) {
		super(parent, name, owner, size);

	}

	public void accept(FSVisitor v) {
		v.visit(this);
	}

	public int getDiskUtil() {
		return 0;
	}
}
