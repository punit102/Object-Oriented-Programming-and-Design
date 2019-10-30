package edu.umb.cs.cs680;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

public class FileCacheTest {

	/*
	 * This is just first time FileCache fetch method testing when there are no
	 * files into the cache memory so it simply add and get back its content
	 */
	@Test
	public void testFetch_AddNewCacheFiles() throws FileNotFoundException {

		FIFOFileCache fifoFileCache = FIFOFileCache.getInstance();
		System.out.println("Inside the code I set HashMap size 4 So from the 5th element it is going to start FIFO implementation if new element will come");
		String expected = "This is File a.txt content.";
		String actual = fifoFileCache.fetch("a.txt");
		assertThat(actual, is(expected));
	}

	/*
	 * This is FileCache testing method when fetch file is already into the
	 * cache memory and it simply gives back its content
	 */
	@Test
	public void testFetch_GiveCacheFileContent() throws FileNotFoundException {

		FIFOFileCache fifoFileCache = FIFOFileCache.getInstance();
		fifoFileCache.fetch("a.txt");
		fifoFileCache.fetch("b.txt");
		fifoFileCache.fetch("c.txt");
		fifoFileCache.fetch("d.txt");
		String expected = "This is File b.txt content.";
		String actual = fifoFileCache.fetch("b.txt");
		assertThat(actual, is(expected));
	}

	/*
	 * This is FileCache fetch file method testing when some files into the
	 * cache memory and moreover size of cache is also full so FIFO will take
	 * place, add new file into cache and gives back that content
	 */
	@Test
	public void testFetch_FIFOandcaheFileContent() throws FileNotFoundException {

		FIFOFileCache fifoFileCache = FIFOFileCache.getInstance();
		fifoFileCache.fetch("a.txt");
		fifoFileCache.fetch("b.txt");
		fifoFileCache.fetch("c.txt");
		fifoFileCache.fetch("d.txt");
		String expected = "This is File e.txt content.";
		String actual = fifoFileCache.fetch("e.txt");
		assertThat(actual, is(expected));
	}

}
