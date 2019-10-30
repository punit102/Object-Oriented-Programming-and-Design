package edu.umb.cs.cs680;

public class Chown implements Command {

	private String owner_name;
	
	public Chown(String dir_name) {
		this.owner_name = dir_name;
	}

	@Override
	public void execute() {

	FileSystem.getInstance().getCurrent().changeOwner(owner_name);		
	}

}
