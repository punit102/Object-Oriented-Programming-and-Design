package edu.umb.cs.cs680;

public class Mkdir implements Command {

	private String dir_name;

	Mkdir(String dir_name) {
		this.dir_name = dir_name;

	}

	@Override
	public void execute() {

		FileSystem.getInstance().getCurrent();
		FileSystem.getInstance().addChild(FileSystem.getInstance().getCurrent(), new Directory(
				FileSystem.getInstance().getCurrent(), dir_name, FileSystem.getInstance().getCurrent().getOwner(), 0));
		System.out.print("Directory created!"+"\n");

	}

}
