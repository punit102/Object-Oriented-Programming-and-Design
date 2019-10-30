package edu.umb.cs.cs680;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class FSVisitorTest {

	
	
	
	// This is testing coutingVisitor --- Number of files
		@Test
		public void testCountingVisitor_NoOfFile() {
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
			
			CountingVisitor visitor = new CountingVisitor();
			rootDir.accept(visitor);
			System.out.println("Number of Files : " + visitor.getFileNum());
			
			int expected = 6;
			int actual = visitor.getFileNum();
			assertThat(actual, is(expected));	
		}
		
		// This is testing coutingVisitor --- Number of Directories
			@Test
			public void testCountingVisitor_NoOfDirectory() {
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
				
				CountingVisitor visitor = new CountingVisitor();
				rootDir.accept(visitor);
				System.out.println("Number of Directories : " + visitor.getDirNum());
				
				int expected = 4;
				int actual = visitor.getDirNum();
				assertThat(actual, is(expected));	
			}
		
			
			// This is testing coutingVisitor --- Number of Links
					@Test
					public void testCountingVisitor_NoOfLink() {
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
						
						CountingVisitor visitor = new CountingVisitor();
						rootDir.accept(visitor);
						System.out.println("Number of Links : " + visitor.getLinkNum());
						
						int expected = 2;
						int actual = visitor.getLinkNum();
						assertThat(actual, is(expected));	
					}
					
					
			// testing total size of rootDir ---- by calling SizeCountingVisitor
					
					@Test
					public void testSizeCountingVisitor_TotalSize() {
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
						
						SizeCountingVisitor visitor1 = new SizeCountingVisitor();
						rootDir.accept(visitor1);
						
						System.out.println("Total Disk Space: " +visitor1.getTotalSize());
						
						int expected = 50;
						int actual = visitor1.getTotalSize();
						assertThat(actual, is(expected));	
					}	
					
				// This is given FileSearchVisitor testing
					
					
					@Test
					public void testFileSearchVisitor_FoundFiles() {
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
						
						FileSearchVisitor visitor2 = new FileSearchVisitor(".txt");
						rootDir.accept(visitor2);
						
						System.out.println("Founfiles of " + visitor2.getExtention() +" extention is : " + visitor2.getFoundFilesSize());
						
						int expected = 6;
						int actual = visitor2.getFoundFilesSize();
						assertThat(actual, is(expected));	
					}

}
