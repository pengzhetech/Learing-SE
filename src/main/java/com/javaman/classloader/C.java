package com.javaman.classloader;

public class C {
	public void testD(){
		D d = new D ();
		System.out.println("d is:"+d);
		System.out.println("d classloader is:"+d.getClass().getClassLoader());
		System.out.println("d pc is:"+d.getClass().getClassLoader().getParent());
	}
}