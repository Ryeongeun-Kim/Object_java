package ch06.sec13.exam03.package2;

import ch06.sec13.exam03.package1.A;
public class C {
	public C() {
		A a = new A();
		
		a.field1 = 1; //0
		a.field2 = 1; //X
		a.field3 = 1; //X
		
		a.method1(); //0
		a.method2(); //X
		a.method3(); //X
	}
}
