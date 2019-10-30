package edu.umb.cs.cs680;

import java.util.ArrayList;
import java.util.Iterator;

public class Directory extends FSElement {

	private ArrayList<FSElement> fselements;
	private int totalSize;

	public Directory(Directory parent, String name, String owner, int size) {
		super(parent, name, owner, size);
		fselements = new ArrayList<FSElement>();

	}

	public ArrayList<FSElement> getChildren() {
		return fselements;
	}

	public void appendChild(FSElement f) {
		fselements.add(f);
	}

	public void printName() {
		System.out.print(" Directory:- " + getName() + "  Parent :" + getParent()+"\n");
		Iterator<FSElement> fileIterator = fselements.iterator();
		while (fileIterator.hasNext()) {
			FSElement file = fileIterator.next();
			file.printName();
		}
		
	}

	public int getSize() {
		for (FSElement fse : fselements) {
			totalSize = totalSize + fse.getSize();
		}
		return this.totalSize;
	}

}
