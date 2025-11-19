package ch06.sec13.exam02.package1;

public class B {
	A a1 = new A(true); //ok
	A a2 = new A(1); //ok
	A a3 = new A("문자열"); //not
}
