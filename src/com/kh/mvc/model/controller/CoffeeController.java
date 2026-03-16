package com.kh.mvc.model.controller;

import java.util.ArrayList;

import com.kh.mvc.model.vo.COFFEE;
import com.kh.mvc.model.vo.Cart;

public class CoffeeController {//클래스 영역시작
	//필드부
	private ArrayList<Cart> cart = new ArrayList<>();
	private ArrayList<COFFEE> list = new ArrayList<>(); 
	{ //리스트 초기화
		list.add(new COFFEE("아이스 아메리카노(고소한맛)", 4500, 
				"과테말라 안티구아\n검은 고양이처럼 묵직하고 깊은 스모키한 고소함"));
		list.add(new COFFEE("아이스 아메리카노(산미)", 4500, 
				"에티오피아 예가체프\n화사한 꽃 향기와 싱그러운 과일의 산미"));
		list.add(new COFFEE("아이스 카페라떼", 5500, 
				"에스프레소의 진한 풍미와 부드러운 우유가 만나 완성된 궁극의 고소함"));
		list.add(new COFFEE("아이스 바닐라라떼", 5500, 
				"부드러운 우유 속에 스며든 천연 바닐라 빈의 향긋하고 포근한 달콤함"));
		list.add(new COFFEE("아이스 카라멜마끼야또", 6000, 
				"우유와 커피, 그리고 달콤한 카라멜의 조화"));
		list.add(new COFFEE("고양이 간식", 3000, 
				"신선한 참치의 풍미가 가득! 고양이들의 입맛을 단숨에 사로잡는 마성의 간식"));
	}
	
	//카페메뉴 키오스크로 보내기
	public ArrayList<COFFEE> cafeMenu(){
		return list;
	}
	
	//관리자-메뉴추가
	public int addMenu(String menuName, int price, String desc) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getMenuName().equals(menuName)) {return -1;}
		}
		//메뉴추가전 갯수
		int before = list.size();
		list.add(new COFFEE(menuName, price, desc));
		//메뉴추가후 갯수
		int after = list.size();
				
		return (after - before);
	}
	//관리자-메뉴조회
	public ArrayList<COFFEE> searchMenu(String keyword) {
		
		if(keyword.equals("*")) {return list;}
		
		ArrayList<COFFEE> searchlist = new ArrayList<>();
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getMenuName().contains(keyword)) {
				searchlist.add(list.get(i));
			}
		}
		return searchlist;
	}
	//관리자-메뉴수정
	public int setMenu(String menuName,String updateName,
			            int updateprice,String updatedesc) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getMenuName().equals(menuName)) {
				list.get(i).setMenuName(updateName);
				list.get(i).setPrice(updateprice);
				list.get(i).setDesc(updatedesc);
			return 1;
			}
		}
		return 0;
	}
	//관리자-메뉴삭제
	public int removeMenu(String menuName) {
		int count = 0;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getMenuName().equals(menuName)) {
				list.remove(i);
				i--;  //
				count++;
				break;
			}
		}
		return count;
	}
	
	//메뉴선택
	public String addCart(int menu) {
		String name = list.get(menu-1).getMenuName();
		
		for(Cart a : cart) {
			if(a.getMenuName().equals(name)) {
				a.setCount( a.getCount()+1 );
				return name;
			}
		}
		cart.add(new Cart(name, list.get(menu-1).getPrice(),1));
		return name;
	}
	//주문 조회
	public ArrayList<Cart> cartList(){

		return cart;
	}
	//주문 삭제
	public int removeCart(int removeCart) {
		if(removeCart > cart.size()||removeCart < 1) {
			return -1;
		}
		if(cart.get(removeCart-1).getCount() > 1) {
			cart.get(removeCart-1).setCount(cart.get(removeCart-1)
					                          .getCount()-1);
			return 1;
		}else {
			cart.remove(removeCart-1);
		}
		
		return 2;
	}
	
	//결제가격
	public int cartPrice() {
		int totalPrice = 0;
		for(Cart a : cart) {
			totalPrice += a.getPrice() * a.getCount();
		}
		return totalPrice;
	}
	
	
	
	
	
	
}//클래스영역종료
