package edu.umb.cs.cs680;

import java.util.ArrayList;

public class FileSearchVisitor implements FSVisitor {

	private String extention;
	private ArrayList<File> foundFiles;

	public FileSearchVisitor(String extention) {
		this.extention = extention;
		foundFiles = new ArrayList<File>();
	}

	public void visit(Link link) {
	}

	@Override
	public void visit(Directory dir) {
	}

	@Override
	public void visit(File file) {

		if (file.getName().contains(extention)) {
			foundFiles.add(file);
		}

	}

	public String getExtention()
	{
		return extention;
	}
	
	public int getFoundFilesSize() {
		return getFoundFiles().size();

	}

	public ArrayList<File> getFoundFiles() {
		return foundFiles;
	}

}
