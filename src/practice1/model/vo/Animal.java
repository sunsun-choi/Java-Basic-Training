package practice1.model.vo;

public abstract class Animal {//클래스 영역 시작

	//필드부
	private String name;
	private String kind;
	
	//생성자부
	protected Animal() {}
	protected Animal(String name, String kind) {
		this.name = name;
		this.kind = kind;
	}
	
	//메소드부
	public void setName(String name) {
		this.name = name;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getName() {
		return name;
	}
	public String getKind() {
		return kind;
	}
	
	@Override
	public String toString() {
		return "저의 이름은" + name + "이고, 종류는 " + kind + "입니다.";
	}
	
	public abstract void speak();
	
	
	
	
	
	
}//클래스 영역 끝
