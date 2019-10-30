package edu.umb.cs.cs680;


public class Cd implements Command {

	private String dir_name;

	Cd(String dir_name) {
		this.dir_name = dir_name;

	}

	Cd() {
	}

	@Override
	public void execute() {
		
		
		if(dir_name != null && dir_name !=  "..")
		{
	
			for (FSElement s : FileSystem.getInstance().getCurrent().getChildren()) {
				if(s.toString() == dir_name)
			      FileSystem.getInstance().setCurrent((Directory) s);

			}
			System.out.print("You move to the this Directory :"+FileSystem.getInstance().getCurrent().toString()+"\n");
			
			
		}else if(dir_name == "..")  
		{
			
			FileSystem.getInstance().setCurrent(FileSystem.getInstance().getCurrent().getParent());
			System.out.print("You move to the Parent Directory :"+FileSystem.getInstance().getCurrent().toString()+"\n");
		}
		else if(dir_name == null)
		{
			
			FileSystem.getInstance().setCurrent(FileSystem.getInstance().getRoot());
			System.out.print("You move to the Root Directory :"+FileSystem.getInstance().getCurrent().toString()+"\n");
		}
	
	}

}
