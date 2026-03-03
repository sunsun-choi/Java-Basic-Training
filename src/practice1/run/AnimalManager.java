package practice1.run;

import practice1.model.vo.Animal;
import practice1.model.vo.Cat;
import practice1.model.vo.Dog;

public class AnimalManager {//클래스영역시작

	public static void main(String[] args) {
		
		Animal[] animal = new Animal[5];
		animal[0] = new Dog("강아지0","코카",23);
		animal[1] = new Cat("고양이1","삼색","강남","흰색");
		animal[2] = new Dog("강아지2","코카",23);
		animal[3] = new Cat("고양이3","삼색","강남","흰색");
		animal[4] = new Dog("강아지4","코카",23);
		
		for(int i =0 ; i < animal.length; i++) {
			animal[i].speak();
		}
		
	}//메소드영역끝

}//클래스영역끝
