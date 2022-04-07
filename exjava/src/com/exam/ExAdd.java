package com.exam;

import java.util.Scanner;

public class ExAdd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// "x 값을 입력하세요" 라고 출력
		System.out.println("x 값을 입력하세요");
		// 키보드로 숫자을 입력받아서 변수 x에 저장
		String x = sc.nextLine();
		// 정수문자열을 정수로 변환
		int nx = Integer.parseInt( x ); 
		
		// "y 값을 입력하세요" 라고 출력
		System.out.println("y 값을 입력하세요");
		// 키보드로 숫자을 입력받아서 변수 y에 저장
		String y = sc.nextLine();
		// 정수문자열을 정수로 변환
		int ny = Integer.parseInt( y ); 
		
		// "x + y = OO" 라고 입력받은 두 수의 합을 출력
		System.out.println( x + " + " + y + " = " + (nx+ny) );

	}

}




