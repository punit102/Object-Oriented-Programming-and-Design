
public class OutState extends StudentStatus {
	
	private float tuition;	
	OutState(float tuition) {
		System.out.println("You are OUTSTATE Student");
		this.tuition=tuition;
	}
	@Override
	public float getTuition() {
		return tuition;
	}
}