package edu.umb.cs.cs680;

import java.util.Comparator;

public class ReverseAlphabeticalComparator implements Comparator<FSElement> {

	public int compare(FSElement arg0, FSElement arg1) {
		return arg1.getName().compareToIgnoreCase(arg0.getName());
	}
}