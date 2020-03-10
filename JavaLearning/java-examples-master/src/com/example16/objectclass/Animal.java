package com.example16.objectclass;

public class Animal extends BaseAbstract{
	public Animal(String name) {
		super(name);
	}
	@Override
	public void move() {
		System.out.println(getName() + 
				" move as an animal");
	}

}
