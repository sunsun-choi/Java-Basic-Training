package com.hw2.run;

import com.hw2.model.dao.ScoreProcess;

public class Run {
	
	
	
	// ScoreProcess 클래스 객체 생성	후 각 메소드를 순차적으로 실행
	public static void main(String[] args) {
		
		ScoreProcess sp = new ScoreProcess();
		sp.scoreSave();
		sp.scoreRead();

	}

}
