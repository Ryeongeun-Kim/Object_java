package ch07.sec06.package2;

import ch07.sec06.package1.A;

public class D extends A {
	public D() {
		super();		//o
	}
	
	public void method() {
		this.field="value";		//o (protected는 상속을 통해서만 가능)
		this.method(); 			//o
	}
	
	public void method2() {
		A a = new A();			//x (protected는 직접 객체 생성해서 사용하는 것은 안됨)
		a.field ="value";		//x
		a.method();				//x
	}
}
