package ch06.sec13.exam03.package1;

public class B {
	public void method() {
		A a = new A();
		
		a.field1 = 1; //0
		a.field2 = 1; //0
		a.field3 = 1; //X
		
		a.method1(); //0
		a.method2(); //0
		a.method3(); //X
	}
}
