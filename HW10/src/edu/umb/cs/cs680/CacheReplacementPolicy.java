package edu.umb.cs.cs680;

import java.io.File;
import java.util.HashMap;

public interface CacheReplacementPolicy {

	void replace(HashMap<Integer, File> cache, File file);
}
