package edu.umb.cs.cs680;

public class Cp implements Command {

	
	private String dir_name;
	private Directory dest_dir;

	public Cp(String dir_name, Directory dest_dir) {
		this.dir_name = dir_name;
		this.dest_dir = dest_dir;

	}

	public void execute() {
		for (FSElement s : FileSystem.getInstance().getCurrent().getChildren()) {

			if (s.toString() == dir_name) {
				System.out.print("Copying :"+"\n");
				dest_dir.appendChild(s);
				FileSystem.getInstance().setCurrent(dest_dir);
				System.out.print("Copied!"+"\n");
				break;

			}

		}

	}

}