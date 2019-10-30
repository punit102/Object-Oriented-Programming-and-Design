package edu.umb.cs.cs680;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PwdTest {

	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
		System.setErr(null);
	}
	
	
	// This is Pwd Command execute() testing --- test its given void method result
	
	@Test
	public void testPwdExecute() {
		
		Directory rootDir = new Directory(null, "root:Directory", "Punit", 0);
		Directory system = new Directory(rootDir, "system:Directory", "Punit", 0);
		Directory home = new Directory(rootDir, "home:Directory", "Punit", 0);
		rootDir.appendChild(system);
		rootDir.appendChild(home);

		File a = new File(system, "a:File.txt", "Punit", 5);
		File b = new File(system, "b:File.txt", "Punit", 5);
		File c = new File(system, "c:File.txt", "Punit", 10);

		system.appendChild(a);
		system.appendChild(b);
		system.appendChild(c);
		File d = new File(home, "d:File.exe", "Punit", 10);
		Link x = new Link(home, "x:Link", "Punit", 0, system);
		home.appendChild(d);
		home.appendChild(x);

		Directory pictures = new Directory(home, "pictures:Directory", "Punit", 0);
		home.appendChild(pictures);

		File e = new File(pictures, "e:File.txt", "Punit", 10);
		Link y = new Link(home, "y:Link", "Punit", 0, e);
		File f = new File(pictures, "f:File.txt", "Punit", 10);
		pictures.appendChild(y);
		pictures.appendChild(e);
		pictures.appendChild(f);
		
		
		
		FileSystem.getInstance().setRoot(rootDir);
		FileSystem.getInstance().getRoot();
		FileSystem.getInstance().setCurrent(rootDir);
		FileSystem.getInstance().getCurrent();

		System.out.print("Command Prompt start : " + FileSystem.getInstance().getRoot().toString());
		System.out.print("\n");
		System.out.print("Initial Working Directory: " + FileSystem.getInstance().getCurrent().toString());
		System.out.print("\n");
		
		Shell shell_command = new Shell();

		shell_command.cdCommand(system.toString());
		shell_command.pwdCommand();
		
		String expected = "Command Prompt start : root:Directory\nInitial Working Directory: root:Directory\nYou move to the this Directory :system:Directory\nCurrent Working Directory in Pwd Command: system:Directory\n";
		String actual = outContent.toString();
		assertThat(actual, is(expected));
	}

}
