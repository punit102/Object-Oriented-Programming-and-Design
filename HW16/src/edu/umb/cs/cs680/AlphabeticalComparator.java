package edu.umb.cs.cs680;

import java.util.Comparator;

public class AlphabeticalComparator implements Comparator<FSElement> {

	@Override
	public int compare(FSElement arg0, FSElement arg1) {
		return arg0.getName().compareToIgnoreCase(arg1.getName());
	}
}
