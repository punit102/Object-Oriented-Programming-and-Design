package edu.umb.cs.cs680;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Test;

public class DirectoryTest {

	
	// This is rootDir getSize() method tesing
	
	@Test
	public void testGetSize() {
		
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
		File d = new File(home, "d:File.txt", "Punit", 10);
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
		
		
		FileSystem.getInstance().showAllElements();
		CountingVisitor visitor1 = new CountingVisitor();
		FileSystem.getInstance().getCountingVisitor(rootDir, visitor1);
		
		
		SizeCountingVisitor visitor2 = new SizeCountingVisitor();
		FileSystem.getInstance().getSizeCountingVisitor(rootDir, visitor2);
		
		
		FileSearchVisitor visitor3 = new FileSearchVisitor(".txt");
		FileSystem.getInstance().getFileSearchVisitor(rootDir, visitor3);
	
		
		// If link refers to the another directory
		System.out.println("x Links to file system:Directory So x link Size is : " + x.getTargetSize());
		// If link refers to the another file
		System.out.println("y Links to file e:File So y Link Size is : " + y.getTargetSize());
		
		int expected = 50;
		int actual = rootDir.getSize();
		assertThat(actual, is(expected));

	}
	
	
	
	// This is getChildren() testing of any directory file
	
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
