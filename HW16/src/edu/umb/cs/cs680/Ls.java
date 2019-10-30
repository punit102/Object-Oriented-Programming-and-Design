package edu.umb.cs.cs680;

import java.util.ArrayList;

public class Ls implements Command {

	@Override
	public void execute() {
	
		System.out.print("Current Directory Structure"+"\n");
		ArrayList<FSElement> children = FileSystem.getInstance().getCurrent().getChildren();
		for(FSElement fs: children)
		{
			System.out.print(fs.getName()+"\n");
		}
	}

}
