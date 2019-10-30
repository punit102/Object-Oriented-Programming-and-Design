package edu.umb.cs.cs680;

public class Pwd implements Command {

	@Override
	public void execute() {

		FileSystem.getInstance().getCurrent();
		System.out.print("Current Working Directory in Pwd Command: " + FileSystem.getInstance().getCurrent().toString()+"\n");

	}

}
