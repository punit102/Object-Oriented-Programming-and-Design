package edu.umb.cs.cs680;

import java.util.Stack;

public class History implements Command {

	private CommandHistory cmd;

	public History(CommandHistory cmd2) {
		this.cmd = cmd2;
	}

	public void execute() {

		
		Stack<String> cmdSequence = cmd.getCommandHistory();
		for(String s:cmdSequence)
		{
			System.out.print(s+"\n");
		}
	}

}
