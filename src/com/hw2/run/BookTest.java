package com.hw2.run;

import com.hw2.model.vo.Book;

public class BookTest {//클래스 영역 시작

	public static void main(String[] args) {//메소드 영역 시작
		
		//기본생성자를 이용한 객체생성
		Book b1 = new Book();
				
		//매개변수생성자를 이용한 객체생성
		Book b2 = new Book("자바의정석", 20000, 0.2, "윤상섭");
		
		//출력 확인
		System.out.println(b1.information());
		System.out.println(b2.information());
		System.out.println("================");
		//setter 를 이용해 값을 수정
		b1.setTitle("DoIt! 자바프로그래밍입문");
		b1.setPrice(25000);
		b1.setDiscountRate(0.1);
		b1.setAuthor("박은종");
		
		//수정된 내용 출력
		System.out.println("수정된 결과 확인");
		System.out.println(b1.information());
		System.out.println("================");

		//할인율을 적용한 책 가격을 출력
		b1.showDiscountTag();
		b2.showDiscountTag();
		
		
	}//메소드 영역 끝

}//클래스 영역 끝
