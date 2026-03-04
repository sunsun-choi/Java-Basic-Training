package com.kh.exveption.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

public class A_UncheckedException {//클래스 영역 시작

	public Scanner sc = new Scanner(System.in);
	
	
	public void method1() {//메소드1 시작
		
		// ArrayIndexOutOfBoundsException
		// NegativeArraySizeException
		
		int size = 0;
		
		while(true) {
			try { //try 에서 오류가 발생하는 순간 바로 catch 로 넘어간다
				System.out.print("배열의 크기 (1이상의 숫자를 입력해주세요) : "); //1.입력오류방지문구
				size = sc.nextInt(); //InputMismatchException
				sc.nextLine();
				if(size <= 0) {System.out.println("양수를 입력해주세요"); continue;} //NegativeArraySizeException
				break;
			}catch(InputMismatchException e) {
				System.out.println("숫자를 입력해주세요");
				sc.nextLine();
				continue;
			}
			
		}
		
		int[] arr = new int[size];
		
		int index = 0;
		while(true) {
			try { 
				System.out.print("호출할 인덱스(0이상의 숫자 입력) : ");
				index = sc.nextInt(); //InputMismatchException
				sc.nextLine(); 
				
				System.out.println(index + "번 인덱스의 값 : " + arr[index]); //ArrayIndexOutOfBoundsException
				break;
			}catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("배열의 크기를 벗어났습니다. 0에서부터 " + (size -1) + "까지의 인덱스를 호출해주세요.");
				
			}catch(InputMismatchException e) {
				System.out.println("숫자를 입력해주세요");
				sc.nextLine();
				continue;
			}
		}
		
		System.out.println("프로그램 종료"); //프로그램이 끝까지 진행됐는지 확인!
		
	}//메소드1 끝
	
	
	public void method2() {//메소드2 시작
		
		String str = "";
		int resurt = 0;
		
		while(true) {
			try {
			System.out.print("숫자로 변환할 문자열 (정수 형식) : ");
			str = sc.nextLine(); //InputMismatchException
			
			resurt = Integer.parseInt(str);//NumberFormatException
			
			System.out.println("변환할 수 있습니다.");
			System.out.println("결과 : " + resurt);
			
			break;
			}catch(InputMismatchException e) {
				System.err.println("변환할 수 없습니다. 문자열을 입력해주세요");
			}catch(NumberFormatException e) {
				System.out.println("변환할 수 없습니다. 입력값을 확인해주세요");
			}
			//catch 문은 끝나면 아래로 흐른다!!! 성공시 출력문은 try 에 써준다
		}
		
		
		// 실행결과)
		// 숫자로 변환할 문자열 : 123
		// 변환할수있습니다
		// 결과 : 123
		
		// 숫자로변환할문자열 : 1abc.1
		// 변환할수없습니다
		
		System.out.println("프로그램을 종료합니다.");
		
	}//메소드2 끝
	
	
	
	
}//클래스 영역 끝
