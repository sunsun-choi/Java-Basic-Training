package com.hw1.model.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileDao {//클래스영역시작
	
//	~ sc : Scanner // 입력을 위한 Scanner
	protected Scanner sc = new Scanner(System.in);
	
//	+ FileDao()
	public FileDao() {}

//	+ fileSave () : void
//	+ fileOpen () : void
//	+ fileEdit() : void
	
	//어떤 파일에 어떤 내용을 저장할지 입력 받아 파일 출력을 실	행하는 메소드
	public void fileSave() {
		
		StringBuilder sb = new StringBuilder();
		while(true) {
		// “파일에 저장할 내용을 반복해서 입력하시오("exit"을 입력하면 내용 입력 끝) :”
		// 값을 Scanner로 입력 받고 해당 입력 값이 “exit”일 경우 반복문 빠져나감
		// 아닐 경우 sb에 추가
			System.out.print("파일에 저장할 내용을 반복해서 입력하십시오(\"exit\"을 입력하면 내용 입력 끝) :");
			String fileString = sc.nextLine();
			if(fileString.equals("exit")) { break; }
			
			sb = sb.append(fileString + "\n");
			
		}
		// “저장하시겠습니까? (y/n)”
		// 입력 받은 값이 대문자이든 소문자이든 상관없이 “y”이면,
		// 저장할 파일명을 입력 받음
		System.out.print("저장하시겠습니까? (y/n)");
		String answer = sc.nextLine();
		
		if(answer.equals("y")||answer.equals("Y")) {
			System.out.print("저장할 파일명을 입력해주세요 : ");
			String fileName = sc.nextLine();
			File saveFile = new File(fileName + ".txt");
			
		
		
		BufferedWriter bw = null;
		FileWriter fw = null;
		
		try { // BufferedWriter와 FileWriter 스트림 사용
		// “입력받은 파일명.txt” 파일에 해당 sb 데이터출력
		// “입력받은 파일명.txt 파일에 성공적으로 저장하였습니다.” 콘솔창 출력
			saveFile.createNewFile();
			
			fw = new FileWriter(saveFile);
			bw = new BufferedWriter(fw);
			
			bw.write(sb.toString());
			
			System.out.println(fileName + ".txt 파일에 성공적으로 저장하였습니다.");
			
		}catch( IOException e ) {
			e.printStackTrace();
		}finally {
		// 열었던 스트림 close
			try { 
				bw.close();
				fw.close();
				}catch( IOException e ) {e.printStackTrace();}
		}
		}else {
			// 입력 받은 값이 y가 아니면 “다시 메뉴로 돌아갑니다.” 출력하고 메뉴로..
			System.out.println("다시 메뉴로 돌아갑니다");
			return;
		}
	}
	
	
	//원하는 파일을 파일 입력 후 콘솔 화면에 출력하는 메소드
	public void fileOpen() {
		// “열기 할 파일명 : “
		// 파일명을 Scanner로 입력 받아, BufferedReader와 FileReader 스트림 사용
		System.out.print("열기 할 파일명 : ");
		String openFileName = sc.nextLine();
		
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
		// try구문 안에서 readLine()메소드를 통해 한줄씩 콘솔로 입력받은 값 출력
			fr = new FileReader(openFileName + ".txt");
			br = new BufferedReader(fr);
			
			while(true) {
				String a = br.readLine();
				if(a.equals(null)) {break;}
				
				System.out.println(br.readLine());
			}
			
			
			
		}catch( FileNotFoundException e ) {
		// 존재하지 않은 파일 명 입력했을 때 해당 예외처리구문이 실행됨
		// “존재하는 파일이 없습니다.”
			System.out.println("존재하는 파일이 없습니다.");
			
		}catch( IOException e ) {
		e.printStackTrace();
		}finally {
		// 열었던 스트림 close
			try {
				br.close();
				fr.close();
			}catch( IOException e ) {e.printStackTrace();}
		}
	}
	
	
	
	//기존 파일을 입출력을 통해 내용을 추가해 수정하는 메소드
	public void fileEdit(){
		
		// “수정 할 파일명 : “
		// 파일명을 입력받아 BufferedReader와 BufferedWriter, FileReader와 FileWriter
		// 스트림 사용
		try {
		// 반복문을 통해 해당 파일의 내용을 readLine()메소드를 통해 콘솔에 출력
		// “파일에 추가할 내용을 입력하시오 : “
		// 사용자가 “exit”을 입력하기 전까지 내용을 StringBuilder에 담기
		// “변경된 내용을 파일에 추가하시겠습니까? (y/n)”
		// 입력 받은 값이 대문자이든 소문자이든 상관없이 “y”이면,
		// “입력받은 파일명.txt 파일의의 내용이 변경되었습니다.”
		}catch( FileNotFoundException e ) {
		e.printStackTrace();
		}catch( IOException e ) {
		e.printStackTrace();
		}finally {
		// 열었던 스트림 close
		}
		
	}

}//클래스영역종료
