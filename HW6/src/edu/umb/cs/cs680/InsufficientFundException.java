package edu.umb.cs.cs680;

@SuppressWarnings("serial")
public class InsufficientFundException extends Exception {

	InsufficientFundException() {
		System.out.println("Insufficient fund avaliable in your Account");
	}

}
