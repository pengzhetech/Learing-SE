package com.javaman.classloader;

public class A implements I1 {
	public void testB(){
		B b = new B();
		System.out.println("b is:"+b);
		System.out.println("b classloader is:"+b.getClass().getClassLoader());
		System.out.println("b parentCL is:"+b.getClass().getClassLoader().getParent());
		b.testC();
		D d = new D ();
		System.out.println("a--d is:"+d);
		System.out.println("a--d classloader is:"+d.getClass().getClassLoader());
		System.out.println("a--d parentCL is:"+d.getClass().getClassLoader().getParent());
	}
}