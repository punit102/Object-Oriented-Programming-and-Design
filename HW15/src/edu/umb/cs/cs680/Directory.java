package edu.umb.cs.cs680;

import java.util.ArrayList;

public class Directory extends FSElement {

	
	private ArrayList<FSElement> children = new ArrayList<FSElement>();

	public Directory(Directory parent, String name, String owner, int size) {
		super(parent, name, owner, size);

	}

	public void appendChild(FSElement f) {
		children.add(f);
	}

	public void accept(FSVisitor v) {
		v.visit(this);
		for (FSElement e : children) {
			e.accept(v);
		}
	}

	public int getDiskUtil() {
		return 0;
	}
}
