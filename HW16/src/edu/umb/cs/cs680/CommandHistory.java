package edu.umb.cs.cs680;

import java.util.Stack;

public class CommandHistory {

	private Stack<String> commandHis;
	public CommandHistory()	{
		commandHis = new Stack<String>();
		
	}
	public void push(String cmd)
	{
		commandHis.push(cmd);
	}
	
	
	public Stack<String> getCommandHistory(){
		return commandHis;
	}
	
	public void pop()
	{
		System.out.print("Most recetly executed Command:"+commandHis.pop()+"\n");
	}
}
