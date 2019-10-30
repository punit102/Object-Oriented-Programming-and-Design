package edu.umb.cs.cs680;

public class Account {

	private float balance;
	private SavingsAccount sa;
	private CheckingAccount ca;
	
	public Account(SavingsAccount ac,CheckingAccount ca) {
		this.sa = ac; 
		this.ca = ca;
	}
	
	Account(){
		
	}

	public float getBalance() {
		
		balance = sa.getBalance() + ca.getBalance();
		return balance;
	}

	public float deposit(float d) {
		this.balance = sa.getBalance() + ca.getBalance() + d;
		return this.balance;
	}

	public float withdraw(float w) throws InsufficientFundException {
		return 0.0f;

	}

}
