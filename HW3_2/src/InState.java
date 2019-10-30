
public class InState extends StudentStatus {
	
	private float tuition;
	
	InState(float tuition) {
		System.out.println("You are INSTATE Student");
		this.tuition=tuition;
	}
	
	@Override
	public float getTuition() {
		return tuition;
	}
}
