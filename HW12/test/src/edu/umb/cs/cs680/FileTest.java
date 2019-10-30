package edu.umb.cs.cs680;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class FileTest {

	
	// This is isFile method testing 
	// I put also show rootDir tree Structure here and also call rootDir -> getSize() and printed here
	
	@Test
	public void testPrintName() {
		
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
		System.out.println("This is rootDir Tree Structure by calling showAllElements method");
		FileSystem.getInstance(rootDir).showAllElements();
		
		System.out.println("rootDir Total Size by calling getSize method:"+rootDir.getSize());

		boolean expected = true;
		boolean actual = a.isFile();
		assertThat(actual, is(expected));

	}

}
