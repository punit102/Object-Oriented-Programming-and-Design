package edu.umb.cs.cs680;

public class Car {

	private int price;
	private int year;
	private int mileage;

	Car(int price, int year, int mileage) {
		this.price = price;
		this.year = year;
		this.mileage = mileage;
	}

	public int getPrice() {
		return this.price;
	}

	public int getYear() {
		return this.year;
	}

	public int getMileage() {
		return this.mileage;
	}

}
