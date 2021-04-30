package com.restassured.udemy.addApi;

import java.awt.DisplayMode;

import core.javaExample.Imohammad;

abstract public  class InheritExample extends DEF implements Imohammad  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
DEF d1 = new DEF();
d1.display();
d1.msg();
d1.show();
toTHeTeam tm = new toTHeTeam();
//tm.nameDisplay();

ABC a1 = new DEF(); // run time polymorphysim upcasting 
//WebDriver driver = new FireFoxDriver();

	}
//	public void nameDisplay() {
//		System.out.println("Name Testing");
//		
//	}

	
	

}
 final class toTHeTeam extends InheritExample {
	
	
	public void nameDisplay() {
		System.out.println("Name Testing");
		
	}
}

