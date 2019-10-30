package edu.umb.cs.cs680;

import java.util.ArrayList;
import java.util.Comparator;

public class Sort implements Command {

	private String policy;
	private Comparator<FSElement> f;

	public Sort(String policy) {
		this.policy = policy;

	}

	public void execute() {

		if (policy.equals("reverse")) {
			f = new ReverseAlphabeticalComparator();
			FileSystem.getInstance().sort(FileSystem.getInstance().getCurrent(), f);
			
			ArrayList<FSElement> children = FileSystem.getInstance().getCurrent().getChildren();
			for(FSElement fs: children)
			{
				System.out.print(fs.getName()+"\n");
			}
			
		}
		else if(policy.equals("alphabetic")) {
			f = new AlphabeticalComparator();
			FileSystem.getInstance().sort(FileSystem.getInstance().getCurrent(), f);
			ArrayList<FSElement> children = FileSystem.getInstance().getCurrent().getChildren();
			for(FSElement fs: children)
			{
				System.out.print(fs.getName()+"\n");
			}
		}

	}

}
