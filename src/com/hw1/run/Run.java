package com.hw1.run;

import java.util.Scanner;

import com.hw1.model.dao.FileDao;

public class Run {//클래스영역시작

	public static void main(String[] args) {
//		FileController 클래스 객체 생성	후 각 메소드를 메뉴 선택에 따라 실행
		
		Scanner sc = new Scanner(System.in);
		FileDao fd = new FileDao();
		
		while(true) {
		// 반복문을 통한 메뉴 실행
		// "****** MyNote ******"
		// "1. 노트 새로 만들기" // fd.fileSave() 실행
		// "2. 노트 열기" // fd.fileOpen() 실행
		// "3. 노트 열어서 수정하기" // fd.fileEdit() 실행
		// "4. 끝내기"
		// "번호를 입력하세요 : "
		System.out.println("****** MyNote ******");
		System.out.println("1. 노트 새로 만들기");
		System.out.println("2. 노트 열기");
		System.out.println("3. 노트 열어서 수정하기");
		System.out.println("4.끝내기");
		System.out.print("번호를 입력하세요 : ");
		int selectNum = sc.nextInt();
		sc.nextLine();
		
		if(selectNum == 1) { fd.fileSave(); }
		else if(selectNum == 2) { fd.fileOpen(); }
		else if(selectNum == 3) { fd.fileEdit(); }
		else if(selectNum == 4) { break; }
		else { System.out.println("잘못 입력하셨습니다."); }
		
		}
		
	}

}//클래스영역종료
