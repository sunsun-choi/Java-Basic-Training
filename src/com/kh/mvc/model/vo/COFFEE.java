package com.kh.mvc.model.vo;

public class COFFEE {//클래스영역시작
	//필드부
	private String menuName;
	private int price;
	private String desc;
	
	//생성자부
	public COFFEE() {}

	public COFFEE(String menuName, int price, String desc) {
		super();
		this.menuName = menuName;
		this.price = price;
		this.desc = desc;
	}
	
	//메소드부

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	//

	@Override
	public String toString() {
		return menuName;
	}
	
	
	

}//클래스영역끝
