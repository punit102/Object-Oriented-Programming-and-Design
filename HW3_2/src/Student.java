public class Student {

	private String name;
	private StudentStatus status;
	
	Student(StudentStatus status, String name)
	{
		this.status = status;
		this.name = name;
	}
	public float getTuition()
	{
		return status.getTuition();
	}
	public String getName()
	{
		return name;
	}
	 
}
