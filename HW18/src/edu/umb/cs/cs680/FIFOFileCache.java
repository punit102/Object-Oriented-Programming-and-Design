package edu.umb.cs.cs680;

import java.io.File;

public class FIFOFileCache extends FileCache {
	
	private static FIFOFileCache instance;

	private FIFOFileCache() {
	}

	public static FIFOFileCache getInstance() {
		if (instance == null) {
			instance = new FIFOFileCache();
		}
		return instance;
	}
	
	
	
	protected void replace(String targetFile) {

		String key = super.getCache().keySet().iterator().next();
		this.getCache();
		super.getCache().remove(key);
		super.getCache().put(new File(targetFile).getPath(), new File(targetFile));
	}

}
