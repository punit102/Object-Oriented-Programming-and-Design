package edu.umb.cs.cs680;

public class Rmdir implements Command {

	private String dir_name;

	Rmdir(String dir_name) {
		this.dir_name = dir_name;

	}

	@Override
	public void execute() {

		FileSystem.getInstance().getCurrent();
		FileSystem.getInstance().getCurrent().getChildren();

		for (FSElement s : FileSystem.getInstance().getCurrent().getChildren()) {
			if (s.toString() == dir_name) {
				FileSystem.getInstance().removeChild(FileSystem.getInstance().getCurrent(), s);
				break;
			}

		}
		System.out.print("Directory removed!"+"\n");


	}

}
