package ch06.sec13.exam02.package2;

import ch06.sec13.exam02.package1.*;

public class C {
	A a1 = new A(true); //ok
	A a2 = new A(1); //not <- default 생성자 접근 불가
	A a3 = new A("문자열") //X <- private 생성자 접근 불가
}
