package com.javaman.classloader;

public class B {
	public void testC(){
		C c = new C();
		System.out.println("C.class is:"+C.class.getClassLoader());
		System.out.println("c is:"+c);
		System.out.println("c classloader is:"+c.getClass().getClassLoader());
		System.out.println("c parentCL is:"+c.getClass().getClassLoader().getParent());
		c.testD();
	}
}