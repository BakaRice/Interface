package com.example16.objectclass;

public abstract class BaseAbstract {
	private String name;
	public BaseAbstract(String name) {
		this.name = name;
	}
	public void sleep() {
		System.out.println(name + " is sleeping");
	}
	public abstract void move();

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
