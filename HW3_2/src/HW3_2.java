
public class HW3_2 {

	public static void main(String[] args) {

		System.out.println("Alternative Design #2 of HW3");
		Student s1 = new Student(new InState(1000), "Punit Patel");
		System.out.println("Your name is " + s1.getName());
		System.out.println("Your Tuition fee is " + s1.getTuition());
	}

}
