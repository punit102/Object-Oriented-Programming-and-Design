package edu.umb.cs.cs680;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class AccountTest {

	@Test
	public void testGetBalance() {
		SavingsAccount ac = new SavingsAccount(500.00f);
		CheckingAccount ca = new CheckingAccount(100.00f, ac);
		Account a = new Account(ac, ca);
		float expected = 600.00f;
		float actual = a.getBalance();
		assertThat(actual, is(expected));
	}

	@Test
	public void testDeposit() {
		SavingsAccount ac = new SavingsAccount(500.00f);
		CheckingAccount ca = new CheckingAccount(100.00f, ac);
		Account a = new Account(ac, ca);
		a.deposit(100.00f);
		float expected = 700.00f;
		float actual = a.deposit(100.00f);
		assertThat(actual, is(expected));
	}

	@Test
	public void testWithdraw() throws InsufficientFundException {
		SavingsAccount ac = new SavingsAccount(500.00f);
		CheckingAccount ca = new CheckingAccount(100.00f, ac);
		Account a = new Account(ac, ca);
		float expected = 0.0f;
		float actual = a.withdraw(0.00f);
		assertThat(actual, is(expected));
	}

}
