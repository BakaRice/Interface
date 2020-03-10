package com.example16.objectclass;

public class Person extends BaseAbstract {
	public Person(String name) {
		super(name);
	}
	@Override
	public void move() {
		System.out.println(getName() +
				" move as a person");
	}

}
