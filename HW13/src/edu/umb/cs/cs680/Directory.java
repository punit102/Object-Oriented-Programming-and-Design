package edu.umb.cs.cs680;

import java.util.ArrayList;
import java.util.Iterator;

public class Directory extends FSElement {

	private ArrayList<FSElement> fselements = new ArrayList<FSElement>();

	public Directory(Directory parent, String name, String owner, int size) {
		super(parent, name, owner, size);

	}

	public ArrayList<FSElement> getChildren() {
		System.out.println("Current Directory Children:" + fselements.toString());
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
		int totalSize = 0;
		for (FSElement temp : fselements) {

			totalSize = totalSize + temp.getSize();
		}
		return totalSize;
	}

}
