package edu.umb.cs.cs680;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import org.junit.Test;

public class FileCacheTest {

	/*
	 * This is just first time FileCache testing method when there are no files
	 * into the cache memory so it simply add and get back its content
	 */

	@Test
	public void testFetch_AddNewCacheFiles() throws FileNotFoundException {

		FileCache fileCache = FileCache.getInstance();
		fileCache.setReplacementPolicy(FIFO.getInstance());
		System.out.println("Inside the code I set HashMap size 4 So from the 5th element it is going to start FIFO implementation if new element will come");
		String expected = "This is File a.txt content.";
		String actual = fileCache.fetch("a.txt");
		assertThat(actual, is(expected));
	}

	/*
	 * This is FileCache testing method when fetch file is already into the
	 * cache memory and it simply gives back its content
	 */
	@Test
	public void testFetch_GiveCacheFileContent() throws FileNotFoundException {

		FileCache fileCache = FileCache.getInstance();
		fileCache.setReplacementPolicy(FIFO.getInstance());
		fileCache.fetch("a.txt");
		fileCache.fetch("b.txt");
		fileCache.fetch("c.txt");
		fileCache.fetch("d.txt");

		String expected = "This is File d.txt content.";
		String actual = fileCache.fetch("d.txt");
		assertThat(actual, is(expected));
	}

	/*
	 * This is FileCache fetch file method testing when some files into the
	 * cache memory and moreover size of cache is also full so FIFO will take
	 * place, add new file into cache and gives back that content
	 */
	@Test
	public void testFetch_FIFOandcaheFileContent() throws FileNotFoundException {

		FileCache fileCache = FileCache.getInstance();
		fileCache.setReplacementPolicy(FIFO.getInstance());
		fileCache.fetch("a.txt");
		fileCache.fetch("b.txt");
		fileCache.fetch("c.txt");
		fileCache.fetch("d.txt");
		fileCache.fetch("e.txt");

		String expected = "This is File e.txt content.";
		String actual = fileCache.fetch("e.txt");
		assertThat(actual, is(expected));
	}
	
	// This is testing method of NullReplecementPolicy and this policy set to by default at the beginning
	
	@Test
	public void testNullReplacementPolicy() throws FileNotFoundException {

		FileCache fileCache = FileCache.getInstance();
		fileCache.setReplacementPolicy(NullReplacement.getInstance());
		CacheReplacementPolicy actual= fileCache.getReplacementPolicy();
		CacheReplacementPolicy expected= NullReplacement.getInstance();
		assertThat(actual, is(expected));
	}
	
	
	// This is fetch method testing when by default NullRaplacement policy is set and after that new FIFO policy is not going to set 
	
	@Test
	public void testFetch_NullReplacementandcaheFileContent() throws FileNotFoundException {

		FileCache fileCache = FileCache.getInstance();
		fileCache.fetch("a.txt");
		fileCache.fetch("b.txt");
		fileCache.fetch("c.txt");
		fileCache.fetch("d.txt");
		fileCache.fetch("e.txt");

		String expected = "This is File a.txt content.";
		String actual = fileCache.fetch("a.txt");
		assertThat(actual, is(expected));
	}
	
	
	

}
