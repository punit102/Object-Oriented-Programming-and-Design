package edu.umb.cs.cs680;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class LinkTest {

	
	// This is Link class itself link getSize 
	
	
	
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
		int expected = 0;
		int actual = y.getSize();
		assertThat(actual, is(expected));
		
	}

	// This is Link class targeted link getSize testing method
	 
	@Test
	public void testGetTargetSize() {
	
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

		int expected = 20;
		int actual =  x.getTargetSize();
		assertThat(actual, is(expected));
		
	}

}
