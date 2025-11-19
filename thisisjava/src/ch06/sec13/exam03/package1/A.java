package ch06.sec13.exam03.package1;

public class A {
	//public 접근제한을 갖는 필드 선업
	public int field1;
	//default
	int field2;
	//private
	private int field3;
	
	public A() {
		field1=1; //ok
		field2=1; //ok
		field3=1; //ok 클래스 내부의 경우 접근제한자 영향 없음
		
		method1();
		method2();
		method3();
	}
	
	public void method1() {} //public
	void method2() {} //default
	private void method3() {} //private
}
