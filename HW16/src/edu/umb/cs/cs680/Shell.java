package edu.umb.cs.cs680;

public class Shell {

	private Pwd pwd;
	private Cd cd;
	private CommandHistory cmd;
	private Ls ls;
	private Dir dir;
	private Mkdir mkdir;
	private Rmdir rmdir;
	private Ln ln;
	private Mv mv;
	private Cp cp;
	private Chown chown;
	private History history;
	private Redo redo;
	private Sort sort;

	public Shell() {
		cmd = new CommandHistory();
		
	}

	public void pwdCommand() {
		pwd = new Pwd();
		pwd.execute();
		cmd.push("pwd");
	}

	public void cdCommand(String dir_name) {

		cd = new Cd(dir_name); 
		cd.execute();
		cmd.push("cd "+ dir_name);
	}

	
	public void cdCommand() {

		cd = new Cd(); 
		cd.execute();
		cmd.push("cd");

	}

	
	public void lsCommand() {

		ls = new Ls(); 
		ls.execute();
		cmd.push("ls");
	}
	
	public void dirCommand() {

		dir = new Dir(); 
		cmd.push("dir");
		dir.execute();
	}
	
	public void dirCommand(String dir_name) {

		dir = new Dir(dir_name); 
		dir.execute();
		cmd.push("dir "+ dir_name);
	}
	

	public void mkdirCommand(String dir_name) {

		mkdir = new Mkdir(dir_name); 
		mkdir.execute();
		cmd.push("mkdir "+ dir_name);
	}
	
	public void rmdirCommand(String dir_name) {

		rmdir = new Rmdir(dir_name); 
		rmdir.execute();
		cmd.push("rmkdir "+ dir_name);

	}
	
	
	public void lnCommand(FSElement fs_name, String link_name) {

		ln = new Ln(fs_name, link_name);
		ln.execute();
		cmd.push("ln " + fs_name + " LInk to " + link_name);

	}
	
	public void mvCommand(String dir_name, Directory dest_dir) {

		mv = new Mv(dir_name, dest_dir); 
		mv.execute();
		cmd.push("mv "+ dir_name + " TO "+dest_dir);
	}
	
	public void cpCommand(String dir_name, Directory dest_dir) {

		cp = new Cp(dir_name, dest_dir); 
		cp.execute();
		cmd.push("cp "+ dir_name + " Copy to "+dest_dir);
	}
	
	public void chownCommand(String dir_name) {

		chown = new Chown(dir_name); 
		chown.execute();
		cmd.push("chown "+ dir_name);
	}
	
	public void historyCommand() {
		cmd.push("History");
		history = new History(cmd);
		history.execute();
	}
	
	
	public void redoCommand() {

		redo = new Redo(cmd);
		redo.execute();
		cmd.push("redo");
	}
	
	public void sortCommand(String policy) {

		sort = new Sort(policy); 
		sort.execute();
		cmd.push("Sort "+ policy);
	}

}
