package edu.umb.cs.cs680;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import org.junit.Test;

public class CheckingAccountTest {

	// This is getBalance method of Checking Account
	@Test
	public void testGetBalance() {

		SavingsAccount ac = new SavingsAccount(500.00f);
		CheckingAccount ca = new CheckingAccount(100.00f, ac);
		float expected = 100.00f;
		float actual = ca.getBalance();
		assertThat(actual, is(expected));
	}

	// This is checking deposit method of Checking Account
	@Test
	public void testDeposit() {

		SavingsAccount ac = new SavingsAccount(500.00f);
		CheckingAccount ca = new CheckingAccount(100.00f, ac);
		ca.deposit(200.00f);
		float expected = 300.00f;
		float actual = ca.getBalance();
		assertThat(actual, is(expected));

	}

	// This s withdraw method testing when sufficient fund available in Checking
	// Account
	@Test
	public void testWithdraw() throws InsufficientFundException {

		SavingsAccount ac = new SavingsAccount(500.00f);
		CheckingAccount ca = new CheckingAccount(100.00f, ac);
		ca.withdraw(50.00f);
		float checking_expected = 50.00f;
		float checking_actual = ca.getBalance();
		assertThat(checking_actual, is(checking_expected));
		float saving_expected = 500.00f;
		float saving_actual = ac.getBalance();
		assertThat(saving_actual, is(saving_expected));

	}

	/*
	 * This is withdraw method testing when sufficient fund not available in
	 * Checking account but it will available in Saving Account
	 */
	// In this testing 50$ penalty also cut from the account balance
	@Test
	public void testWithdraw2() throws InsufficientFundException {

		SavingsAccount ac = new SavingsAccount(500.00f);
		CheckingAccount ca = new CheckingAccount(100.00f, ac);
		ca.withdraw(150.00f);
		float checking_expected = 0.00f;
		float checking_actual = ca.getBalance();
		assertThat(checking_actual, is(checking_expected));
		float saving_expected = 400.00f;
		float saving_actual = ac.getBalance();
		assertThat(saving_actual, is(saving_expected));
	}

	/*
	 * This is withdraw method testing when no sufficient funds available in
	 * Checking account as well as Saving account
	 */
	// So this is throws InsufficientFundException Exception
	@Test(expected = InsufficientFundException.class)
	public void withdraw_checking_exception() throws InsufficientFundException {
		SavingsAccount ac = new SavingsAccount(500.00f);
		CheckingAccount ca = new CheckingAccount(100.00f, ac);
		ca.withdraw(650.00f);
	}

}
