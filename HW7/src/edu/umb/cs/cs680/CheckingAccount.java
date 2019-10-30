package edu.umb.cs.cs680;

public class CheckingAccount extends Account {

	private float checking_balance;
	private SavingsAccount svc;
	private final float PENALTY = 50;

	public CheckingAccount(float f, SavingsAccount svc) {

		this.checking_balance = f;
		this.svc = svc;
	}

	public float deposit(float d) {
		this.checking_balance = this.checking_balance + d;
		return this.checking_balance;
	}

	public float getBalance() {
		return this.checking_balance;
	}

	public float withdraw(float w) throws InsufficientFundException {
		if (this.getBalance() > w) {
			
			checking_balance = checking_balance - w;
			return checking_balance;
		} else if (svc.getBalance() + this.getBalance() >= w) {

			float temp = w - this.getBalance();
			svc.setBalance((svc.getBalance() - (temp + PENALTY)));
			checking_balance = 0.00f;
			return (svc.getBalance() - (temp + PENALTY));
		} else {
			throw new InsufficientFundException();
		}
	}

}
