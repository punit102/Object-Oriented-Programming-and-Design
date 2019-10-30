package edu.umb.cs.cs680;

import java.io.File;
import java.util.HashMap;

public class NullReplacement implements CacheReplacementPolicy {

	private static NullReplacement instance = null;

	private NullReplacement() {
		System.out.println("By dafault setting NullReplacementPolicy is going to set and it deosn't do caching");
	}

	public static NullReplacement getInstance() {
		if (instance == null) {
			instance = new NullReplacement();
		}
		return instance;
	}

	@Override
	public void replace(HashMap<Integer, File> cache, File file) {
		
}

}
