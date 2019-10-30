package edu.umb.cs.cs680;

public class Redo implements Command {

	private CommandHistory cmd;
	
	public Redo(CommandHistory cmd) {
		this.cmd = cmd;
	}

	@Override
	public void execute() {
		
		cmd.pop();	
	}

}
