package edu.umb.cs.cs680;

public class CountingVisitor implements FSVisitor {

	private int dirNum, fileNum, linkNum = 0;

	@Override
	public void visit(Link link) {
		linkNum++;
		linkNum = linkNum++;
	}

	@Override
	public void visit(Directory dir) {
		dirNum++;
		dirNum = dirNum++;
	}

	@Override
	public void visit(File file) {
		fileNum++;
		fileNum = fileNum++;
	
	}
	public int getDirNum()
	{
		return dirNum;
	}
	
	public int getLinkNum()
	{
		return linkNum;
	}
	
	public int getFileNum()
	{
		return fileNum;
	}	
	
}
