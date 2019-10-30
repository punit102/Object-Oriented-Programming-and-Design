package edu.umb.cs.cs680;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;

public class FIFO implements CacheReplacementPolicy {

	private static FIFO instance;

	private FIFO() {
	}

	public static FIFO getInstance() {
		if (instance == null) {
			instance = new FIFO();
		}
		return instance;
	}

	@Override
	public void replace(HashMap<Integer, File> cache, File file) {
		
		int maxKey = Collections.max(cache.keySet());
		int minKey = Collections.min(cache.keySet());
		cache.remove(minKey);
		cache.put(++maxKey, file);
	}

}
