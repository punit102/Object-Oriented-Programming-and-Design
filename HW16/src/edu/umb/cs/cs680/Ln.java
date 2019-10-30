package edu.umb.cs.cs680;

public class Ln implements Command {

	private FSElement dir_name;
	private String link_name;

	public Ln(FSElement dir_name, String link_name) {
		this.dir_name = dir_name;
		this.link_name = link_name;
	}

	@Override
	public void execute() {

		FileSystem.getInstance().getCurrent().appendChild(new Link(FileSystem.getInstance().getCurrent().getParent(),
				link_name, FileSystem.getInstance().getCurrent().getOwner(), 0, dir_name));
		System.out.print("Link created and its target set to the " + dir_name+"\n");
	}

}
