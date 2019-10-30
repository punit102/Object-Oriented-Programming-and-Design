
public class Intl extends StudentStatus {
	
	private float tuition;	
	Intl(float tuition) {
		System.out.println("You are INTL Student");
		this.tuition=tuition;
	}
	@Override
	public float getTuition() {
		return tuition;
	}

}
