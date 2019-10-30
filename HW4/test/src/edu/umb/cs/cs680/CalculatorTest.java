package edu.umb.cs.cs680;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class CalculatorTest {

	@Test
	public void multiply3By4() {

		Calculator cut = new Calculator();
		float expected = 12;
		float actual = cut.multiply(3, 4);
		assertThat(actual, is(expected));
	}

	@Test
	public void divide3By2() {

		Calculator cut = new Calculator();
		float expected = 1.5f;
		float actual = cut.divide(3, 2);
		assertThat(actual, is(expected));
	}

	@Test(expected = IllegalArgumentException.class)
	public void divide5By0() {
		Calculator cut = new Calculator();
		cut.divide(5, 0);
	}

	@Test
	public void multiply2_5By5_5() {

		Calculator cut = new Calculator();
		float expected = 30.25f;
		float actual = cut.multiply(5.5f, 5.5f);
		assertThat(actual, is(expected));
	}

	@Test
	public void multiply1_5By1_5() {

		Calculator cut = new Calculator();
		float expected = 2.25f;
		float actual = cut.multiply(1.5f, 1.5f);
		assertThat(actual, is(expected));
	}

	@Test
	public void divide4_5By1_5() {

		Calculator cut = new Calculator();
		float expected = 3.0f;
		float actual = cut.divide(4.5f, 1.5f);
		assertThat(actual, is(expected));
	}

	@Test
	public void divide1_5By3_0() {

		Calculator cut = new Calculator();
		float expected = 0.5f;
		float actual = cut.divide(1.5f, 3.0f);
		assertThat(actual, is(expected));
	}

}
