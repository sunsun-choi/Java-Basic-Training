package com.kh.hw1.view;

import java.util.Scanner;

import com.kh.hw1.controller.TokenController;

public class TokenMenu {//클래스영역시작
	
	//view 클래스 
	/*
	 -sc:Scanner = new Scanner(System.in)
	 -tc:TokenController = new TokenController()
	 */
	private Scanner sc = new Scanner(System.in);
	private TokenController tc = new TokenController();
	//// 토큰컨트롤러 클래스를 new 확장자로 객체 생성함
	//// JVM이 자동으로 기본 생성자를 생성해 객체 생성 가능
	//// Scanner 로 받은 정보를 아래 다양한 메소드에서 활용하기 위함 
	//// 필드 복습 : 필드에는 메소드에서 공통적으로 사용할 변수를 지정해준다 
	
	
	/*
	 +mainMenu():void
     +tokenMenu():void
     +inputMenu():void
	 */
	
	//메인메뉴 출력
	public void mainMenu() {//메인메뉴 메소드 시작
		//아래의 메뉴 반복 실행
		
		/*
		1. 지정 문자열 -> tokenMenu() 실행
		2. 입력 문자열 -> inputMenu() 실행
		9. 프로그램 끝내기 -> "프로그램을 종료합니다." 출력 후 종료
		메뉴 번호 : 
		*/
		
		////예외처리를 한다면? 
		//// 1. 입력값이 null 이거나 숫자가 아닐경우를 예외로 둘 수 있음 
		//// 2. 입력한 숫자가 1,2,9 외의 숫자일 경우를 예외로 둘 수 있음 (반복문사용)
		/*
		while(true){
			System.out.println("1. 지정 문자열");
			System.out.println("2. 입력 문자열");
			System.out.println("9. 프로그램 끝내기");
			System.out.print("메뉴 번호 : ");
			
			try { 
				int menu = sc.nextInt();
				sc.nextLine();
			}catch(InputMismatchException e) {
				sc.nextLine();
				continue;
			}
			
			if(menu == 1) {
				tokenMenu();
				break;
			}else if(menu == 2) {
				inputMenu();
				break;
			}else if(menu == 9) {
				System.out.println("프로그램을 종료합니다");
				break;
			}else{
				System.out.println("잘못된 번호입니다");
				continue;
			}
		
		}//while문 종료
		
		*/
		
		while(true) {
			System.out.println("1. 지정 문자열");
			System.out.println("2. 입력 문자열");
			System.out.println("9. 프로그램 끝내기");
			System.out.print("메뉴 번호 : ");
			
			int menu = sc.nextInt();
			sc.nextLine();
			
			if(menu == 1) {
				tokenMenu();
				break;
			}else if(menu == 2) {
				inputMenu();
				break;
			}else if(menu == 9) {
				System.out.println("프로그램을 종료합니다");
				break;
			}
		
		}//while(true)문 종료

	}//메인메뉴메소드 끝
	
	//토큰결과 출력
	public void tokenMenu() {
		
		String str = "J a v a P r o g r a m";
		
		// Token 처리 전 글자와 글자 개수를 출력 (String str)
		
		System.out.println("토큰 처리 전 글자 : " + str);
		System.out.println("토큰 처리 전 개수 : " + str.length());
		
		// 위 str을 TokenController의 afterToken()메소드의 인자로 보내 반환 값 출력
		//// static 이 아닌 메소드는 반드시 new 로 객체 생성
		//// 필드부에 해당 클래스의 객체를 tc 로 생성함 tc.메소드명으로 메소드 호출
		
		str = tc.afterToken(str);
		System.out.println("토큰 처리 후 글자 : " + str);
		
		// 그 반환 값을 이용해 Token 처리 후 글자 개수와 대문자 변환한 것을 출력
		
		System.out.println("토큰 처리 후 개수 : " + str.length());
		System.out.println("모두 대문자로 변환 : " + str.toUpperCase());
		
		//메뉴 반복실행
		mainMenu();
		
		}//토큰메뉴 클래스 종료
	
	//첫 글자 대문자, 문자 개수 결과 출력
	public void inputMenu() {
		
		// 입력 받은 문자열을 TestController의 firstCap()의 인자로 보내 반환 값 출력
		
		System.out.print("문자열을 입력하세요 : ");
		String str = sc.nextLine();
		
		System.out.println("첫 글자 대문자 : " + tc.firstCap(str));
		
		// 찾을 문자 입력 받아 TestController의 findChar()의 매개변수로 아까 입력 받은 
		// 문자열과 문자 하나를 매개변수로 보내 반환 값 출력
		
		////예외처리를 한다면? 
		/// 1. 입력값이 null 이거나 String 이 아닐경우 다시 입력해주세요 출력 후 다시 시행
		/// 2. 문자열를 입력했을 경우 입력값.length() > 1  "문자 ' '를 검색합니다" 라고 출력 후 시행

		System.out.print("찾을 문자 하나를 입력하세요 : ");
		char ch = sc.nextLine().charAt(0);
		int count = tc.findChar(str, ch);
		
		////대문자 소문자 구분없이 찾으려면? str 과 ch 를 모두 대문자나 소문자로 변환 후 새로운 매게변수에 저장, 메소드 호출
		
		System.out.println(ch + "문자가 들어간 개수 : " + count);
		
		//메인메뉴 반복시행
		mainMenu();		
		
	}//인풋메뉴메소드 종료
	
	
	

}//클래스영역끝
