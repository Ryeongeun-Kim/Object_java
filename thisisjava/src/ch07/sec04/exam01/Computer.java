package ch07.sec04.exam01;

public class Computer extends Calculator {
	
	@Override //컴파일 시 정확히 오버라이팅이 되었는지 체크 해줌
	public double areaCircle(double r) {
		System.out.println("Computer 객체의 areaCircle()실행");
		return Math.PI*r*r;
	}
}
