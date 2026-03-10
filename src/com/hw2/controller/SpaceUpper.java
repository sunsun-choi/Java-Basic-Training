package com.hw2.controller;

import java.util.Scanner;
import java.util.StringTokenizer;

public class SpaceUpper {//클래스영역시작

	/*
	+ SpaceUpper()
	+ spaceToUpper() : void
	*/
	
	public SpaceUpper() {}
	
	
	public void spaceToUpper() {
		/*
		 입력 받은 영문을 StringTokenizer을 사용해 띄어쓰기를 기준으로 
		 띄어쓰기 이후 첫 영문을 대문자로 출력하는 메소드
		 */
		// 영문을 입력 받는다. (모두 소문자로 띄어쓰기 포함해서)
		Scanner sc = new Scanner(System.in);
		System.out.print("영어를 입력하시오(띄어쓰기 포함) : ");
		String str = sc.nextLine();
		
		// StringTokenizer를 통해 띄어쓰기를 기준으로 토큰 단위로 나온 것을 연산하는 메소드를 구성
		StringTokenizer stn = new StringTokenizer(str, " ");
		// 띄어쓰기 이후 첫 글자는 대문자로 되게 하고 그 외에 나머진 소문자로 해서 출력
		
//		while(stn.countTokens() > 0 ) {  >> 계산식을 매번돌림
		
		StringBuilder sb = new StringBuilder(); //값이 유동적인 글자열을 처리하기위해 빌더
		
		while(stn.hasMoreTokens()) {	
			String next = stn.nextToken();
			
			/*
			String result = next.substring(0,1).toUpperCase() + next.substring(1).toLowerCase();
			System.out.print(result+" ");
			*/
			
			sb.append(next.substring(0, 1).toUpperCase())  // 빌더에 append를 이용해 대입
	          .append(next.substring(1).toLowerCase())
	          .append(" ");
			
			System.out.println(sb.toString().trim()); // trim 이 맨 뒤에 붙어올 " "을 처리해줌
			
			
			
		}//while 문 종료
		System.out.println();
		
	}
	
	
	
}//클래스영역
