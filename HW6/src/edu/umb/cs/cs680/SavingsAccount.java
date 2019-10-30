package edu.umb.cs.cs680;

public class SavingsAccount extends Account {

	
	private float savings_balance;
	
	public SavingsAccount(float f) {
		this.savings_balance = f;
	}
	
	public float deposit(float d)
	{
		this.savings_balance = this.savings_balance + d;
		return this.savings_balance;
	}
	
	public float getBalance()
	{
		return savings_balance;
	}
	
	public float setBalance(float f){
		this.savings_balance = f;
		return savings_balance;
	}
	
	
	
	public float withdraw(float w) throws InsufficientFundException{
		
		
		if(this.getBalance() > w)
		{
			this.savings_balance = this.savings_balance - w ;
			return this.savings_balance;
		}
		else
		{
			throw new InsufficientFundException();
		}	
		
	}
}
