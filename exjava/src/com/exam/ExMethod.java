package com.exam;

public class ExMethod {

	public static void main(String[] args) {
		String s1 = "포로리";
		String s2 = "너부리";
		
		printWelcome( s1 );
		printWelcome( s2 );
		
		int a = add(3,4);
		System.out.println(a);
		
		printAdd(3,4);
		printAdd(6,7);
	}
	
	public static void printAdd( int a, int b ){
		System.out.println( a + " + " + b + " = " + (a+b) );
	}
	
	// 두 정수를 더해주는 함수 정의
	public static int add(int x, int y){
		int sum = x + y;
		return sum; // sum 변수의 값을 함수의 결과로 반환
	}
	
//	반환값 함수이름(받을값) {  함수내용  }
	public static void printWelcome(String s) {
		System.out.println("********************");
		System.out.println("* " + s + " 님 환영합니다 *");
		System.out.println("********************");
	}

}








