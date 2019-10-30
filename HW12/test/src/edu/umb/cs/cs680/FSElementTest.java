package edu.umb.cs.cs680;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FSElementTest {

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

	// This is FSElement unit testing so I tested every unit of File Class
	// This is getParent() method unit testing

	@Test
	public void testGetParent() {
		Directory rootDir = new Directory(null, "root:Directory", "Punit", 0);
		Directory home = new Directory(rootDir, "home:Directory", "Punit", 0);
		Directory expected = rootDir;
		Directory actual = home.getParent();
		assertThat(actual, is(expected));
	}
	
	// This is getSize() method unit testing 
	
	@Test
	public void testGetSize() {
		Directory rootDir = new Directory(null, "root:Directory", "Punit", 0);
		Directory home = new Directory(rootDir, "home:Directory", "Punit", 0);
		int expected = 0;
		int actual = home.getSize();
		assertThat(actual, is(expected));
	}
	
	// This is getName() method unit testing
	
	
	@Test
	public void testGetName() {
		Directory rootDir = new Directory(null, "root:Directory", "Punit", 0);
		Directory home = new Directory(rootDir, "home:Directory", "Punit", 0);
		String expected = "home:Directory";
		String actual = home.getName();
		assertThat(actual, is(expected));

	}

	// This is getOwner() method unit testing
	
	@Test
	public void testGetOwner() {
		Directory rootDir = new Directory(null, "root:Directory", "Punit", 0);
		Directory home = new Directory(rootDir, "home:Directory", "Punit", 0);
		String expected = "Punit";
		String actual = home.getOwner();
		assertThat(actual, is(expected));
	}

	// This is ToSting() method unit testing
	
	@Test
	public void testToString() {
		Directory rootDir = new Directory(null, "root:Directory", "Punit", 0);
		Directory home = new Directory(rootDir, "home:Directory", "Punit", 0);
		String expected = "home:Directory";
		String actual = home.toString();
		assertThat(actual, is(expected));
	}

	// This is printName() method unit testing
	
	@Test
	public void testprintName() {

		FSElement fse = new FSElement(null, null, null, 0);
		fse.printName();
		String expected = "";
		String actual = outContent.toString();
		assertThat(actual, is(expected));

	}

}
