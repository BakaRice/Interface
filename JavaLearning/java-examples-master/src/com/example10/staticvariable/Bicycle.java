package com.example10.staticvariable;

public class Bicycle {
	public static final String COMPANY = "Oracle";
	private static int amount = 0;
	public Bicycle() {
		amount++;
		System.out.println("Bicycle()");
	}
	static {
		System.out.println("Bicycle static block");
	}
	private int gear;
	public static int getAmount() {
		return amount;
	}
	public int getGear() {
		return gear;
	}
	public void setGear(int gear) {
		this.gear = gear;
	}

}
