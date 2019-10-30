package edu.umb.cs.cs680;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class DirectoryGetSizeTest {

	
	
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
