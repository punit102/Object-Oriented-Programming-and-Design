package edu.umb.cs.cs680;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class DirectoryTest {

	// This is testing of rootDir getSize method --- which test rootDir total size 
	@Test
	public void testGetSize() {
		Directory rootDir = new Directory(null, "root:Directory", "Punit", 0);
		Directory system = new Directory(rootDir, "system:Directory", "Punit", 0);
		Directory home = new Directory(rootDir, "home:Directory", "Punit", 0);
		rootDir.appendChild(system);
		rootDir.appendChild(home);

		File a = new File(system, "a:File", "Punit", 5);
		File b = new File(system, "b:File", "Punit", 5);
		File c = new File(system, "c:File", "Punit", 10);

		system.appendChild(a);
		system.appendChild(b);
		system.appendChild(c);
		File d = new File(home, "d:File", "Punit", 10);
		Link x = new Link(home, "x:Link", "Punit", 0, system);
		home.appendChild(d);
		home.appendChild(x);

		Directory pictures = new Directory(home, "pictures:Directory", "Punit", 0);
		home.appendChild(pictures);

		File e = new File(pictures, "e:File", "Punit", 10);
		Link y = new Link(home, "y:Link", "Punit", 0, e);
		File f = new File(pictures, "f:File", "Punit", 10);
		pictures.appendChild(y);
		pictures.appendChild(e);
		pictures.appendChild(f);

		FileSystem.getInstance(rootDir).showAllElements();
	
		System.out.println("X:Link Size:" + x.getSize());
		System.out.println("Y:Link Size:" + y.getSize());
		System.out.println("Total Size of root: Directory:" + rootDir.getSize());

		// If link refers to the another directory
		System.out.println("x Links to file system:Directory So x link Size is : " + x.getTargetSize());
		// If link refers to the another file
		System.out.println("y Links to file e:File So y Link Size is : " + y.getTargetSize());
		
		int expected = 50;
		int actual = rootDir.getSize();
		assertThat(actual, is(expected));

	}
	
	// This is getChildren method testing
	
	@Test
	public void testGetChildren() {
	
		Directory pictures = new Directory(null, "pictures:Directory", "Puna", 0);
		File e = new File(pictures, "e:File", "Puna", 10);
		File f = new File(pictures, "f:File", "Punit", 10);
		pictures.appendChild(e);
		pictures.appendChild(f);	
		ArrayList<FSElement> expected = new ArrayList<>();
		expected.add(e);
		expected.add(f);
		ArrayList<FSElement> actual = pictures.getChildren();
		assertThat(actual, is(expected));

	}

}
