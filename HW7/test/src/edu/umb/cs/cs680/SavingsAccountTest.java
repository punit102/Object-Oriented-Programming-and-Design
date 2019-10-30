package edu.umb.cs.cs680;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class SavingsAccountTest {

	// This is getBalance method of Saving Account
	@Test
	public void testGetBalance() {

		SavingsAccount ac = new SavingsAccount(500.00f);
		float expected = 500.00f;
		float actual = ac.getBalance();
		assertThat(actual, is(expected));

	}

	// This is checking deposit method of Saving Account
	@Test
	public void testDeposit() {
		SavingsAccount ac = new SavingsAccount(500.00f);
		ac.deposit(400.00f);
		float expected = 900.00f;
		float actual = ac.getBalance();
		assertThat(actual, is(expected));

	}

	// This is setBalance of checking account method of Saving Account
	@Test
	public void testSetBalance() {

		SavingsAccount ac = new SavingsAccount(500.00f);
		ac.setBalance(100.00f);
		float expected = 100.00f;
		float actual = ac.getBalance();
		assertThat(actual, is(expected));
	}

	/*
	 * This is withdraw method testing but it will execute when sufficient fund
	 * available in Saving Account
	 */
	@Test
	public void testWithdraw() throws InsufficientFundException {
		SavingsAccount ac = new SavingsAccount(500.00f);
		ac.deposit(300.00f);
		ac.withdraw(400.00f);
		float expected = 400.00f;
		float actual = ac.getBalance();
		assertThat(actual, is(expected));

	}

	/*
	 * This is also withdraw method testing method but this will execute when
	 * sufficient funds is not available and it throws InsufficientFundException
	 * Exception
	 */
	@Test(expected = InsufficientFundException.class)
	public void test_withdraw_exception() throws InsufficientFundException {
		SavingsAccount ac = new SavingsAccount(500.00f);
		ac.withdraw(550.00f);
	}

}
