package com.hw3.view;

import java.util.Scanner;

import com.hw3.model.vo.Employee;

public class EmpMenu {//클래스영역시작
	
	//필드부
	private Scanner sc;
	
	//생성자부
	public EmpMenu() {}

	//메소드부
	public void mainMenu() {//사원정보관리메뉴 반복출력
		
		
		Employee emp = null;  //객체를 초기화
		Scanner sc = new Scanner(System.in);
			// 메뉴 화면 출력 --> 반복 실행 처리
		for( ;; ) {//for문 시작
			System.out.println("===== 사원 정보 관리 프로그램 =====");
			System.out.println("1. 새 사원 정보 입력");
			System.out.println("2. 사원 정보 수정");
			System.out.println("3. 사원 정보 삭제");
			System.out.println("4. 사원 정보 출력");
			System.out.println("9. 프로그램 종료");
			System.out.print("메뉴 번호 선택 : ");
			
			int selectNum = sc.nextInt();
			sc.nextLine();
		
			if(selectNum == 1) {
				emp = inputEmployee();  //inputEmployee 메소드호출
			}else if(selectNum == 2) {
			    modifyEmployee(emp);
			}else if(selectNum == 3) {
				emp = null; 
			}else if(selectNum == 4) {
				System.out.println(emp.information());
			}else if(selectNum == 9) {
				System.out.println("프로그램을 종료합니다");
				break;
			}else {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
			}
			continue;
		}//for문 종료
	}//mainMenu메소드영역 끝
	
	public Employee inputEmployee() {//메뉴1
		Scanner sc = new Scanner(System.in);
		
		System.out.print("사원명 : ");
		String empName = sc.nextLine();
		
		System.out.print("부서명 : ");
		String dept = sc.nextLine();
		
		System.out.print("직급 : ");
		String job = sc.nextLine();
		
		System.out.print("나이 : ");
		int age = sc.nextInt();
		sc.nextLine();
		
		System.out.print("성별(M/F) : ");
		char gender = sc.nextLine().charAt(0);
		
		System.out.print("급여 : ");
		int salary = sc.nextInt();
		sc.nextLine();
		
		System.out.print("보너스포인트 : ");
		double bonusPoint = sc.nextDouble();
		sc.nextLine();
		
		System.out.print("전화번호 : ");
		String phone = sc.nextLine();
		
		System.out.print("주소 : ");
		String address = sc.nextLine();
		
		Employee emp = new Employee(empName, dept, job, age, gender, 
				salary, bonusPoint, phone, address);
							
		return emp;
		
		}//inputEmployee메소드영역 끝
	
	
	public void modifyEmployee(Employee emp) {//메뉴2 반복출력
		// 서브 메뉴 화면 출력 --> 반복 실행 처리
		Scanner sc = new Scanner(System.in);
		
		for(;;) {//for문 시작
			System.out.println("==== 사원 정보 수정 메뉴 ====");
			System.out.println("1. 이름 변경");
			System.out.println("2. 급여 변경");
			System.out.println("3. 부서 변경");
			System.out.println("4. 직급 변경");
			System.out.println("9. 이전 메뉴로");
			System.out.print("메뉴 번호 선택 : ");
			
			int selectNum = sc.nextInt();
			sc.nextLine();
			
			if(selectNum == 1) {
				
				System.out.print("사원명 : ");
				String empName = sc.nextLine();
				emp.setEmpName(empName);
				
			}else if(selectNum == 2) {
				
				System.out.print("급여 : ");
				int salary = sc.nextInt();
				emp.setSalary(salary);
				
			}else if(selectNum == 3) {
				
				System.out.print("부서명 : ");
				String dept = sc.nextLine();
				emp.setDept(dept);
				
			}else if(selectNum == 4) {
				
				System.out.print("직급 : ");
				String job = sc.nextLine();
				emp.setJob(job);
				
			}else if(selectNum == 9) {
				return;
			}else {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
			}
			continue;
			
			
		}//for문 종료
		
		// 각 번호에 맞춰 변경할 값을 입력 받고 setter 메소드를 이용하여 수정
	}//modifyEmployee메소드영역끝
	
}//클래스영역끝
