package practice1.model.vo;

public class Cat extends Animal{//클래스영역시작

	//필드부
	private String location;
	private String color;
	
	//생성자부
	public Cat() {}

	public Cat(String name, String kind, String location, String color) {
		super(name, kind);
		this.location = location;
		this.color = color;
	}
	
	//메소드부
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	//

	@Override
	public void speak() {
		System.out.println(super.toString()+location+"에 서식하며, 색상은 "
				+ color + "입니다.");
	}
	
	
	
	
	
	
	
	
	
	
}//클래스영역끝
