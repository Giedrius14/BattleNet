package com.battle.net.controllers;

class Machine{
	private String name;
	private int code;
	
	public Machine(){
		this("Arnie", 0);
		
		System.out.println(" First");
	}

	public Machine(String name) {
		this(name, 0);
		
		this.name= name;
		System.out.println("Second  "+ name);
	}
	
	public Machine(String name, int code) {
		this.name= name;
		this.code= code;
		System.out.println("Third  "+ name);

	}


}

public class test {

	public static void main(String[] args) {
		Machine machine1 = new Machine();
		
		Machine machine2 = new Machine("Bertie");
		Machine machine3 = new Machine("Dude", 7);

	}

}
