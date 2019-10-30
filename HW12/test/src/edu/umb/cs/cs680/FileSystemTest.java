package edu.umb.cs.cs680;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FileSystemTest {
	
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
	
	
	// This is tesing of showAllElements method and also written tree structure 
	// For doing this testing I used void method testing
	
	@Test
	public void testShowAllElements() {
		Directory rootDir = new Directory(null, "root:Directory", "Punit", 0);
		Directory system = new Directory(rootDir, "system:Directory", "Punit", 0);
		Directory home = new Directory(rootDir, "home:Directory", "Punit", 0);
		rootDir.appendChild(system);
		rootDir.appendChild(home);

		File a = new File(system, "a:File", "Punit", 5);
		File b = new File(system, "b:File", "Punit", 5);
		File c = new File(system, "c:File", "Puna", 10);

		system.appendChild(a);
		system.appendChild(b);
		system.appendChild(c);
		File d = new File(home, "d:File", "Punit", 10);
		home.appendChild(d);

		Directory pictures = new Directory(home, "pictures:Directory", "Puna", 0);
		home.appendChild(pictures);

		File e = new File(pictures, "e:File", "Puna", 10);
		File f = new File(pictures, "f:File", "Punit", 10);
		pictures.appendChild(e);
		pictures.appendChild(f);
		
		FileSystem.getInstance(rootDir).showAllElements();
		String expected = " Directory:- root:Directory  Parent :null\n Directory:- system:Directory  Parent :root:Directory\n       File:-a:File  Parent : system:Directory\n       File:-b:File  Parent : system:Directory\n       File:-c:File  Parent : system:Directory\n Directory:- home:Directory  Parent :root:Directory\n       File:-d:File  Parent : home:Directory\n Directory:- pictures:Directory  Parent :home:Directory\n       File:-e:File  Parent : pictures:Directory\n       File:-f:File  Parent : pictures:Directory\n";
		String actual = outContent.toString();
		assertThat(actual, is(expected));
		
	}

}
