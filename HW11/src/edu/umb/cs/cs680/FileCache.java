package edu.umb.cs.cs680;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FileCache {

	private static FileCache instance = null;
	private HashMap<Integer, File> cache = new HashMap<Integer, File>();
	private ArrayList<String> cacheFiles = new ArrayList<String>();
	private CacheReplacementPolicy replacementPolicy;
	private int i = 1;
	private final int size = 4;
	private String fileContent;
	private Scanner scanner;

	public void setReplacementPolicy(CacheReplacementPolicy replacementPolicy) {
		this.replacementPolicy = replacementPolicy;
	}

	private FileCache() {
		this.replacementPolicy = NullReplacement.getInstance();
	}

	public CacheReplacementPolicy getReplacementPolicy() {
		return replacementPolicy;
	}

	public static FileCache getInstance() {
		if (instance == null) {
			instance = new FileCache();
		}
		return instance;
	}

	public int doIncrement() {
		return i++;
	}

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
				cache.put(doIncrement(), new File(targetFile));

				scanner = new Scanner(new File(targetFile));
				while (scanner.hasNextLine()) {
					fileContent = scanner.nextLine();
				}

				System.out.println("File added into Cache and its content : " + fileContent);
			} else {

				cacheFiles.remove(0);
				replace(new File(targetFile));
				cacheFiles.add(targetFile);

				scanner = new Scanner(new File(targetFile));
				while (scanner.hasNextLine()) {
					fileContent = scanner.nextLine();
					System.out.println("FIFO take place and its content is: " + fileContent);
				}

			}

		}

		return fileContent;

	}

	private void replace(File targetFile) {
		replacementPolicy.replace(cache, targetFile);
	}

}
