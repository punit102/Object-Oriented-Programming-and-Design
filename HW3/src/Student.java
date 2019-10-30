
public class Student {
	private float tuition;
	private String name;
	private StudentStatus status;

	Student(StudentStatus status, String name) {
		this.name = name;
		this.status = status;
	}

	public float getTuition() {
		tuition = status.getTuition();
		return tuition;
	}

	public String getName() {
		return name;
	}
}
