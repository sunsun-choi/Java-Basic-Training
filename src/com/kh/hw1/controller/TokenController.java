package com.kh.hw1.controller;

public class TokenController {//클래스영역시작

	//컨트롤러클래스 (작동을 어떤식으로 구분해서 지정해줬는지 확인)
	/*
	+afterToken(str:String):String
	+firstCap(input:String):String
	+findChar(input:String, one:char):int
	*/
	
	//공백을 토큰으로 처리 한글자 반환
	public String afterToken(String str) {
		/*
		str = str.trim();    //틀림
		*/
		
		str = str.replace(" ","");
		
		return str;
	}
	
	//매개변수로 받은 문자열의 첫 번째 글자를 대문자로 바꾼 문자열 반환
	public String firstCap(String input) {
		/*
		String a = input.charAt(0)+"";
		a = a.toUpperCase();
		------> 더 간략하게 다시만들자
		*/
		
		String a = input.substring(0,1).toUpperCase();
		input = a + input.substring(1);
			return input;
		}
	
	//매개변수로 받은 문자열 중에서 매개변수로 들어온 문자가 몇 개 존재하는지 개수를 반환
	public int findChar(String input, char one) {
		/*
		int count = 0;
		while(input.contains(one+"")) {
			count++;
		}
		---------------------> 항상 true 라서 오류.... 
		-------> 일단 char 배열로 다 저장 후 비교해서 add 해야겠다
		*/
		//// 기본자료형은 == 을 사용해서 비교!
		/// 참조자료형은 .equals 처럼 메소드를 사용해서 비교!

		int count = 0;
		char[] arr = input.toCharArray();
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == one) {count ++;}
		}
		
		return count;
	}
	
}//클래스영역끝
