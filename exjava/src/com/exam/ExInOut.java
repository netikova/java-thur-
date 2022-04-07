package com.exam;

import java.util.Scanner;

public class ExInOut {

	public static void main(String[] args) {
		// "좋아하는 음식을 입력하세요" 라고 출력
		System.out.println( "좋아하는 음식을 입력하세요" );
		// 입력한 음식을 변수에 저장
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		// "좋아하는 음식은 OOO입니다." 라고 출력
		System.out.println( "좋아하는 음식은 "+s+"입니다." );
		
		// "누구세요?" 라고 출력
		System.out.println( "누구세요?" );
		// 키보드로 이름을 입력
		String name = sc.nextLine();
		// "OOO님 환영합니다." 라고 출력
		System.out.println( name + "님 환영합니다." );
	}

}




