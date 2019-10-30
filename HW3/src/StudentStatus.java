
public enum StudentStatus {
	INSTATE {
		@Override
		public float getTuition() {
			float tuition = 1000;
			return tuition;
		}
	},
	OUTSTATE {
		@Override
		public float getTuition() {

			float tuition = 2000;
			return tuition;
		}

	},
	INTL {
		@Override
		public float getTuition() {
			float tuition = 3000;
			return tuition;
		}
	};

	public float getTuition() {
		return 0;
	}

}
