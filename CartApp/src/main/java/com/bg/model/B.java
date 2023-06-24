package com.bg.model;

import java.util.ArrayList;

public class B extends A{
private String b;

@Override
public String toString() {
	return "B [b=" + b + ", getB()=" + getB() + ", getId()=" + getId() + ", getClass()=" + getClass() + ", hashCode()="
			+ hashCode() + ", toString()=" + super.toString() + "]";
}

public String getB() {
	return b;
}

public void setB(String b) {
	this.b = b;
}

public static void main(String args[])
{
	B b = new B();
	b.setId(10);
	ArrayList <B> bl = new ArrayList<B>();
	bl.add(b);
	B b1 = new B();
	b1.setId(10);
	System.out.println(bl);
	if(bl.contains(b1))
	{
		System.out.println("Exist");
	}
	else
	{ System.out.println("no");
	}
	b.setB("hi");
	System.out.println(b.getId());
	System.out.println(b);
}
}
