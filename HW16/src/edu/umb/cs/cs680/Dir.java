package edu.umb.cs.cs680;

import java.util.ArrayList;

public class Dir implements Command {

	private String dir_name;

	Dir(String dir_name) {
		this.dir_name = dir_name;

	}

	Dir() {
	}

	@Override
	public void execute()throws NullPointerException {

		if (dir_name != null && dir_name != "..") {

			for (FSElement s : FileSystem.getInstance().getCurrent().getChildren()) {
				if(s.toString() == dir_name)
			      FileSystem.getInstance().setCurrent((Directory) s);

			}
			System.out.print("You move to the this Directory :"+"\n");
			System.out.print(FileSystem.getInstance().getCurrent().getName()+"   " +FileSystem.getInstance().getCurrent().getParent().getName()+"   " +FileSystem.getInstance().getCurrent().getOwner()+"   " +FileSystem.getInstance().getCurrent().getSize()+"\n");

		} else if (dir_name == "..") {

			FileSystem.getInstance().setCurrent(FileSystem.getInstance().getCurrent().getParent());
			ArrayList<FSElement> children = FileSystem.getInstance().getCurrent().getChildren();
			for(FSElement fs: children)
			{	
				System.out.print(fs.getName()+"   "+fs.getOwner()+"   "+fs.getParent().getName()+"   "+fs.getSize() +"\n");
			}
		} else if (dir_name == null) {

			FileSystem.getInstance().setCurrent(FileSystem.getInstance().getCurrent());
			ArrayList<FSElement> children = FileSystem.getInstance().getCurrent().getChildren();
			for(FSElement fs: children)
			{
				
				System.out.print(fs.getName()+"   "+fs.getOwner()+"   "+fs.getParent().getName()+"   "+fs.getSize() +"\n");
			}
			
		} 
	}

}
