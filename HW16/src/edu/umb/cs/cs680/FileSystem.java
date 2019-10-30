package edu.umb.cs.cs680;

import java.util.ArrayList;
import java.util.Comparator;

public class FileSystem {

	private static FileSystem instance;
	private Directory root_dir;
	private Directory current_dir;

	private FileSystem() {

	}

	public void showAllElements() {
		FileSystem.getInstance().getCurrent().printName();
	}

	public void setRoot(Directory root) {
		this.root_dir = root;
	}

	public Directory getRoot() {
		return root_dir;
	}

	public void setCurrent(Directory current_dir) {
		this.current_dir = current_dir;
	}

	public Directory getCurrent() {
		return current_dir;
	}

	public void addChild(Directory current_dir, FSElement child) {
		
		current_dir.addChild(child, getInsertionLocation(current_dir, child));
	}

	public void removeChild(Directory current_dir, FSElement child) {
	
		current_dir.removeChild(child);
	}

	public ArrayList<FSElement> getChildren(Directory current_dir) {
		return getChildren(current_dir);
	}

	public static FileSystem getInstance() {
		if (instance == null) {
			instance = new FileSystem();
		}
		return instance;
	}

	public void getCountingVisitor(Directory dir, CountingVisitor cv) {

		dir.accept(cv);
		System.out.println("Directory number:" + cv.getDirNum());
		System.out.println("File number : " + cv.getFileNum());
		System.out.println("Link number : " + cv.getLinkNum());
		
	}

	public void getSizeCountingVisitor(Directory dir, SizeCountingVisitor cv) {
		dir.accept(cv);
		System.out.println("Total Disk Space: " + cv.getTotalSize());

	}

	public void getFileSearchVisitor(Directory dir, FileSearchVisitor cv) {
		dir.accept(cv);
		System.out.println("Founfiles of " + cv.getExtention() + " extention is : " + cv.getFoundFilesSize());

	}

	public void sort(Directory dir, Comparator<FSElement> f) {
		
		dir.getChildren().sort(f);
	}

	public int getInsertionLocation(Directory dir, FSElement fs) {

		for (int i = 0; i < dir.getChildren().size(); i++) {
			if (dir.getChildren().get(i).getName().compareToIgnoreCase(fs.getName()) == 0) {
				return -10;
			}
			if (dir.getChildren().get(i).getName().compareToIgnoreCase(fs.getName()) > 0) {
				return i;
			}
		}
		return dir.getChildren().size();
	}

}
