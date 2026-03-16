package com.kh.mvc.model.vo;

public class Cart {
	private String menuName;
	private int price;
	private int count;
	
	public Cart() {}

	public Cart(String menuName, int price, int count) {
		super();
		this.menuName = menuName;
		this.price = price;
		this.count = count;
	}

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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return menuName +"  "+ count + " 개 " + (count*price) + " 원";
	}
	

}
