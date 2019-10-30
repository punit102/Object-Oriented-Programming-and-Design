package edu.umb.cs.cs680;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

abstract class FileCache {

	private HashMap<String, File> cache = new LinkedHashMap<String, File>();
	private ArrayList<String> cacheFiles = new ArrayList<String>();
	private final int size = 4;
	private String fileContent;
	private Scanner scanner;


	public String fetch(String targetFile) throws FileNotFoundException {

		if (cacheFiles.contains(targetFile)) {
			scanner = new Scanner(new File(targetFile));
			while (scanner.hasNextLine()) {
				fileContent = scanner.nextLine();
				System.out.println("File already in cache memory and its content is: " + fileContent);
			}

		} else {
			if (cache.size() < size) {
				cacheFiles.add(targetFile);
				cacheFile(targetFile);
				scanner =  new Scanner(new File(targetFile));
				while (scanner.hasNextLine()) {
					fileContent = scanner.nextLine();
				}
				System.out.println("File added into Cache and its content : " + fileContent);
			} else {

				cacheFiles.remove(0);
				replace(targetFile);
				cacheFiles.add(targetFile);

				scanner =  new Scanner(new File(targetFile));
				while (scanner.hasNextLine()) {
					fileContent = scanner.nextLine();
					System.out.println("FIFO take place and its content is: " + fileContent);
				
				} 

			}
		}
		return fileContent;

	}

		private void cacheFile(String targetFile)
		{
			this.cache.put(targetFile,new File(targetFile));
		}
	

	abstract protected void replace(String targetFile);
	
	public HashMap<String, File> getCache() {
		return cache;
	}

}
