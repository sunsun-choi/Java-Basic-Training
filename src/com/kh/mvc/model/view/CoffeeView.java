package com.kh.mvc.model.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.mvc.model.controller.CoffeeController;
import com.kh.mvc.model.vo.COFFEE;
import com.kh.mvc.model.vo.Cart;

public class CoffeeView {//클래스영역시작
	//필드부
	private Scanner sc = new Scanner(System.in);
    private CoffeeController cc = new CoffeeController();
    private int orderNum = 1;
    
    //메인매뉴
	public void mainManu() {
		//메뉴 반복출력
		while(true) {
			System.out.println("~~★~~☆~고양이 카페~☆~~★~~");
			System.out.println("~~☆메뉴를 골라주세요☆~~");
			System.out.println("★ 1. 아이스 아메리카노(고소한맛)");
			System.out.println("★ 2. 아이스 아메리카노(산미)");
			System.out.println("★ 3. 아이스 카페라떼");
			System.out.println("★ 4. 아이스 바닐라라떼");
			System.out.println("★ 5. 아이스 카라멜마끼야또");
			System.out.println("★ 6. 고양이 간식");
			System.out.println("★ 7. 주문 수정");
			System.out.println("★ 8. 결 제");
			System.out.print("번호 :");
			
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1 : case 2 : case 3 : 
			case 4 : case 5 : 
			case 6 : 
				String result = cc.addCart(menu);
				System.out.println(result + "(이)가 카트에 담겼습니다.");
				break;
			case 7 : removeCart(); 
				break;
			case 8 : pay();
				break;
			case 1234 :  adminMenu();
				break;
			default : 
				System.out.println("없는 메뉴를 입력했습니다. 다시 입력해 주세요.");
			}
			
		}//while 끝
	}//메뉴메소드끝
	
	//관리자메뉴
	public void adminMenu() {
		while(true) {
			System.out.println("========================");
			System.out.println("관리자 메뉴입니다");
			System.out.println("1. 메뉴추가");
			System.out.println("2. 메뉴검색");
			System.out.println("3. 메뉴수정");
			System.out.println("4. 메뉴삭제");
			System.out.println("5. 홈으로 돌아가기");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1 : addMenu();
				break;
			case 2 : searchMenu();
				break;
			case 3 : setMenu();
				break;
			case 4 : removeMenu();
				break;
			case 5 : return;
			default : 
				System.out.println("없는 메뉴를 입력했습니다. 다시 입력해 주세요.");
			}
		}
	}//관리자메뉴선택끝
	
	//관리자-메뉴추가
	public void addMenu() {
		System.out.println("========================");
		System.out.println("메뉴 추가 화면입니다.");
		System.out.print("메뉴이름 : ");
		String menuName = sc.nextLine();
		System.out.print("메뉴가격 : ");
		int price = sc.nextInt();
		sc.nextLine();
		System.out.print("메뉴설명 : ");
		String desc = sc.nextLine();
		
		int result = cc.addMenu(menuName, price, desc);
		
		if(result > 0) { 
			System.out.println("성공적으로 추가되었습니다.");
			}else if(result < 0) {
				System.out.println(menuName + "는 이미 등록된 메뉴입니다. "
					             	+ "다른 이름을 입력해주세요.");
			}else {System.out.println("메뉴 추가에 실패했습니다.");}
	}
	//관리자-메뉴조회
	public void searchMenu() {
		System.out.println("========================");
		System.out.println("관리자 메뉴 조회 화면입니다.");
		System.out.print("찾을 메뉴(전체메뉴조회시 * 입력) : ");
		String keyword = sc.nextLine();
		
		ArrayList<COFFEE> searchMenu = cc.searchMenu(keyword);
		if(searchMenu.isEmpty()) {
			System.out.println("검색된 메뉴가 없습니다.");
		}else { 
			System.out.println("총 " + searchMenu.size() + "건이 검색되었습니다.");
			for(COFFEE c : searchMenu) {
				System.out.println(c);
			}
		}
	}
	//관리자-메뉴수정
	public void setMenu() {
		System.out.println("========================");
		System.out.println("관리자 메뉴수정 화면입니다");
		System.out.print("기존 메뉴명 : ");
		String menuName = sc.nextLine();
		System.out.print("수정할 메뉴명 : ");
		String updateName = sc.nextLine();
		System.out.print("수정할 가격 : ");
		int updateprice = sc.nextInt();
		sc.nextLine();
		System.out.print("수정할 설명 : ");
		String updatedesc = sc.nextLine();
		
		int result = cc.setMenu(menuName,updateName,updateprice
				                ,updatedesc);
		
		if(result > 0) {
			System.out.println("성공적으로 수정되었습니다.");	
		} else { 
			System.out.println("수정할 메뉴를을 찾지 못했습니다.");
		}
	}
	//관리자-메뉴삭제
	public void removeMenu() {
		System.out.println("========================");
		System.out.println("관리자 메뉴 삭제 화면입니다.");
		System.out.print("삭제할 메뉴명 : ");
		String menuName = sc.nextLine();
		
		int result = cc.removeMenu(menuName);
		
		if(result > 0) {
			System.out.println("성공적으로 삭제되었습니다.");
		}else {System.out.println("삭제할 메뉴를 찾지 못했습니다.");}
		
	}
	//주문 수정 삭제
	public void removeCart() {
		while(true) {
			System.out.println("========================");
			System.out.println("★☆주문 수정☆★");
			ArrayList<Cart> cartlist = cc.cartList();
			if(cartlist.isEmpty()) {
				System.out.println("장바구니가 비어있습니다. 홈화면으로 돌아갑니다.");
				return;
			}
			System.out.println("카트 목록");
			int num = 1;
			for(Cart a : cartlist) {
				System.out.println(num+". "+a);
				num++;
			}
			System.out.println("0. 홈으로 돌아가기");
			System.out.print("삭제할 메뉴 번호 : ");
			int removeMenu = sc.nextInt();
			sc.nextLine();
			if(removeMenu == 0) {return;}
			
			String removemenu = cartlist.get(removeMenu-1).getMenuName();
			int result = cc.removeCart(removeMenu);
			switch(result) {
			case -1 :
				System.out.println("잘못 입력하셨습니다."); break;
			case 1 :
				System.out.println(removemenu
						           + " 1개를 제거했습니다."); break;
			case 2 : 
				System.out.println(removemenu
						           + " (이)가 제거되었습니다."); break;
			}
		}
	}
	//결제메뉴
	public void pay() {
		System.out.println("========================");
		System.out.println("★☆ 결제 화면 입니다 ☆★");
		ArrayList<Cart> result = cc.cartList();
		if(result.isEmpty()) {
			System.out.println("장바구니가 비어있습니다.");
			return;}
		
		System.out.println("주문 메뉴 : ");
		for(Cart a : result) {
			System.out.println(a);
		}
		System.out.println("결제 금액 : " + cc.cartPrice()+"원");
		System.out.println("결제수단 선택");
		System.out.println("1.K pay");
		System.out.println("2.기프티콘");
		int num = sc.nextInt();
		sc.nextLine();
		switch(num) {
		case 1 : case 2 : 
			System.out.println("주문번호 : " + orderNum + "번");
			System.out.println("결제가 정상 처리되었습니다. 즐거운 시간 되세요!\n");
			orderNum++;
			break;
		default : 
			System.out.println("없는 메뉴를 입력했습니다. 다시 입력해 주세요.");
		}
	}

}//클래스영역끝
